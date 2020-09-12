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

public class GedungTActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_t);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.t);

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
                case "R.DOKTER":
                    Intent K = new Intent(GedungTActivity. this, FormActivity.class);
                    startActivity(K);
                    break;

                case "R.KA INTALASI":
                    Intent G = new Intent(GedungTActivity. this, FormActivity.class);
                    startActivity(G);
                    break;

                case "SH":
                    Intent S = new Intent(GedungTActivity. this, FormActivity.class);
                    startActivity(S);
                    break;

                case "LAV":
                    Intent intent = new Intent(GedungTActivity. this, FormActivity.class);
                    startActivity(intent);
                    break;

                case "PANTRY":
                    Intent intent1 = new Intent(GedungTActivity. this, FormActivity.class);
                    startActivity(intent1);
                    break;

                case "R.ALAT & LINEN":
                    Intent intent2 = new Intent(GedungTActivity. this, FormActivity.class);
                    startActivity(intent2);
                    break;

                case "PERAWATAN KELAS 1":
                    Intent intent3 = new Intent(GedungTActivity. this, FormActivity.class);
                    startActivity(intent3);
                    break;


            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(480, 240, 50, 50, new State("R.DOKTER")));
        clickableAreas.add(new ClickableArea(480, 260, 50, 50, new State("R.KA INTALSI")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("SH")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("LAV")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("PANTRY")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("R.ALAT & LINEN")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("PERAWATAN KELAS 1")));


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