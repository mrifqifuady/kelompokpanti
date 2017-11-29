package com.fuad.retrofitdonasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fuad.retrofitdonasi.Rest.ApiClient;
import com.fuad.retrofitdonasi.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ASUS on 27/11/2017.
 */

public class ActivityDonatur extends AppCompatActivity {
    EditText edtIdDonatur, edtUsername,edtPassword, edtAlamat, edtNamaDonatur;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donatur);

        edtIdDonatur = (EditText) findViewById(R.id.edtIdDonatur);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtNamaDonatur = (EditText) findViewById(R.id.edtNamaDonatur);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);
        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);
        Intent mIntent = getIntent();
        edtIdDonatur.setText(mIntent.getStringExtra("id_donatur"));
        edtUsername.setText(mIntent.getStringExtra("username"));
        edtPassword.setText(mIntent.getStringExtra("password"));
        edtAlamat.setText(mIntent.getStringExtra("alamat"));
        edtNamaDonatur.setText(mIntent.getStringExtra("nama_donatur"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelDonatur> updatePembelianCall =
                        mApiInterface.putDonatur(
                                edtIdDonatur.getText().toString(),
                                edtUsername.getText().toString(),
                                edtPassword.getText().toString(),
                                edtNamaDonatur.getText().toString(),
                                edtAlamat.getText().toString());
                updatePembelianCall.enqueue(new Callback<PostPutDelDonatur>() {
                    @Override
                    public void onResponse(Call<PostPutDelDonatur> call,
                                           Response<PostPutDelDonatur> response) {
                        tvMessage.setText(" Retrofit Update: " +
                                "\n " + " Status Update : "
                                +response.body().getStatus() +
                                "\n " + " Message Update : "+
                                response.body().getMessage());
                    }
                    @Override
                    public void onFailure(Call<PostPutDelDonatur> call, Throwable t)
                    {
                        tvMessage.setText("Retrofit Update: \n Status Update :"+
                                t.getMessage());
                    }
                });
            }
        });
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelDonatur> postDonaturCall =
                        mApiInterface.postDonatur(
                                edtIdDonatur.getText().toString(),
                                edtUsername.getText().toString(),
                                edtPassword.getText().toString(),
                                edtNamaDonatur.getText().toString(),
                                edtAlamat.getText().toString());
                postDonaturCall.enqueue(new Callback<PostPutDelDonatur>() {
                    @Override
                    public void onResponse(Call<PostPutDelDonatur> call,
                                           Response<PostPutDelDonatur> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : "
                                +response.body().getStatus() +
                                "\n " + " Message Insert : "+
                                response.body().getMessage());
                    }
                    @Override
                    public void onFailure(Call<PostPutDelDonatur> call, Throwable t)
                    {
                        tvMessage.setText("Retrofit Insert: \n Status Insert :"+
                                t.getMessage());
                    }
                });
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtIdDonatur.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelDonatur> deleteDonatur =
                            mApiInterface.deleteDonatur(edtIdDonatur.getText().toString());
                    deleteDonatur.enqueue(new Callback<PostPutDelDonatur>() {
                        @Override
                        public void onResponse(Call<PostPutDelDonatur> call,
                                               Response<PostPutDelDonatur> response) {
                            tvMessage.setText(" Retrofit Delete: " +
                                    "\n " + " Status Delete : "
                                    +response.body().getStatus() +
                                    "\n " + " Message Delete : "+
                                    response.body().getMessage());
                        }
                        @Override
                        public void onFailure(Call<PostPutDelDonatur> call,
                                              Throwable t) {
                            tvMessage.setText("Retrofit Delete: \n Status Delete :"+
                                    t.getMessage());
                        }
                    });
                }else{
                    tvMessage.setText("id_pembelian harus diisi");
                }
            }
        });
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(mIntent);
            }
        });
    }
}