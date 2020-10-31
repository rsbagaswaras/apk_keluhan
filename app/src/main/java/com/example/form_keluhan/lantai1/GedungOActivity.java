package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.form_keluhan.ClickableArea;
import com.example.form_keluhan.ClickableAreasImage;
import com.example.form_keluhan.FormActivity;
import com.example.form_keluhan.OnClickableAreaClickedListener;
import com.example.form_keluhan.R;
import com.example.form_keluhan.State;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import uk.co.senab.photoview.PhotoViewAttacher;

public class GedungOActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_o);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.o);

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
                case "GUDANG CAIRAN":
                    Intent G = new Intent(GedungOActivity. this, FormActivity.class);
                    G.putExtra("data1", "GUDANG CAIRAN");
                    startActivity(G);
                    break;

                case "R. REUSE":
                    Intent R = new Intent(GedungOActivity. this, FormActivity.class);
                    R.putExtra("data1", "R. REUSE");
                    startActivity(R);
                    break;

                case "R. KONSULTASI":
                    Intent K = new Intent(GedungOActivity. this, FormActivity.class);
                    K.putExtra("data1", "R. KONSULTASI");
                    startActivity(K);
                    break;

                case "NURSE STATION":
                    Intent N = new Intent(GedungOActivity. this, FormActivity.class);
                    N.putExtra("data1", "NURSE STATION");
                    startActivity(N);
                    break;

                case "R. GANTI":
                    Intent T = new Intent(GedungOActivity. this, FormActivity.class);
                    startActivity(T);
                    break;

                case "LAV":
                    Intent L = new Intent(GedungOActivity. this, FormActivity.class);
                    L.putExtra("data1", "LAV");
                    startActivity(L);
                    break;

                case "SH":
                    Intent H = new Intent(GedungOActivity. this, FormActivity.class);
                    H.putExtra("data1", "SH");
                    startActivity(H);
                    break;

                case "R. RO":
                    Intent O = new Intent(GedungOActivity. this, FormActivity.class);
                    O.putExtra("data1", "R. RO");
                    startActivity(O);
                    break;


            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(100, 40, 100, 50, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(100, 130, 100, 50, new State("R. REUSE")));
        clickableAreas.add(new ClickableArea(100, 260, 100, 50, new State("R. KONSULTASI")));
        clickableAreas.add(new ClickableArea(100, 430, 100, 50, new State("NURSE STATION")));

        clickableAreas.add(new ClickableArea(100, 600, 100, 50, new State("R. GANTI")));
        clickableAreas.add(new ClickableArea(100, 690, 100, 50, new State("LAV")));
        clickableAreas.add(new ClickableArea(100, 800, 100, 50, new State("SH")));
        clickableAreas.add(new ClickableArea(100, 870, 100, 50, new State("R. RO")));
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