package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Lantai2Activity extends AppCompatActivity implements OnClickableAreaClickedListener, com.example.form_keluhan.OnClickableAreaClickedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lantai2);

        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.lantai2);

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
                case "R.KOMITE MEDIK":
                    Intent intent = new Intent(Lantai2Activity.this, KomiteMedikActivity.class);
                    startActivity(intent);
                    break;

                case "R.ATK":
                    Intent intent1 = new Intent(Lantai2Activity.this, RekapMedikActivity.class);
                    startActivity(intent1);
                    break;

                case "KANTOR MANAJEMEN":
                    Intent intent2 = new Intent(Lantai2Activity.this, KasubacActivity.class);
                    startActivity(intent2);
                    break;

                case "AULA":
                    Intent intent3 = new Intent(Lantai2Activity.this, AuditoriumActivity.class);
                    startActivity(intent3);
                    break;

                case "R.DIREKTUR":
                    Intent intent4 = new Intent(Lantai2Activity.this, RuangDirekturActivity.class);
                    startActivity(intent4);
                    break;

                case "R.RAPAT AKREDITASI":
                    Intent intent5 = new Intent(Lantai2Activity.this, RuangAkreditasiActivity.class);
                    startActivity(intent5);
                    break;

                case "KAMAR MANDI":
                    Intent intent6 = new Intent(Lantai2Activity.this, KamarMandiActivity.class);
                    startActivity(intent6);
                    break;

                case "RUANG PANEL LISTRIK":
                    Intent intent7 = new Intent(Lantai2Activity.this, PanelListrikActivity.class);
                    startActivity(intent7);
                    break;

            }


        }

    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(140, 70, 120, 120, new State("R.KOMITE MEDIK")));
        clickableAreas.add(new ClickableArea(770, 83, 100, 100, new State("R.ATK")));
        clickableAreas.add(new ClickableArea(820, 350, 120, 120, new State("KANTOR MANAJEMEN")));

        clickableAreas.add(new ClickableArea(155, 350, 120, 120, new State("AULA")));
        clickableAreas.add(new ClickableArea(720, 850, 120, 120, new State("R.DIREKTUR")));
        clickableAreas.add(new ClickableArea(570, 1050, 120, 120, new State("R.RAPAT AKREDITASI")));

        clickableAreas.add(new ClickableArea(376, 1020, 100, 100, new State("KAMAR MANDI")));
        clickableAreas.add(new ClickableArea(376, 820, 100, 100, new State("RUANG PANEL LISTRIK")));


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


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
