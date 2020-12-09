package com.example.form_keluhan.Fetching;

public class Fetch {

    private String tanggal_penyampaian;
    private String nama_responden;
    private String ruangan;
    private String keluhan;
    private String picture;
    private String kategori;

    Fetch(){

    }

    public Fetch(String tanggal_penyampaian, String nama, String ruangan,String kategori, String keluhan, String picture) {
        this.tanggal_penyampaian = tanggal_penyampaian;
        this.nama_responden = nama;
        this.ruangan = ruangan;
        this.kategori = kategori;
        this.keluhan = keluhan;
        this.picture = picture;
    }

    public String getTanggal_penyampaian() {
        return tanggal_penyampaian;
    }

    public String getNama_responden() {
        return nama_responden;
    }

    public String getRuangan() {
        return ruangan;
    }

    public String getKategori() {
        return kategori;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getPicture() {
        return picture;
    }

    public void setTanggal_penyampaian(String tanggal_penyampaian) {
        this.tanggal_penyampaian = tanggal_penyampaian;
    }

    public void setNama_responden(String nama_responden) {
        this.nama_responden = nama_responden;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
