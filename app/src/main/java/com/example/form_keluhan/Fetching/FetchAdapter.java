package com.example.form_keluhan.Fetching;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.form_keluhan.Form.Form;
import com.example.form_keluhan.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class FetchAdapter extends FirebaseRecyclerAdapter<Form,FetchAdapter.myviewholder> {

    public FetchAdapter(@NonNull FirebaseRecyclerOptions<Form> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final Form form) {
        holder.tgl_penyampaian.setText(form.getTanggal_penyampaian());
        holder.nama_responden.setText(form.getNama_responden());
        holder.ruangan.setText(form.getRuangan());
        holder.kategori.setText(form.getKategori());
        holder.keluhan.setText(form.getKeluhan());
        Glide.with(holder.img.getContext()).load(form.getPicture()).into(holder.img);

        //Agar button edit bisa diintent
            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                            .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                            .setExpanded(true,1100)
                            .create();
            //Proses saat edit text pada dialogcontent.xml bisa muncul
                View myview=dialogPlus.getHolderView();
                    final EditText tgl_penyampaian=myview.findViewById(R.id.tanggal_penyampaian);
                    final EditText nama_responden=myview.findViewById(R.id.nama_responden);
                    final EditText ruangan=myview.findViewById(R.id.ruangan);
                    final EditText kategori=myview.findViewById(R.id.kategori);
                    final EditText keluhan=myview.findViewById(R.id.keluhan);
                    Glide.with(holder.img.getContext()).load(form.getPicture()).into(holder.img);
                    EditText tanggal_dirubah=myview.findViewById(R.id.datedeparture);
                    Button submit=myview.findViewById(R.id.usubmit);

                    //Proses pemanggilan data pada card view dibagian form.java dengan menggunakaan getter setter nya
                    tgl_penyampaian.setText(form.getTanggal_penyampaian());
                    nama_responden.setText(form.getNama_responden());
                    ruangan.setText(form.getRuangan());
                    kategori.setText(form.getKategori());
                    keluhan.setText(form.getKeluhan());

                //dialogcontent.xml berhasil dimunculkan
                    dialogPlus.show();

                    //Proses agar button update bisa diintenkan
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Map<String,Object> map=new HashMap<>();
                                map.put("tgl_penyampaian",tgl_penyampaian.getText().toString());
                                map.put("nama_responden",nama_responden.getText().toString());
                                map.put("ruangan",ruangan.getText().toString());
                                map.put("kategori",kategori.getText().toString());
                                map.put("keluhan",keluhan.getText().toString());

                               //Data yang sudah diedit lalu berhasil di update akan otomatis berubah pada card view di fetching data
                                // dan juga pada firebase (data akan diperbaharui)
                                FirebaseDatabase.getInstance().getReference().child("RSBW_KELUHAN")
                                        .child(getRef(position).getKey()).updateChildren(map)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                dialogPlus.dismiss();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                dialogPlus.dismiss();
                                            }
                                        });


                            }
                        });
                }
            });

        //Proses Agar button delete bisa diklik
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                    builder.setTitle("Delete Data");
                    builder.setMessage("Delete....?");
                //Proses saat pengguna mengklik button YES maka data akan terhapus pada cardview difetching data dan firebase
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseDatabase.getInstance().getReference().child("RSBW_KELUHAN")
                                    .child(getRef(position).getKey()).removeValue();
                        }
                    });
                //Proses jika admin tidak jadi menghapus data maka akan kembali pada tambilan fetching data
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.show();
                }
            });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        //Deklarasi
        ImageView img,edit,imgg,delete;
        EditText myCalender;
        TextView tgl_penyampaian, nama_responden, ruangan, kategori, keluhan;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView)itemView.findViewById(R.id.imgFetch);
            tgl_penyampaian = (TextView)itemView.findViewById(R.id.tgl_penyampaian);
            nama_responden = (TextView)itemView.findViewById(R.id.nama_responden);
            ruangan = (TextView)itemView.findViewById(R.id.ruangan);
            kategori = (TextView)itemView.findViewById(R.id.kategori);
            keluhan = (TextView)itemView.findViewById(R.id.keluhan);
            imgg = (ImageView)itemView.findViewById(R.id.imgedit);

            edit = (ImageView)itemView.findViewById(R.id.editicon);
            delete =(ImageView)itemView.findViewById(R.id.deleteicon);

            myCalender = (EditText)itemView.findViewById(R.id.datedeparture);


        }
    }
}
