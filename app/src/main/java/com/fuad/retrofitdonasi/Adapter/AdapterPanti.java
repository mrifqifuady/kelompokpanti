package com.fuad.retrofitdonasi.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuad.retrofitdonasi.ActivityPanti;
import com.fuad.retrofitdonasi.R;
import com.fuad.retrofitdonasi.Panti;

import java.util.List;

/**
 * Created by ASUS on 27/11/2017.
 */

public class AdapterPanti extends RecyclerView.Adapter<AdapterPanti.MyViewHolder> {
    List<Panti> mPantiList;
    public AdapterPanti(List<Panti> pantiList) {
        mPantiList = pantiList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_panti,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdPanti.setText("Id panti : "+mPantiList.get(position).getId_panti());
        holder.mTextViewNamaPanti.setText("nama panti : "+mPantiList.get(position).getNama_panti());
        holder.mTextViewAlamatPanti.setText("alamat : "+mPantiList.get(position).getAlamat_panti());
        holder.mTextViewNoTelp.setText("telp : "+mPantiList.get(position).getNo_telp());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), ActivityPanti.class);
                mIntent.putExtra("id_panti",mPantiList.get(position).getId_panti());
                mIntent.putExtra("nama_panti",mPantiList.get(position).getNama_panti());
                mIntent.putExtra("alamat_panti",(mPantiList.get(position).getAlamat_panti()));
                mIntent.putExtra("no_telp",mPantiList.get(position).getNo_telp());
                view.getContext().startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mPantiList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdPanti, mTextViewNamaPanti,mTextViewNoTelp,mTextViewAlamatPanti;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdPanti = (TextView) itemView.findViewById(R.id.tvIdPanti);
            mTextViewNamaPanti = (TextView) itemView.findViewById(R.id.tvNamaPanti);
            mTextViewNoTelp = (TextView) itemView.findViewById(R.id.tvNoTelp);
            mTextViewAlamatPanti = (TextView) itemView.findViewById(R.id.tvAlamatPanti);
        }
    }
}