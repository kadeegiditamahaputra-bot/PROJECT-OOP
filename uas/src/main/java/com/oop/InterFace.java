package com.oop;

/**
 * Interface = kontrak.
 * Isinya cuma daftar method yang WAJIB diimplementasi oleh class lain.
 * Jadi, Service.java nanti harus mengisi logika dari method-method ini.
 */
public interface InterFace {
    void inputBarang(String kode, String nama, int jumlah, double harga);
    void lihatBarang();
    void hapusBarang(String kode);
    void editBarang(String kode, String namaBaru, int jumlahBaru, double hargaBaru);
}