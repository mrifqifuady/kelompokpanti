package com.fuad.retrofitdonasi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 27/11/2017.
 */

public class Panti {
    @SerializedName("id_panti")
    private String id_panti;
    @SerializedName("nama_panti")
    private String nama_panti;
    @SerializedName("alamat_panti")
    private String alamat_panti;
    @SerializedName("no_telp")
    private String no_telp;
    public Panti() {}

    public Panti(String id_panti, String nama_panti,String alamat_panti, String no_telp) {
        this.id_panti = id_panti;
        this.nama_panti = nama_panti;
        this.alamat_panti = alamat_panti;
        this.no_telp = no_telp;
    }

    public String getId_panti() {
        return id_panti;
    }
    public void setId_panti(String id_panti) {
        this.id_panti = id_panti;
    }
    public String getNama_panti() {
        return nama_panti;
    }
    public void setNama_panti(String nama_panti) {
        this.nama_panti = nama_panti;}
    public String getAlamat_panti() {
        return alamat_panti;
    }
    public void setAlamat_panti(String alamat_panti) {
        this.alamat_panti = alamat_panti;
    }
    public String getNo_telp() {
        return no_telp;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
