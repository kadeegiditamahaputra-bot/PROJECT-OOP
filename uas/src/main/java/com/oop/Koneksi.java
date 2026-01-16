package com.oop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    // Konfigurasi database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "300126";
    private static final String URL = "jdbc:mysql://localhost:3306/UAS_OOP";

    // Method untuk mendapatkan koneksi
    public static Connection getKoneksi() {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi berhasil!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}