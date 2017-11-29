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

public class ActivityTransaksi extends AppCompatActivity {
    EditText edtIdTransaksi, edtIdDonatur, edtIdPanti, edtSumbangan;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        edtIdTransaksi = (EditText) findViewById(R.id.edtIdTransaksi);
        edtIdDonatur = (EditText) findViewById(R.id.edtIdDonatur);
        edtIdPanti = (EditText) findViewById(R.id.edtIdPanti);
        edtSumbangan = (EditText) findViewById(R.id.edtSumbangan);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);
        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);
        Intent mIntent = getIntent();
        edtIdTransaksi.setText(mIntent.getStringExtra("id_transaksi"));
        edtIdDonatur.setText(mIntent.getStringExtra("id_donatur"));
        edtIdPanti.setText(mIntent.getStringExtra("id_panti"));
        edtSumbangan.setText(mIntent.getStringExtra("sumbangan"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelTransaksi> updatePembelianCall =
                        mApiInterface.putTransaksi(
                                edtIdTransaksi.getText().toString(),
                                edtIdDonatur.getText().toString(),
                                edtSumbangan.getText().toString(),
                                edtIdPanti.getText().toString());
                updatePembelianCall.enqueue(new Callback<PostPutDelTransaksi>() {
                    @Override
                    public void onResponse(Call<PostPutDelTransaksi> call,
                                           Response<PostPutDelTransaksi> response) {
                        tvMessage.setText(" Retrofit Update: " +
                                "\n " + " Status Update : "
                                +response.body().getStatus() +
                                "\n " + " Message Update : "+
                                response.body().getMessage());
                    }
                    @Override
                    public void onFailure(Call<PostPutDelTransaksi> call, Throwable t)
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
                Call<PostPutDelTransaksi> postTransaksiCall =
                        mApiInterface.postTransaksi(
                                edtIdTransaksi.getText().toString(),
                                edtIdDonatur.getText().toString(),
                                edtSumbangan.getText().toString(),
                                edtIdPanti.getText().toString());
                postTransaksiCall.enqueue(new Callback<PostPutDelTransaksi>() {
                    @Override
                    public void onResponse(Call<PostPutDelTransaksi> call,
                                           Response<PostPutDelTransaksi> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : "
                                +response.body().getStatus() +
                                "\n " + " Message Insert : "+
                                response.body().getMessage());
                    }
                    @Override
                    public void onFailure(Call<PostPutDelTransaksi> call, Throwable t)
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
                if (edtIdTransaksi.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelTransaksi> deleteTransaksi =
                            mApiInterface.deleteTransaksi(edtIdTransaksi.getText().toString());
                    deleteTransaksi.enqueue(new Callback<PostPutDelTransaksi>() {
                        @Override
                        public void onResponse(Call<PostPutDelTransaksi> call,
                                               Response<PostPutDelTransaksi> response) {
                            tvMessage.setText(" Retrofit Delete: " +
                                    "\n " + " Status Delete : "
                                    +response.body().getStatus() +
                                    "\n " + " Message Delete : "+
                                    response.body().getMessage());
                        }
                        @Override
                        public void onFailure(Call<PostPutDelTransaksi> call,
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