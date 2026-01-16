package com.oop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

    // Function: Input Barang
    public static void inputBarang(String kode, String nama, int jumlah, double harga) {
        String sql = "INSERT INTO barang (kode, nama, jumlah, harga) VALUES (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            ps.setString(2, nama);
            ps.setInt(3, jumlah);
            ps.setDouble(4, harga);

            ps.executeUpdate();
            System.out.println("Barang berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Gagal input barang: " + e.getMessage());
        }
    }

    // Function: Lihat Barang
    public static void lihatBarang() {
        String sql = "SELECT * FROM barang";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== Daftar Barang ===");
            while (rs.next()) {
                System.out.println("Kode   : " + rs.getString("kode"));
                System.out.println("Nama   : " + rs.getString("nama"));
                System.out.println("Jumlah : " + rs.getInt("jumlah"));
                System.out.println("Harga  : " + rs.getDouble("harga"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menampilkan barang: " + e.getMessage());
        }
    }

    // Function: Hapus Barang
    public static void hapusBarang(String kode) {
        String sql = "DELETE FROM barang WHERE kode = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Barang dengan kode " + kode + " berhasil dihapus!");
            } else {
                System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghapus barang: " + e.getMessage());
        }
    }

    // Function: Edit Barang
    public static void editBarang(String kode, String namaBaru, int jumlahBaru, double hargaBaru) {
        String sql = "UPDATE barang SET nama = ?, jumlah = ?, harga = ? WHERE kode = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, namaBaru);
            ps.setInt(2, jumlahBaru);
            ps.setDouble(3, hargaBaru);
            ps.setString(4, kode);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Barang dengan kode " + kode + " berhasil diupdate!");
            } else {
                System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengedit barang: " + e.getMessage());
        }
    }
}
