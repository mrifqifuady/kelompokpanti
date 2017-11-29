package com.fuad.retrofitdonasi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 27/11/2017.
 */

public class PostPutDelDonatur {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Donatur mDonatur;
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
    public Donatur getDonatur() {
        return mDonatur;
    }
    public void setDonatur(Donatur donatur) {
        mDonatur = donatur;
    }
}