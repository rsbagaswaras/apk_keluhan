package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
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

import androidx.appcompat.app.AppCompatActivity;
import uk.co.senab.photoview.PhotoViewAttacher;

public class GedungJActivity extends AppCompatActivity implements OnClickableAreaClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_j);

        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.j);

        // Create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            switch (text) {
                case "LOKER PETUGAS":
                    Intent intent = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent);
                    break;

                    case "ICU INFEKSIUS":
                     Intent intent1 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent1);
                    break;

                    case "R.TRANSISI":
                     Intent intent2 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent2);
                    break;

                    case "NURSE STATION":
                      Intent intent3 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent3);
                    break;

                    case "HALL":
                     Intent intent4 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent4);
                    break;

                    case "LOKER UMUM":
                     Intent intent5 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent5);
                    break;

                    case "LOKER PETUGAS 1":
                     Intent intent6 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent6);
                    break;

                    case "R.OBAT":
                    Intent intent7 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent7);
                    break;

                    case "R.ALAT & LINEN":
                     Intent intent8 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent8);
                    break;

                    case "R.PERAWAT":
                     Intent intent9 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent9);
                    break;

                    case "PANTRY":
                      Intent intent10 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent10);
                    break;

                    case "SPOTCHECK":
                      Intent intent11 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent11);
                    break;


                    case "LAV":
                    Intent intent12 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent12);
                    break;


                    case "LAV 1":
                    Intent intent13 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent13);
                    break;


                    case "NICU":
                    Intent intent14 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent14);
                    break;

                    case "PICU":
                    Intent intent15 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent15);
                    break;

                    case "NURSE INFEKSIUS STATION":
                    Intent intent16 = new Intent(GedungJActivity. this, FormActivity.class);
                    startActivity(intent16);
                    break;




            }
        }
    }

    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("LOKER PETUGAS")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2684, new State("GUDANG CAIRAN")));




        return clickableAreas;
    }


}