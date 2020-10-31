package com.example.form_keluhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FetchAdapter  extends RecyclerView.Adapter<FetchAdapter.MyViewHolder>{

    Context context;
    ArrayList<Form> form;

    public FetchAdapter(Context c , ArrayList<Form> f)
    {
        context = c;
        form = f;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tgl_penyampaian.setText(form.get(position).getTanggal_penyampaian());
        holder.nama_responden.setText(form.get(position).getNama_responden());
        holder.ruangan.setText(form.get(position).getRuangan());
        holder.kategori.setText(form.get(position).getKategori());
        holder.keluhan.setText(form.get(position).getKeluhan());
        Picasso.get().load(form.get(position).getPicture()).into(holder.img_keluhan);
    }

    @Override
    public int getItemCount() {
        return form.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tgl_penyampaian, nama_responden, ruangan, kategori, keluhan;
        ImageView img_keluhan;
        Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            tgl_penyampaian = (TextView) itemView.findViewById(R.id.tgl_penyampaian);
            nama_responden = (TextView) itemView.findViewById(R.id.nama_responden);
            ruangan = (TextView) itemView.findViewById(R.id.ruangan);
            kategori = (TextView) itemView.findViewById(R.id.kategori);
            
            img_keluhan = (ImageView) itemView.findViewById(R.id.img_keluhan);
            btn = (Button) itemView.findViewById(R.id.checkDetails);
        }
        public void onClick(final int position)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
