package com.example.form_keluhan.lantai2;

import android.content.Intent;
import android.os.Bundle;

import com.example.form_keluhan.FormActivity;
import com.example.form_keluhan.R;
import com.example.form_keluhan.State;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;

public class RekapMedikActivity extends AppCompatActivity  implements OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekapmedik);
    }

    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();

            switch (text) {
                case "R.KOMITE MEDIK":
                    Intent intent = new Intent(RekapMedikActivity.this, FormActivity.class);
                    startActivity(intent);
                    break;
            }
        }

    }


    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(140, 70, 120, 120, new State("REKAP MEDIK")));
return clickableAreas;
    }
}