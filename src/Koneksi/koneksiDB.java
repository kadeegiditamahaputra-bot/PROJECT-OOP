package src.Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;


public class koneksiDB {

    public static Connection getKoneksi() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_barang";
            String user = "root";
            String pass = "";

            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Koneksi gagal");
            return null;
        }
    }
}
