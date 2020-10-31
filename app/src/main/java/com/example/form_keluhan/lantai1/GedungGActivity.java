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

public class GedungGActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_g);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.g);

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
                case "TRANSFER STRECHER KELUAR":
                    Intent intent = new Intent(GedungGActivity. this, FormActivity.class);
                    intent.putExtra("data1", "TRANSFER STRECHER KELUAR");
                    startActivity(intent);
                    break;

                case "COUNTER":
                    Intent intent1 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent1.putExtra("data1", "COUNTER");
                    startActivity(intent1);
                    break;

                case "ADMIN":
                    Intent intent2 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent2.putExtra("data1", "ADMIN");
                    startActivity(intent2);
                    break;

                case "TRANSFER STRECHER MASUK":
                    Intent intent3 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent3.putExtra("data1", "TRANSFER STRECHER MASUK");
                    startActivity(intent3);
                    break;

                case "R.KONSULTASI":
                    Intent intent4 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent4.putExtra("data1", "R.KONSULTASI");
                    startActivity(intent4);
                    break;

                case "GUDANG":
                    Intent intent5 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent5.putExtra("data1", "GUDANG");
                    startActivity(intent5);
                    break;

                case "SH":
                    Intent intent6 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent6.putExtra("data1", "SH");
                    startActivity(intent6);
                    break;

                case "LOKER LAKI LAKI":
                    Intent intent7 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent7.putExtra("data1", "LOKER LAKI-LAKI");
                    startActivity(intent7);
                    break;

                case "LOKER PEREMPUAN":
                    Intent intent8 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent8.putExtra("data1", "LOKER PEREMPUAN");
                    startActivity(intent8);
                    break;

                case "PANTRY":
                    Intent intent9 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent9.putExtra("data1", "PANTRY");
                    startActivity(intent9);
                    break;

                case "R.DOKTER PEREMPUAN":
                    Intent intent10 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent10.putExtra("data1", "R.DOKTOR PEREMPUAN");
                    startActivity(intent10);
                    break;

                case "R.DISKUSI":
                    Intent intent11 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent11.putExtra("data1", "R.DISKUSI");
                    startActivity(intent11);
                    break;

                case "R.DOKTER LAKI LAKI":
                    Intent intent12 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent12.putExtra("data1", "R.DOKTOR LAKI-LAKI");
                    startActivity(intent12);
                    break;

                case "RECOVERY":
                    Intent intent13 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent13.putExtra("data1", "RECOVERY");
                    startActivity(intent13);
                    break;

                case "R.PERSIAPAN":
                    Intent intent14 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent14.putExtra("data1", "R.PERSIAPAN");
                    startActivity(intent14);
                    break;

                case "R.PERAWAT PEREMPUAN":
                    Intent intent15 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent15.putExtra("data1", "R.PERAWAT PEREMPUAN");
                    startActivity(intent15);
                    break;

                case "R.PERAWAT LAKI LAKI":
                    Intent intent16 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent16.putExtra("data1", "R.PERAWAT LAKI-LAKI");
                    startActivity(intent16);
                    break;

                case "OK 4":
                    Intent intent17 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent17.putExtra("data1", "OK 4");
                    startActivity(intent17);
                    break;

                case "OK 1":
                    Intent intent18 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent18.putExtra("data1", "OK 1");
                    startActivity(intent18);
                    break;

                case "INSTALASI BEDAH SENTRAL":
                    Intent intent19 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent19.putExtra("data1", "INSTALASI BEDAH SENTRAL");
                    startActivity(intent19);
                    break;

                case "R.OBAT":
                    Intent intent20 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent20.putExtra("data1",  "R.OBAT");
                    startActivity(intent20);
                    break;

                case "R.OBAT1":
                    Intent intent21 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent21.putExtra("data1",  "R.OBAT1");
                    startActivity(intent21);
                    break;

                case "GUDANG STERIL":
                    Intent intent22 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent22.putExtra("data1",  "GUDANG STERIL");
                    startActivity(intent22);
                    break;

                case "GUDANG NON STERIL":
                    Intent intent23 = new Intent(GedungGActivity. this, FormActivity.class);
                    intent23.putExtra("data1",  "GUDANG NON STERIL");
                    startActivity(intent23);
                    break;

            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(200, 500, 200, 200, new State("TRANSFER STRECHER KELUAR")));

        clickableAreas.add(new ClickableArea(200, 0, 200, 200, new State("COUNTER")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("ADMIN")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("TRANSFER STRECHER MASUK")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("R.KONSULTASI")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("GUDANG")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("SH")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("LOKER LAKI LAKI")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("LOKER PEREMPUAN")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("PANTRY")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("R.DOKTER PEREMPUAN")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("R.DISKUSI")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 000, new State("R.DOKTER LAKI LAKI")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("RECOVERY")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("R.PERAWAT PEREMPUAN")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("R.PERAWAT LAKI LAKI")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("OK 4")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("OK 1")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("INSTALASI BEDAH SENTRAL")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("R.OBAT")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("R.OBAT1")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("GUDANG STERIL")));

        clickableAreas.add(new ClickableArea(0, 0, 200, 200, new State("GUDANG NON STERIL")));










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