package com.fuad.retrofitdonasi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 27/11/2017.
 */

public class PostPutDelPanti {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Panti mPanti;
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
    public Panti getPanti() {
        return mPanti;
    }
    public void setPanti(Panti panti) {
        mPanti = panti;
    }
}


