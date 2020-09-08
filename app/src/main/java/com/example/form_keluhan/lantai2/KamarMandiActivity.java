package com.example.form_keluhan.lantai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.form_keluhan.FormActivity;
import com.example.form_keluhan.R;
import com.example.form_keluhan.State;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;

public class KamarMandiActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamar_mandi);
    }

    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();

            switch (text) {
                case "KAMAR MANDI":
                    Intent intent = new Intent(KamarMandiActivity.this, FormActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(140, 70, 120, 120, new State("KAMAR MANDI")));

   return clickableAreas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}