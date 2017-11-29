package com.fuad.retrofitdonasi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ASUS on 27/11/2017.
 */

public class GetPanti {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Panti> listDataPanti;
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
    public List<Panti> getListDataPanti() {
        return listDataPanti;
    }
    public void setListDataPanti(List<Panti> listDataPanti) {
        this.listDataPanti = listDataPanti;
    }
}