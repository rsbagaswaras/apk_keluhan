package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.form_keluhan.Clickable.ClickableArea;
import com.example.form_keluhan.Clickable.ClickableAreasImage;
import com.example.form_keluhan.Form.FormActivity;
import com.example.form_keluhan.Clickable.OnClickableAreaClickedListener;
import com.example.form_keluhan.R;
import com.example.form_keluhan.Clickable.State;

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

    //Listen for touches on your image:
    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            switch (text) {

                case "GUDANG CAIRAN":
                    Intent K = new Intent(GedungJActivity. this, FormActivity.class);
                    K.putExtra("data1", "GUDANG CAIRAN");
                    startActivity(K);

                case "LOKER PETUGAS":
                    Intent intent = new Intent(GedungJActivity. this, FormActivity.class);
                    intent.putExtra("data1",  "LOKER PETUGAS");
                    startActivity(intent);
                    break;

                    case "ICU INFEKSIUS":
                     Intent intent1 = new Intent(GedungJActivity. this, FormActivity.class);
                     intent1.putExtra("data1",  "ICU INFEKSIUS");
                    startActivity(intent1);
                    break;

                    case "R.TRANSISI":
                     Intent intent2 = new Intent(GedungJActivity. this, FormActivity.class);
                     intent2.putExtra("data1",  "R.TRANSISI");
                    startActivity(intent2);
                    break;

                    case "NURSE STATION":
                      Intent intent3 = new Intent(GedungJActivity. this, FormActivity.class);
                      intent3.putExtra("data1",  "NURSE STATION");
                    startActivity(intent3);
                    break;

                    case "HALL":
                     Intent intent4 = new Intent(GedungJActivity. this, FormActivity.class);
                     intent4.putExtra("data1",  "HALL");
                    startActivity(intent4);
                    break;

                    case "LOKER UMUM":
                     Intent intent5 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent5.putExtra("data1",  "LOKER UMUM");
                    startActivity(intent5);
                    break;

                    case "LOKER PETUGAS 1":
                     Intent intent6 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent6.putExtra("data1",  "LOKER PETUGAS 1");
                    startActivity(intent6);
                    break;

                    case "R.OBAT":
                    Intent intent7 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent7.putExtra("data1",  "R.OBAT");
                    startActivity(intent7);
                    break;

                    case "R.ALAT & LINEN":
                     Intent intent8 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent8.putExtra("data1",  "R.ALAT & LINEN");
                    startActivity(intent8);
                    break;

                    case "R.PERAWAT":
                     Intent intent9 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent9.putExtra("data1",  "R.PERAWAT");
                    startActivity(intent9);
                    break;

                    case "PANTRY":
                      Intent intent10 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent10.putExtra("data1",  "PANTRY");
                    startActivity(intent10);
                    break;

                    case "SPOTCHECK":
                      Intent intent11 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent11.putExtra("data1",  "SPOTCHECK");
                    startActivity(intent11);
                    break;


                    case "LAV":
                    Intent intent12 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent12.putExtra("data1",  "LAV");
                    startActivity(intent12);
                    break;


                    case "LAV 1":
                    Intent intent13 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent13.putExtra("data1",  "LAV 1");
                    startActivity(intent13);
                    break;


                    case "NICU":
                    Intent intent14 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent14.putExtra("data1",  "NICU");
                    startActivity(intent14);
                    break;

                    case "PICU":
                    Intent intent15 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent15.putExtra("data1",  "PICU");
                    startActivity(intent15);
                    break;

                    case "NURSE INFEKSIUS STATION":
                    Intent intent16 = new Intent(GedungJActivity. this, FormActivity.class);
                        intent16.putExtra("data1",  "NURSE INFEKSIUS STATION");
                    startActivity(intent16);
                    break;




            }
        }
    }
//untuk menentukan titik koordinat disesuaikan dengan nama state nya
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(100, 10, 200, 200, new State("LOKER PETUGAS")));
        clickableAreas.add(new ClickableArea(100, 200, 200, 200, new State("ICU INFEKSIUS")));
        clickableAreas.add(new ClickableArea(100, 200, 200, 200, new State("R.TRANSISI")));
        clickableAreas.add(new ClickableArea(100, 300, 200, 200, new State("NURSE STATION")));
        clickableAreas.add(new ClickableArea(100, 400, 200, 200, new State("HALL")));
        clickableAreas.add(new ClickableArea(100, 500,200, 200, new State("LOKER UMUM")));
        clickableAreas.add(new ClickableArea(100, 600, 200, 200, new State("LOKER PETUGAS 1")));
        clickableAreas.add(new ClickableArea(100, 700, 200, 200, new State("R.OBAT")));
        clickableAreas.add(new ClickableArea(100, 800, 200, 200, new State("R.ALAT & LINEN")));
        clickableAreas.add(new ClickableArea(100, 900, 200, 200, new State("R.PERAWAT")));
        clickableAreas.add(new ClickableArea(100, 1000, 200, 200, new State("PANTRY")));
        clickableAreas.add(new ClickableArea(100, 600, 200, 200, new State("SPOTCHECK")));
        clickableAreas.add(new ClickableArea(100, 650, 200, 200, new State("LAV")));
        clickableAreas.add(new ClickableArea(100, 700, 200, 200, new State("LAV 1")));
        clickableAreas.add(new ClickableArea(100, 750, 200, 200, new State("NICU")));
        clickableAreas.add(new ClickableArea(100, 800, 200, 200, new State("PICU")));
        clickableAreas.add(new ClickableArea(100, 850, 200, 200, new State("NURSE INFEKSIUS STATION")));




        return clickableAreas;
    }


}