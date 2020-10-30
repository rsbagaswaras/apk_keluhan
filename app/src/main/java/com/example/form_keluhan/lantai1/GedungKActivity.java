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

public class GedungKActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_k);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.k);

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
                case "HEMATOLOGI":

                    Intent intent = new Intent(GedungKActivity. this, FormActivity.class);
                    intent.putExtra("data1",  "HEMATOLOGI");
                    startActivity(intent);
                    break;

                case "PATOLOGI ANATOMI":
                    Intent intent1 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent1);
                    break;

                case "SEROLOGI":
                    Intent intent2 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent2);
                    break;

                case "URINE & FACES":
                    Intent intent3 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent3);
                    break;

                case "GUDANG":
                    Intent intent4 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent4);
                    break;

                case "SAMPLE TAKING":
                    Intent intent5 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent5);
                    break;

                case "LAV PETUGAS":
                    Intent intent6 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent6);
                    break;

                case "LAV":
                    Intent intent7 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent7);
                    break;

                case "ADMIN BANK DARAH":
                    Intent intent8 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent8);
                    break;

                case "BANK DARAH":
                    Intent intent9 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent9);
                    break;

                case "R.TUNGGU":
                    Intent intent10 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent10);
                    break;

                case "R.REAGEN & ALAT":
                    Intent intent11 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent11);
                    break;

                case "R.ANALISIS":
                    Intent intent12 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent12);
                    break;

                case "KEPALA LAB /R DOKTER":
                    Intent intent13 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent13);
                    break;

                case "ADMIN":
                    Intent intent14 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent14);
                    break;

                case "PENDAFTARAN":
                    Intent intent15 = new Intent(GedungKActivity. this, FormActivity.class);
                    startActivity(intent15);
                    break;

            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(70, 100, 250, 400, new State("HEMATOLOGI")));
        clickableAreas.add(new ClickableArea(460, 100, 250, 400, new State("PATOLOGI ANATOMI")));
        clickableAreas.add(new ClickableArea(800, 100, 250, 400, new State("SEROLOGI")));
        clickableAreas.add(new ClickableArea(1400, 100, 250, 400, new State("URINE & FACES")));
        clickableAreas.add(new ClickableArea(1400, 580, 200, 150, new State("GUDANG")));
        clickableAreas.add(new ClickableArea(1450, 760, 200, 150, new State("SAMPLE TAKING")));
        clickableAreas.add(new ClickableArea(1400, 900, 100, 100, new State("LAV PETUGAS")));
        clickableAreas.add(new ClickableArea(1570, 900, 100, 200, new State("LAV")));
        clickableAreas.add(new ClickableArea(380, 900, 250, 220, new State("ADMIN BANK DARAH")));
        clickableAreas.add(new ClickableArea(0, 0, 100, 100, new State("BANK DARAH")));
        clickableAreas.add(new ClickableArea(70, 990, 250, 400, new State("R.TUNGGU")));
        clickableAreas.add(new ClickableArea(460, 990, 200, 200, new State("R.REAGEN & ALAT")));
        clickableAreas.add(new ClickableArea(460, 1200, 200, 200, new State("R.ANALISIS")));
        clickableAreas.add(new ClickableArea(0, 0, 100, 100, new State("KEPALA LAB /R DOKTER")));
        clickableAreas.add(new ClickableArea(0, 0, 100, 100, new State("ADMIN")));
        clickableAreas.add(new ClickableArea(0, 0, 100, 100, new State("PENDAFTARAN")));



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