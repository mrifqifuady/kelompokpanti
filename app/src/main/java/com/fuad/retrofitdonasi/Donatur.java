package com.fuad.retrofitdonasi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 27/11/2017.
 */

public class Donatur {
    @SerializedName("id_donatur")
    private String id_donatur;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("nama_donatur")
    private String nama_donatur;
    @SerializedName("alamat")
    private String alamat;
    public Donatur() {}

    public Donatur(String id_donatur, String username,String password,String nama_donatur, String alamat) {
        this.id_donatur = id_donatur;
        this.username = username;
        this.nama_donatur = nama_donatur;
        this.password = password;
        this.alamat = alamat;
    }

    public String getId_donatur() {
        return id_donatur;
    }
    public void setId_donatur(String id_donatur) {
        this.id_donatur = id_donatur;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;}
    public String getNama_donatur() {
        return nama_donatur;
    }
    public void setNama_donatur(String nama_donatur) {
        this.nama_donatur = nama_donatur;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
