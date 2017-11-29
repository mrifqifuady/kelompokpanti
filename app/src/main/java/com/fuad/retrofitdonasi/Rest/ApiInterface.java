package com.fuad.retrofitdonasi.Rest;

import com.fuad.retrofitdonasi.GetTransaksi;
import com.fuad.retrofitdonasi.PostPutDelTransaksi;
import com.fuad.retrofitdonasi.GetPanti;
import com.fuad.retrofitdonasi.PostPutDelPanti;
import com.fuad.retrofitdonasi.GetDonatur;
import com.fuad.retrofitdonasi.PostPutDelDonatur;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by ASUS on 27/11/2017.
 */

public interface ApiInterface {
    @GET("Transaksi/user")
    Call<GetTransaksi> getTransaksi();

    @FormUrlEncoded
    @POST("Transaksi/user")
    Call<PostPutDelTransaksi> postTransaksi(@Field("id_transaksi") String idTransaksi, @Field("id_donatur") String idDonatur, @Field("sumbangan") String Sumbangan, @Field("id_panti") String idPanti);
    @FormUrlEncoded
    @PUT("Transaksi/user")
    Call<PostPutDelTransaksi> putTransaksi(@Field("id_transaksi") String idTransaksi, @Field("id_donatur") String idDonatur,  @Field("sumbangan") String Sumbangan, @Field("id_panti") String idPanti);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Transaksi/user", hasBody = true)
    Call<PostPutDelTransaksi> deleteTransaksi(@Field("id_transaksi") String idTransaksi);

    @GET("Panti/user")
    Call<GetPanti> getPanti();

    @FormUrlEncoded
    @POST("Panti/user")
    Call<PostPutDelPanti> postPanti(@Field("id_panti") String idPanti, @Field("nama_panti") String namaPanti, @Field("alamat_panti") String alamatPanti, @Field("no_telp") String noTelp);
    @FormUrlEncoded
    @PUT("Panti/user")
    Call<PostPutDelPanti> putPanti(@Field("id_panti") String idPanti, @Field("nama_panti") String namaPanti,  @Field("alamat_panti") String alamatPanti, @Field("no_telp") String noTelp);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Panti/user", hasBody = true)
    Call<PostPutDelPanti> deletePanti(@Field("id_panti") String idPanti);

    @GET("Donatur/user")
    Call<GetDonatur> getDonatur();

    @FormUrlEncoded
    @POST("Donatur/user")
    Call<PostPutDelDonatur> postDonatur(@Field("id_donatur") String idDonatur, @Field("username") String Username,@Field("password") String Password, @Field("nama_donatur") String namaDonatur, @Field("alamat") String Alamat);
    @FormUrlEncoded
    @PUT("Donatur/user")
    Call<PostPutDelDonatur> putDonatur(@Field("id_donatur") String idDonatur, @Field("username") String Username, @Field("password") String Password, @Field("nama_donatur") String namaDonatur, @Field("alamat") String Alamat);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Donatur/user", hasBody = true)
    Call<PostPutDelDonatur> deleteDonatur(@Field("id_donatur") String idDonatur);
}
