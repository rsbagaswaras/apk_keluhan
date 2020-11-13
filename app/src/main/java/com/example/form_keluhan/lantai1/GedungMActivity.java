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

public class GedungMActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_m);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.m);

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
                case "DAPUR SUSU":
                    Intent intent = new Intent(GedungMActivity. this, FormActivity.class);
                    intent.putExtra("data1",  "DAPUR SUSU");
                    startActivity(intent);
                    break;

                case "R.BIDAN":
                    Intent intent1 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent1.putExtra("data1",  "R.BIDAN");
                    startActivity(intent1);
                    break;

                case "LAV":
                    Intent intent2 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent2.putExtra("data1",  "LAV");
                    startActivity(intent2);
                    break;

                case "COUNTER BIDAN":
                    Intent intent3 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent3.putExtra("data1",  "COUNTER BIDAN");
                    startActivity(intent3);
                    break;

                case "R.BAYI":
                    Intent intent4 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent4.putExtra("data1",  "R.BAYI");
                    startActivity(intent4);
                    break;

                case "INSTALASI KEBIDANAN":
                    Intent intent5 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent5.putExtra("data1",  "INSTALASI KEBIDANAN");
                    startActivity(intent5);
                    break;

                case "GUDANG":
                    Intent intent6 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent6.putExtra("data1",  "GUDANG");
                    startActivity(intent6);
                    break;

                case "R.DOKTER":
                    Intent intent7 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent7.putExtra("data1",  "R.DOKTER");
                    startActivity(intent7);
                    break;

                case "R.ISOLASI":
                    Intent intent8 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent8.putExtra("data1",  "R.ISOLASI");
                    startActivity(intent8);
                    break;

                case "VK.PATOLOGIS":
                    Intent intent9 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent9.putExtra("data1",  "VK.PATOLOGIS");
                    startActivity(intent9);
                    break;

                case "LAV 2":
                    Intent intent10 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent10.putExtra("data1",  "LAV 2");
                    startActivity(intent10);
                    break;

                case "LAV 3":
                    Intent intent11 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent11.putExtra("data1",  "LAV 3");
                    startActivity(intent11);
                    break;

                case "LAV 4":
                    Intent intent12 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent12.putExtra("data1",  "LAV 4");
                    startActivity(intent12);
                    break;

                case "R.BERSALIN":
                    Intent intent13 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent13.putExtra("data1",  "R.BERSALIN");
                    startActivity(intent13);
                    break;

                case "R.BERSALIN 2":
                    Intent intent14 = new Intent(GedungMActivity. this, FormActivity.class);
                    intent14.putExtra("data1",  "R.BERSALIN 2");
                    startActivity(intent14);
                    break;

            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(200, 150, 200, 260, new State("DAPUR SUSU")));
        clickableAreas.add(new ClickableArea(500, 150, 200, 250, new State("R.BIDAN")));
        clickableAreas.add(new ClickableArea(100, 580, 100, 100, new State("LAV")));
        clickableAreas.add(new ClickableArea(1400, 200, 100, 300, new State("COUNTER BIDAN")));
        clickableAreas.add(new ClickableArea(1700, 200, 100, 500, new State("R.BAYI")));
        clickableAreas.add(new ClickableArea(500, 580, 500, 150, new State("INSTALASI KEBIDANAN")));
        clickableAreas.add(new ClickableArea(190, 700, 300, 300, new State("GUDANG")));
        clickableAreas.add(new ClickableArea(400, 730, 300, 300, new State("R.DOKTER")));
        clickableAreas.add(new ClickableArea(190, 1500, 270, 300, new State("R.ISOLASI")));
        clickableAreas.add(new ClickableArea(420, 1550, 220, 300, new State("VK.PATOLOGIS")));
        clickableAreas.add(new ClickableArea(490, 1600, 100, 100, new State("LAV 2")));
        clickableAreas.add(new ClickableArea(530, 1600, 100, 100, new State("LAV 2")));
        clickableAreas.add(new ClickableArea(1500, 1000, 100, 300, new State("R.BERSALIN")));
        clickableAreas.add(new ClickableArea(1500, 1600, 100, 300, new State("R.BERSALIN 2")));



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