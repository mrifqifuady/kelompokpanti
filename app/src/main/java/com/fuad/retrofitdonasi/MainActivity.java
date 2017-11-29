package com.fuad.retrofitdonasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fuad.retrofitdonasi.Adapter.AdapterTransaksi;
import com.fuad.retrofitdonasi.Adapter.AdapterPanti;
import com.fuad.retrofitdonasi.Adapter.AdapterDonatur;
import com.fuad.retrofitdonasi.Rest.ApiClient;
import com.fuad.retrofitdonasi.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btGet;
    Button btGetPanti;
    Button btGetDonatur;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGet = (Button) findViewById(R.id.btGet);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetTransaksi> pembelianCall = mApiInterface.getTransaksi();
                pembelianCall.enqueue(new Callback<GetTransaksi>() {
                    @Override
                    public void onResponse(Call<GetTransaksi> call,
                                           Response<GetTransaksi> response) {
                        List<Transaksi> transaksiList =
                                response.body().getListDataTransaksi();
                        Log.d("Retrofit Get", "Jumlah data pembelian: " +
                                String.valueOf(transaksiList.size()));
                        mAdapter = new AdapterTransaksi(transaksiList);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                    @Override
                    public void onFailure(Call<GetTransaksi> call, Throwable t) {
// Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });
        btGetPanti = (Button) findViewById(R.id.btGetPanti);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btGetPanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetPanti> pantiCall = mApiInterface.getPanti();
                pantiCall.enqueue(new Callback<GetPanti>() {
                    @Override
                    public void onResponse(Call<GetPanti> call,
                                           Response<GetPanti> response) {
                        List<Panti> pantiList =
                                response.body().getListDataPanti();
                        Log.d("Retrofit Get", "Jumlah data pembelian: " +
                                String.valueOf(pantiList.size()));
                        mAdapter = new AdapterPanti(pantiList);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                    @Override
                    public void onFailure(Call<GetPanti> call, Throwable t) {
// Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });
        btGetDonatur = (Button) findViewById(R.id.btGetDonatur);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btGetDonatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetDonatur> donaturCall = mApiInterface.getDonatur();
                donaturCall.enqueue(new Callback<GetDonatur>() {
                    @Override
                    public void onResponse(Call<GetDonatur> call,
                                           Response<GetDonatur> response) {
                        List<Donatur> donaturList =
                                response.body().getListDataDonatur();
                        Log.d("Retrofit Get", "Jumlah data pembelian: " +
                                String.valueOf(donaturList.size()));
                        mAdapter = new AdapterDonatur(donaturList);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                    @Override
                    public void onFailure(Call<GetDonatur> call, Throwable t) {
// Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });
    }
}

