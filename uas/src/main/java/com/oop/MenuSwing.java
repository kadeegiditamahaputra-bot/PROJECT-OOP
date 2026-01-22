package com.oop;
import javax.swing.*;


public class MenuSwing extends JFrame {
    private final Service service = new Service();

    public MenuSwing() {
        setTitle("Manajemen Barang");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");
        menu.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, java.awt.Color.BLACK));


        JMenuItem inputItem = new JMenuItem("Input Barang");
        inputItem.addActionListener(e -> {
            String kode = JOptionPane.showInputDialog(this, "Masukkan kode:");
            String nama = JOptionPane.showInputDialog(this, "Masukkan nama:");
            int jumlah = Integer.parseInt(JOptionPane.showInputDialog(this, "Masukkan jumlah:"));
            double harga = Double.parseDouble(JOptionPane.showInputDialog(this, "Masukkan harga:"));
            service.inputBarang(kode, nama, jumlah, harga);
        });

        
        JMenuItem lihatItem = new JMenuItem("Lihat Barang");
        lihatItem.addActionListener(e -> service.lihatBarang());

       
        JMenuItem hapusItem = new JMenuItem("Hapus Barang");
        hapusItem.addActionListener(e -> {
            String kode = JOptionPane.showInputDialog(this, "Masukkan kode barang yang ingin dihapus:");
            service.hapusBarang(kode);
        });

        
        JMenuItem editItem = new JMenuItem("Edit Barang");
        editItem.addActionListener(e -> {
            String kode = JOptionPane.showInputDialog(this, "Masukkan kode barang yang ingin diedit:");
            String namaBaru = JOptionPane.showInputDialog(this, "Masukkan nama baru:");
            int jumlahBaru = Integer.parseInt(JOptionPane.showInputDialog(this, "Masukkan jumlah baru:"));
            double hargaBaru = Double.parseDouble(JOptionPane.showInputDialog(this, "Masukkan harga baru:"));
            service.editBarang(kode, namaBaru, jumlahBaru, hargaBaru);
        });

        
        JMenuItem keluarItem = new JMenuItem("Keluar");
        keluarItem.addActionListener(e -> System.exit(0));
        

        menu.add(inputItem);
        menu.add(lihatItem);
        menu.add(hapusItem);
        menu.add(editItem);
        menu.add(keluarItem);
        
        menu.getPopupMenu().setBorder(
        BorderFactory.createMatteBorder(1, 1, 1, 1, java.awt.Color.BLACK)
        );

        menuBar.add(menu);
        setJMenuBar(menuBar);
        
    }
    
    public void tampilMenu() {
        setVisible(true);
    }

    
    public void run() {
        tampilMenu();
    }
}