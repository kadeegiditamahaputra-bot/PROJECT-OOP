package com.oop;
import javax.swing.*;


public class MenuSwing extends JFrame {
    private final Service service = new Service();

    public MenuSwing() {
        setTitle("Manajemen Barang");//judul pada jendela GUI.
        setExtendedState(JFrame.MAXIMIZED_BOTH);//Size jendela GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//tombol X kalau jendela ditutup, program langsung berhenti.

        // Buat menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");//tombol MENU
        menu.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.Color.BLACK));//kayak cssnya

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
        

        // Menambahkan semua item ke menu
        menu.add(inputItem);
        menu.add(lihatItem);
        menu.add(hapusItem);
        menu.add(editItem);
        menu.add(keluarItem);

        // Ubah border isi menu (dropdown)
        menu.getPopupMenu().setBorder(
        BorderFactory.createMatteBorder(1, 1, 1, 1, java.awt.Color.BLACK)
        );

        menuBar.add(menu);//isi menu bar dengan menu
        setJMenuBar(menuBar);//tampilkan menu bar di jendela.
    }

    
    public void tampilMenu() {
        setVisible(true); // tampilkan GUI, bawaan dari library Java (java.awt.Component).
    }

    
    public void prosesPilihan(int pilihan) {
        // Tidak dipakai di GUI
    }

    
    public void run() {
        tampilMenu();
    }
}