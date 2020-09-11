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

            switch (text) {
                case "ADMIN":
                    Intent K = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(K);
                    break;

                case "US/TENS TRAKSI":
                    Intent G = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(G);
                    break;

                case "NWD SWD":
                    Intent S = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(S);
                    break;

                case "ES IR":
                    Intent intent = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(intent);
                    break;

                case "EXERCISE/PARALLEL BAR/WALL BAR/SHOULDER WHEEL":
                    Intent intent1 = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(intent1);
                    break;

                case "LAV 1":
                    Intent intent2 = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(intent2);
                    break;

                case "LAV 2":
                    Intent intent3 = new Intent(GedungPActivity. this, FormActivity.class);
                    startActivity(intent3);
                    break;

            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(480, 240, 50, 50, new State("ADMIN")));
        clickableAreas.add(new ClickableArea(480, 260, 50, 50, new State("US/TENS TRAKSI")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("NWD SWD")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("ES IR")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("EXERCISE/PARALLEL BAR/WALL BAR/SHOULDER WHEEL")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("LAV 1")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("LAV 2")));


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