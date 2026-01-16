package com.oop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Service implements InterFace {

    @Override
    public void inputBarang(String kode, String nama, int jumlah, double harga) {
        String sql = "insert into barang (kode, nama, jumlah, harga) values (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            ps.setString(2, nama);
            ps.setInt(3, jumlah);
            ps.setDouble(4, harga);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal input barang: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void lihatBarang() {
        String sql = "select * from barang";
        StringBuilder data = new StringBuilder("=== Daftar Barang ===\n");
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                data.append("Kode   : ").append(rs.getString("kode")).append("\n");
                data.append("Nama   : ").append(rs.getString("nama")).append("\n");
                data.append("Jumlah : ").append(rs.getInt("jumlah")).append("\n");
                data.append("Harga  : ").append(rs.getDouble("harga")).append("\n");
                data.append("----------------------\n");
            }

            JOptionPane.showMessageDialog(null, data.toString(), "Data Barang", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan barang: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void hapusBarang(String kode) {
        String sql = "delete from barang where kode = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Barang dengan kode " + kode + " berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Barang dengan kode " + kode + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus barang: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void editBarang(String kode, String namaBaru, int jumlahBaru, double hargaBaru) {
        String sql = "update barang set nama = ?, jumlah = ?, harga = ? where kode = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, namaBaru);
            ps.setInt(2, jumlahBaru);
            ps.setDouble(3, hargaBaru);
            ps.setString(4, kode);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Barang dengan kode " + kode + " berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(null, "Barang dengan kode " + kode + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengedit barang: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}