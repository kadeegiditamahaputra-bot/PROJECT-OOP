package com.oop;
import java.util.Scanner;




public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner untuk input dari keyboard
        int pilihan; // variabel untuk menyimpan pilihan menu

        // Perulangan menu sampai user memilih "Keluar" (pilihan 5)
        do {
            // Tampilan menu
            System.out.println("\n========= MENU =========");
            System.out.println("1. Input Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Edit Barang");
            System.out.println("5. Keluar");
            System.out.println("========================");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt(); // baca angka pilihan dari user

            // Cek pilihan user
            switch (pilihan) {
                case 1:
                    // Input barang baru
                    System.out.print("Masukkan kode: ");
                    String kode = sc.next();
                    System.out.print("Masukkan nama: ");
                    String nama = sc.next();
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = sc.nextInt();
                    System.out.print("Masukkan harga: ");
                    double harga = sc.nextDouble();

                    // Panggil fungsi di Service untuk simpan ke database
                    Service.inputBarang(kode, nama, jumlah, harga);
                    break;

                case 2:
                    // Lihat semua barang di database
                    Service.lihatBarang();
                    break;

                case 3:
                    // Hapus barang berdasarkan kode
                    System.out.print("Masukkan kode barang yang ingin dihapus: ");
                    String kodeHapus = sc.next();
                    Service.hapusBarang(kodeHapus);
                    break;

                case 4:
                    // Edit barang berdasarkan kode
                    System.out.print("Masukkan kode barang yang ingin diedit: ");
                    String kodeEdit = sc.next();
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = sc.next();
                    System.out.print("Masukkan jumlah baru: ");
                    int jumlahBaru = sc.nextInt();
                    System.out.print("Masukkan harga baru: ");
                    double hargaBaru = sc.nextDouble();

                    Service.editBarang(kodeEdit, namaBaru, jumlahBaru, hargaBaru);
                    break;

                case 5:
                    // Keluar dari program
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    // Jika user pilih angka selain 1-5
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-5.");
                    break;
            }

        } while (pilihan != 5); // ulangi menu selama pilihan bukan 5

        sc.close(); // tutup scanner
    }
}