package com.example.form_keluhan.Fetching;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.form_keluhan.Form.Form;
import com.example.form_keluhan.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class FetchAdapter extends FirebaseRecyclerAdapter<Form,FetchAdapter.myviewholder> {

    public FetchAdapter(@NonNull FirebaseRecyclerOptions<Form> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Form form) {
        holder.tgl_penyampaian.setText(form.getTanggal_penyampaian());
        holder.nama_responden.setText(form.getNama_responden());
        holder.ruangan.setText(form.getRuangan());
        holder.kategori.setText(form.getKategori());
        holder.keluhan.setText(form.getKeluhan());
        Glide.with(holder.img.getContext()).load(form.getPicture()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tgl_penyampaian, nama_responden, ruangan, kategori, keluhan;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView)itemView.findViewById(R.id.imgFetch);
            tgl_penyampaian = (TextView)itemView.findViewById(R.id.tgl_penyampaian);
            nama_responden = (TextView)itemView.findViewById(R.id.nama_responden);
            ruangan = (TextView)itemView.findViewById(R.id.ruangan);
            kategori = (TextView)itemView.findViewById(R.id.kategori);
            keluhan = (TextView)itemView.findViewById(R.id.keluhan);
        }
    }
}
