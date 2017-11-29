package com.fuad.retrofitdonasi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ASUS on 27/11/2017.
 */

public class GetDonatur {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Donatur> listDataDonatur;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Donatur> getListDataDonatur() {
        return listDataDonatur;
    }
    public void setListDataDonatur(List<Donatur> listDataDonatur) {
        this.listDataDonatur = listDataDonatur;
    }
}