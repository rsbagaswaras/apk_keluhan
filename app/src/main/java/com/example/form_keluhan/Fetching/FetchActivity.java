package com.example.form_keluhan.Fetching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;


import com.example.form_keluhan.Form.Form;
import com.example.form_keluhan.MainActivity;
import com.example.form_keluhan.RegLogin.LoginActivity;
import com.example.form_keluhan.R;
import com.firebase.ui.auth.AuthUI;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class FetchActivity extends AppCompatActivity {

    RecyclerView recview;
    FetchAdapter fetchAdapter;
    private boolean doubleBacktoExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        //database yg akan dibuat pada fetching
        FirebaseRecyclerOptions<Form> options =
                new FirebaseRecyclerOptions.Builder<Form>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("RSBW_KELUHAN"), Form.class)
                        .build();

        //memanggil data fetch adapter yang akan ditampilkan di fetching
        fetchAdapter = new FetchAdapter(options);
        recview.setAdapter(fetchAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        fetchAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fetching_drawer, menu);

        MenuItem menuItem = menu.findItem(R.id.nav_search);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s){

            processsearch(s);
            return false;
        }
            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<Form> options =
                new FirebaseRecyclerOptions.Builder<Form>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("RSBW_KELUHAN").orderByChild("ruangan").startAt(s).endAt(s+"\uf8ff"),Form.class)
                .build();

        fetchAdapter = new FetchAdapter(options);
        fetchAdapter.startListening();
        recview.setAdapter(fetchAdapter);

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

    @Override
    public void onBackPressed() {
        if (doubleBacktoExit){
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }

        this.doubleBacktoExit = true;
        Toast.makeText(this, "Tekan Lagi Untuk Keluar",Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBacktoExit = false;
            }
        }, 2000);
    }

}