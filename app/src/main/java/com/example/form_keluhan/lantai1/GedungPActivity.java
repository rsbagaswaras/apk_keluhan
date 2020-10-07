package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

public class GedungPActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_p);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.p);

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
            Toast.makeText(this,text, Toast.LENGTH_SHORT).show();

            switch (text) {
                case "ADMIN":
                    Intent K = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(K);
                    break;

                case "US/TENSTRAKSI":
                    Intent U = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(U);
                    break;

                case "REHABILITASI MEDIK":
                    Intent R = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(R);
                    break;

                case "ES / IR":
                    Intent E = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(E);
                    break;

                case "EXERCISE/PARAREL BAR":
                    Intent B = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(B);
                    break;

                case "LAV":
                    Intent L = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(L);
                    break;
            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 724, 3264, new State("ADMIN")));
        clickableAreas.add(new ClickableArea(0, 0, 724, 3264, new State("US/TENSTRAKSI")));
        clickableAreas.add(new ClickableArea(0, 0, 724, 3264, new State("REHABILITASI MEDIK")));

        clickableAreas.add(new ClickableArea(0, 0, 724, 3264, new State("AES / IR")));
        clickableAreas.add(new ClickableArea(0, 0, 724, 3264, new State("EXERCISE/PARAREL BAR")));
        clickableAreas.add(new ClickableArea(0, 0, 724, 3264, new State("LAV")));

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