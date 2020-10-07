package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.form_keluhan.ClickableArea;
import com.example.form_keluhan.ClickableAreasImage;
import com.example.form_keluhan.FormActivity;
import com.example.form_keluhan.Lantai2Activity;
import com.example.form_keluhan.OnClickableAreaClickedListener;
import com.example.form_keluhan.R;
import com.example.form_keluhan.State;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import uk.co.senab.photoview.PhotoViewAttacher;

public class GedungQActivity extends AppCompatActivity implements OnClickableAreaClickedListener {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_q);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.q);

        // Create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    // Listen for touches on your images:
    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();

            switch (text) {
                case "NS":
                    Intent G = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(G);
                    break;

                case "R. PERAWAT":
                    Intent R = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(R);
                    break;

                case "R. DOKTER":
                    Intent K = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(K);
                    break;

                case "R. KA INSTALASI":
                    Intent N = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(N);
                    break;

                case "TOILET":
                    Intent T = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(T);
                    break;

                case "R ALAT & LINEN":
                    Intent L = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(L);
                    break;

                case "PANTRY":
                    Intent H = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(H);
                    break;

                case "LAV":
                    Intent O = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(O);
                    break;

                case "SH":
                    Intent A = new Intent(GedungQActivity. this, FormActivity.class);
                    startActivity(A);
                    break;


            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("NS")));
        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("R. PERAWAT")));
        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("R. DOKTER")));
        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("R. KA INSTALASI")));

        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("TOILET")));
        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("R ALAT & LINEN")));
        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("PANTRY")));
        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("LAV")));

        clickableAreas.add(new ClickableArea(0, 0, 1895, 3264, new State("SH")));

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