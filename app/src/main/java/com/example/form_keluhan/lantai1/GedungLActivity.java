package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import uk.co.senab.photoview.PhotoViewAttacher;

public class GedungLActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_l);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.l);

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
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

            switch (text) {
                case "CT.SCAN":

                    Intent intent = new Intent(GedungLActivity. this, FormActivity.class);
                    intent.putExtra("data1",  "CT.SCAN");
                    startActivity(intent);
                    break;

                case "R.GANTI":
                    Intent intent1 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent1.putExtra("data1",  "R.GANTI");
                    startActivity(intent1);
                    break;

                case "TOILET":
                    Intent intent2 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent2.putExtra("data1",  "TOILET");
                    startActivity(intent2);
                    break;

                case "MAMMOGRAPHY":
                    Intent intent3 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent3.putExtra("data1",  "MAMMOGRAPHY");
                    startActivity(intent3);
                    break;

                case "R.MESIN":
                    Intent intent4 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent4.putExtra("data1",  "R.MESIN");
                    startActivity(intent4);
                    break;

                case "OPERATOR":
                    Intent intent5 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent5.putExtra("data1",  "OPERATOR");
                    startActivity(intent5);
                    break;

                case "KEPALA RADIOLOGI":
                    Intent intent6 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent6.putExtra("data1",  "KEPALA RADIOLOGI");
                    startActivity(intent6);
                    break;

                case "ADMIN":
                    Intent intent7 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent7.putExtra("data1",  "ADMIN");
                    startActivity(intent7);
                    break;

                case "NURSE STATION":
                    Intent intent8 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent8.putExtra("data1",  "NURSE STATION");
                    startActivity(intent8);
                    break;

                case "RO 1":
                    Intent intent9 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent9.putExtra("data1",  "RO 1");
                    startActivity(intent9);
                    break;

                case "R.GELAP":
                    Intent intent10 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent10.putExtra("data1",  "R.GELAP");
                    startActivity(intent10);
                    break;

                case "OPERATOR 1":
                    Intent intent11 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent11.putExtra("data1",  "OPERATOR 1");
                    startActivity(intent11);
                    break;

                case "RJK 2":
                    Intent intent12 = new Intent(GedungLActivity. this, FormActivity.class);
                    intent12.putExtra("data1",  "RJK 2");

                    startActivity(intent12);
                    break;




            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(300, 200, 300, 300, new State("CT.SCAN")));
        clickableAreas.add(new ClickableArea(1000, 150, 150, 150, new State("R.GANTI")));
        clickableAreas.add(new ClickableArea(1250, 120, 150, 150, new State("TOILET")));
        clickableAreas.add(new ClickableArea(1500, 250, 300, 300, new State("MAMMOGRAPHY")));
        clickableAreas.add(new ClickableArea(200, 900, 300, 300, new State("R.MESIN")));
        clickableAreas.add(new ClickableArea(800, 900, 300, 300, new State("OPERATOR")));
        clickableAreas.add(new ClickableArea(1500, 800, 300, 300, new State("KEPALA RADIOLOGI")));
        clickableAreas.add(new ClickableArea(1500, 1300, 300, 300, new State("ADMIN")));
        clickableAreas.add(new ClickableArea(1500, 1900, 200, 200, new State("NURSE STATION")));
        clickableAreas.add(new ClickableArea(300, 1400, 200, 200, new State("RO 1")));
        clickableAreas.add(new ClickableArea(200, 1800, 200, 200, new State("R.GELAP")));
        clickableAreas.add(new ClickableArea(500, 1800, 300, 200, new State("OPERATOR 1")));
        clickableAreas.add(new ClickableArea(240, 2300, 200, 200, new State("RJK 2")));






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