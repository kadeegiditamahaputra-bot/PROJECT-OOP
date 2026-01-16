package src.Menu;

import java.util.Scanner;
import src.BarangService.barangservice;

public class Menu {

    public void tampilMenu() {

        Scanner sc = new Scanner(System.in);
        barangservice bs = new barangservice();
        int pilih;

        do {
            System.out.println("\n=== MENU BARANG ===");
            System.out.println("1. Input");
            System.out.println("2. Tampil");
            System.out.println("3. Edit");
            System.out.println("4. Hapus");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    bs.inputBarang();
                    break;
                case 2:
                    bs.tampilBarang();
                    break;
                case 3:
                    bs.editBarang();
                    break;
                case 4:
                    bs.hapusBarang();
                    break;
                case 5:
                    System.out.println("Selesai");
                    break;
                default:
                    System.out.println("Menu salah");
            }
        } while (pilih != 5);
    }
}
