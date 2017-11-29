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

public class ActivityPanti extends AppCompatActivity {
    EditText edtIdPanti, edtNamaPanti, edtNoTelp, edtAlamatPanti;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panti);

        edtIdPanti = (EditText) findViewById(R.id.edtIdPanti);
        edtNamaPanti = (EditText) findViewById(R.id.edtNamaPanti);
        edtNoTelp = (EditText) findViewById(R.id.edtNoTelp);
        edtAlamatPanti = (EditText) findViewById(R.id.edtAlamatPanti);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);
        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);
        Intent mIntent = getIntent();
        edtIdPanti.setText(mIntent.getStringExtra("id_panti"));
        edtNamaPanti.setText(mIntent.getStringExtra("nama_panti"));
        edtNoTelp.setText(mIntent.getStringExtra("no_telp"));
        edtAlamatPanti.setText(mIntent.getStringExtra("alamat_panti"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelPanti> updatePembelianCall =
                        mApiInterface.putPanti(
                                edtIdPanti.getText().toString(),
                                edtNamaPanti.getText().toString(),
                                edtAlamatPanti.getText().toString(),
                                edtNoTelp.getText().toString());
                updatePembelianCall.enqueue(new Callback<PostPutDelPanti>() {
                    @Override
                    public void onResponse(Call<PostPutDelPanti> call,
                                           Response<PostPutDelPanti> response) {
                        tvMessage.setText(" Retrofit Update: " +
                                "\n " + " Status Update : "
                                +response.body().getStatus() +
                                "\n " + " Message Update : "+
                                response.body().getMessage());
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPanti> call, Throwable t)
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
                Call<PostPutDelPanti> postPantiCall =
                        mApiInterface.postPanti(
                                edtIdPanti.getText().toString(),
                                edtNamaPanti.getText().toString(),
                                edtAlamatPanti.getText().toString(),
                                edtNoTelp.getText().toString());
                postPantiCall.enqueue(new Callback<PostPutDelPanti>() {
                    @Override
                    public void onResponse(Call<PostPutDelPanti> call,
                                           Response<PostPutDelPanti> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : "
                                +response.body().getStatus() +
                                "\n " + " Message Insert : "+
                                response.body().getMessage());
                    }
                    @Override
                    public void onFailure(Call<PostPutDelPanti> call, Throwable t)
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
                if (edtIdPanti.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelPanti> deletePanti =
                            mApiInterface.deletePanti(edtIdPanti.getText().toString());
                    deletePanti.enqueue(new Callback<PostPutDelPanti>() {
                        @Override
                        public void onResponse(Call<PostPutDelPanti> call,
                                               Response<PostPutDelPanti> response) {
                            tvMessage.setText(" Retrofit Delete: " +
                                    "\n " + " Status Delete : "
                                    +response.body().getStatus() +
                                    "\n " + " Message Delete : "+
                                    response.body().getMessage());
                        }
                        @Override
                        public void onFailure(Call<PostPutDelPanti> call,
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