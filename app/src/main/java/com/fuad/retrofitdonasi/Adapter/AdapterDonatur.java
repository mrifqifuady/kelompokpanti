package com.fuad.retrofitdonasi.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuad.retrofitdonasi.ActivityDonatur;
import com.fuad.retrofitdonasi.Donatur;
import com.fuad.retrofitdonasi.R;

import java.util.List;

/**
 * Created by ASUS on 27/11/2017.
 */

public class AdapterDonatur extends RecyclerView.Adapter<AdapterDonatur.MyViewHolder> {
    List<Donatur> mDonaturList;
    public AdapterDonatur(List<Donatur> donaturList) {
        mDonaturList = donaturList;
    }
    @Override
    public AdapterDonatur.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_donatur,parent,false);
        AdapterDonatur.MyViewHolder mViewHolder = new AdapterDonatur.MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(AdapterDonatur.MyViewHolder holder, final int position) {
        holder.mTextViewIdDonatur.setText("Id donatur : "+mDonaturList.get(position).getId_donatur());
        holder.mTextViewUsername.setText("username : "+mDonaturList.get(position).getUsername());
        holder.mTextViewPassword.setText("password : "+mDonaturList.get(position).getPassword());
        holder.mTextViewNamaDonatur.setText("alamat : "+mDonaturList.get(position).getNama_donatur());
        holder.mTextViewAlamat.setText("telp : "+mDonaturList.get(position).getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), ActivityDonatur.class);
                mIntent.putExtra("id_donatur",mDonaturList.get(position).getId_donatur());
                mIntent.putExtra("username",mDonaturList.get(position).getUsername());
                mIntent.putExtra("password",mDonaturList.get(position).getPassword());
                mIntent.putExtra("nama_donatur",(mDonaturList.get(position).getNama_donatur()));
                mIntent.putExtra("alamat",mDonaturList.get(position).getAlamat());
                view.getContext().startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDonaturList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdDonatur, mTextViewUsername,mTextViewPassword,mTextViewAlamat,mTextViewNamaDonatur;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdDonatur = (TextView) itemView.findViewById(R.id.tvIdDonatur);
            mTextViewUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            mTextViewPassword = (TextView) itemView.findViewById(R.id.tvPassword);
            mTextViewAlamat = (TextView) itemView.findViewById(R.id.tvAlamat);
            mTextViewNamaDonatur = (TextView) itemView.findViewById(R.id.tvNamaDonatur);
        }
    }
}