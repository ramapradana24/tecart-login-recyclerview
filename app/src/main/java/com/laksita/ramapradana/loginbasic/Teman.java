package com.laksita.ramapradana.loginbasic;

public class Teman {
    private String nama;
    private String alamat;
    private String telp;

    public Teman(String nama, String alamat, String telp) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelp() {
        return telp;
    }
}
