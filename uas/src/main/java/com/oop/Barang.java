package com.oop;



public class Barang {
    // Atribut (fields)
    private String kode;
    private String nama;
    private int jumlah;
    private double harga;

    // Constructor
    public Barang(String kode, String nama, int jumlah, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    // Getter
    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getHarga() {
        return harga;
    }
}