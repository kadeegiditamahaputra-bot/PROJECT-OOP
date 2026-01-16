package com.oop;
import javax.swing.*;


public class MenuSwing extends JFrame implements Menuinterface {
    private final InterFace service = new Service();

    public MenuSwing() {
        setTitle("Menu Barang (GUI)");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buat menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        menu.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.Color.BLACK));

        // Input Barang
        JMenuItem inputItem = new JMenuItem("Input Barang");
        inputItem.addActionListener(e -> {
            String kode = JOptionPane.showInputDialog(this, "Masukkan kode:");
            String nama = JOptionPane.showInputDialog(this, "Masukkan nama:");
            int jumlah = Integer.parseInt(JOptionPane.showInputDialog(this, "Masukkan jumlah:"));
            double harga = Double.parseDouble(JOptionPane.showInputDialog(this, "Masukkan harga:"));
            service.inputBarang(kode, nama, jumlah, harga);
        });

        // Lihat Barang
        JMenuItem lihatItem = new JMenuItem("Lihat Barang");
        lihatItem.addActionListener(e -> service.lihatBarang());

        // Hapus Barang
        JMenuItem hapusItem = new JMenuItem("Hapus Barang");
        hapusItem.addActionListener(e -> {
            String kode = JOptionPane.showInputDialog(this, "Masukkan kode barang yang ingin dihapus:");
            service.hapusBarang(kode);
        });

        // Edit Barang
        JMenuItem editItem = new JMenuItem("Edit Barang");
        editItem.addActionListener(e -> {
            String kode = JOptionPane.showInputDialog(this, "Masukkan kode barang yang ingin diedit:");
            String namaBaru = JOptionPane.showInputDialog(this, "Masukkan nama baru:");
            int jumlahBaru = Integer.parseInt(JOptionPane.showInputDialog(this, "Masukkan jumlah baru:"));
            double hargaBaru = Double.parseDouble(JOptionPane.showInputDialog(this, "Masukkan harga baru:"));
            service.editBarang(kode, namaBaru, jumlahBaru, hargaBaru);
        });

        // Keluar
        JMenuItem keluarItem = new JMenuItem("Keluar");
        keluarItem.addActionListener(e -> System.exit(0));

        // Tambahkan semua item ke menu
        menu.add(inputItem);
        menu.add(lihatItem);
        menu.add(hapusItem);
        menu.add(editItem);
        menu.add(keluarItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    @Override
    public void tampilMenu() {
        setVisible(true); // tampilkan GUI
    }

    @Override
    public void prosesPilihan(int pilihan) {
        // Tidak dipakai di GUI
    }

    @Override
    public void run() {
        tampilMenu();
    }
}