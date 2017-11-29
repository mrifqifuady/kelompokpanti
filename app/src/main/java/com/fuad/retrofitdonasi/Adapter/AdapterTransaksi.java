package com.fuad.retrofitdonasi.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuad.retrofitdonasi.ActivityTransaksi;
import com.fuad.retrofitdonasi.R;
import com.fuad.retrofitdonasi.Transaksi;

import java.util.List;

/**
 * Created by ASUS on 27/11/2017.
 */

public class AdapterTransaksi extends RecyclerView.Adapter<AdapterTransaksi.MyViewHolder> {
    List<Transaksi> mTransaksiList;
    public AdapterTransaksi(List<Transaksi> transaksiList) {
        mTransaksiList = transaksiList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_transaksi,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdTransaksi.setText("Id Transaksi : "+mTransaksiList.get(position).getId_transaksi());
        holder.mTextViewIdDonatur.setText("Id Donatur : "+mTransaksiList.get(position).getId_donatur());
        holder.mTextViewSumbangan.setText("Sumbangan : "+String.valueOf(mTransaksiList.get(position).getSumbangan()));
        holder.mTextViewIdPanti.setText("Id panti : "+mTransaksiList.get(position).getId_panti());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), ActivityTransaksi.class);
                mIntent.putExtra("id_transaksi",mTransaksiList.get(position).getId_transaksi());
                mIntent.putExtra("id_donatur",mTransaksiList.get(position).getId_donatur());
                mIntent.putExtra("sumbangan",String.valueOf(mTransaksiList.get(position).getSumbangan()));
                mIntent.putExtra("id_panti",mTransaksiList.get(position).getId_panti());
                view.getContext().startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mTransaksiList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdTransaksi, mTextViewIdDonatur,mTextViewIdPanti,mTextViewSumbangan;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdTransaksi = (TextView) itemView.findViewById(R.id.tvIdTransaksi);
            mTextViewIdDonatur = (TextView) itemView.findViewById(R.id.tvIdDonatur);
            mTextViewIdPanti = (TextView) itemView.findViewById(R.id.tvIdPanti);
            mTextViewSumbangan = (TextView) itemView.findViewById(R.id.tvSumbangan);
        }
    }
}
