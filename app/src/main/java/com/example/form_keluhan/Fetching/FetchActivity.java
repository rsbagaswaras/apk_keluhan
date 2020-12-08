package com.example.form_keluhan.Fetching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import com.example.form_keluhan.Form.Form;
import com.example.form_keluhan.LoginActivity;
import com.example.form_keluhan.R;
import com.example.form_keluhan.lantai1.Lantai1Activity;
import com.example.form_keluhan.lantai2.Lantai2Activity;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FetchActivity extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        Query query = FirebaseDatabase.getInstance().getReference().child("Keluhan");

        lv = findViewById(R.id.Listview);

        FirebaseListOptions<Form> options = new FirebaseListOptions.Builder<Form>()
                .setLayout(R.layout.cardview)
                .setQuery(query,Form.class)
                .build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                TextView tgl_penyampaian = v.findViewById(R.id.tgl_penyampaian);
                TextView nama = v.findViewById(R.id.nama_responden);
                TextView ruangan = v.findViewById(R.id.ruangan);
                TextView kategori = v.findViewById(R.id.kategori);
                TextView keluhan = v.findViewById(R.id.keluhan);

                Form form = (Form) model;
                tgl_penyampaian.setText(form.getTanggal_penyampaian().toString());
                nama.setText(form.getNama_responden().toString());
                ruangan.setText(form.getRuangan().toString());
                kategori.setText(form.getKategori().toString());
                keluhan.setText(form.getKeluhan().toString());
            }
        };
        lv.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fetching_drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_Logout) {
            signOut();
        }
        return super.onOptionsItemSelected(item);
    }

    private void signOut(){
        AuthUI.getInstance()
                .signOut(FetchActivity.this)
                .addOnCompleteListener(new OnCompleteListener<Void>(){

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent loginActivity = new Intent(FetchActivity.this, LoginActivity.class);
                        startActivity(loginActivity);
                        finish();
                    }
                });
    }
}