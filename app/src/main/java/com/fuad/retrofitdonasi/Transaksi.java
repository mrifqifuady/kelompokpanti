package com.fuad.retrofitdonasi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 27/11/2017.
 */

public class Transaksi {
    @SerializedName("id_transaksi")
    private String id_transaksi;
    @SerializedName("id_donatur")
    private String id_donatur;
    @SerializedName("sumbangan")
    private int sumbangan;
    @SerializedName("id_panti")
    private String id_panti;
    public Transaksi() {}

    public Transaksi(String id_transaksi, String id_donatur,int sumbangan, String id_panti) {
        this.id_transaksi = id_transaksi;
        this.id_donatur = id_donatur;
        this.sumbangan = sumbangan;
        this.id_panti = id_panti;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }
    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    public String getId_donatur() {
        return id_donatur;
    }
    public void setId_donatur(String id_donatur) {
        this.id_donatur = id_donatur;}
    public int getSumbangan() {
        return sumbangan;
    }
    public void setSumbangan(int sumbangan) {
        this.sumbangan = sumbangan;
    }
    public String getId_panti() {
        return id_panti;
    }
    public void setId_panti(String id_panti) {
        this.id_panti = id_panti;
    }
}
