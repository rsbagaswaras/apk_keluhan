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
                    startActivity(intent);
                    break;

                case "R.GANTI":
                    Intent intent1 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent1);
                    break;

                case "TOILET":
                    Intent intent2 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent2);
                    break;

                case "MAMMOGRAPHY":
                    Intent intent3 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent3);
                    break;

                case "R.MESIN":
                    Intent intent4 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent4);
                    break;

                case "OPERATOR":
                    Intent intent5 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent5);
                    break;

                case "KEPALA RADIOLOGI":
                    Intent intent6 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent6);
                    break;

                case "ADMIN":
                    Intent intent7 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent7);
                    break;

                case "NURSE STATION":
                    Intent intent8 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent8);
                    break;

                case "RO 1":
                    Intent intent9 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent9);
                    break;

                case "R.GELAP":
                    Intent intent10 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent10);
                    break;

                case "OPERATOR 1":
                    Intent intent11 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent11);
                    break;

                case "RJK 2":
                    Intent intent12 = new Intent(GedungLActivity. this, FormActivity.class);
                    startActivity(intent12);
                    break;




            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("CT.SCAN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("R.GANTI")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("TOILET")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("MAMMOGRAPHY")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("R.MESIN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("OPERATOR")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("KEPALA RADIOLOGI")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("ADMIN")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("NURSE STATION")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("RO 1")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("R.GELAP")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("OPERATOR 1")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2713, new State("RJK 2")));






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