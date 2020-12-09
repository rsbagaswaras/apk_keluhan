package com.example.form_keluhan.Fetching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FetchActivity extends AppCompatActivity {

    RecyclerView recview;
    FetchAdapter fetchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        recview = (RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Form> options =
                new FirebaseRecyclerOptions.Builder<Form>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("RSBW_KELUHAN"), Form.class)
                        .build();

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