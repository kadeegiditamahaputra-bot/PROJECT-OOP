package src.BarangService;
import java.sql.*;
import java.util.Scanner;
import src.Koneksi.koneksiDB;

public class barangservice {

    Connection conn = koneksiDB.getKoneksi();
    Scanner sc = new Scanner(System.in);

    // INPUT
    public void inputBarang() {
        try {
            System.out.print("Nama Barang : ");
            String nama = sc.nextLine();

            System.out.print("Stok Barang : ");
            int stok = sc.nextInt();
            sc.nextLine();

            String sql = "INSERT INTO barang VALUES (NULL, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, stok);
            ps.executeUpdate();

            System.out.println("Data berhasil disimpan");
        } catch (Exception e) {
            System.out.println("Gagal input");
        }
    }

    // READ
    public void tampilBarang() {
        try {
            String sql = "SELECT * FROM barang";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- DATA BARANG ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + ". " +
                    rs.getString("nama") +
                    " | Stok: " + rs.getInt("stok")
                );
            }
        } catch (Exception e) {
            System.out.println("Gagal tampil");
        }
    }

    // UPDATE
    public void editBarang() {
        tampilBarang();

        try {
            System.out.print("ID Barang : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nama Baru : ");
            String nama = sc.nextLine();

            System.out.print("Stok Baru : ");
            int stok = sc.nextInt();
            sc.nextLine();

            String sql = "UPDATE barang SET nama=?, stok=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, stok);
            ps.setInt(3, id);
            ps.executeUpdate();

            System.out.println("Data berhasil diubah");
        } catch (Exception e) {
            System.out.println("Gagal edit");
        }
    }

    // DELETE
    public void hapusBarang() {
        tampilBarang();

        try {
            System.out.print("ID Barang : ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "DELETE FROM barang WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Data berhasil dihapus");
        } catch (Exception e) {
            System.out.println("Gagal hapus");
        }
    }
}
