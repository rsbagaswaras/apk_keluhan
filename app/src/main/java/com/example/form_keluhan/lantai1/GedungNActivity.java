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

public class GedungNActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_n);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.n);

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
                case "R.ALAT LINEN":
                    Intent intent = new Intent(GedungNActivity. this, FormActivity.class);
                    intent.putExtra("data1",  "R.ALAT LINEN");
                    startActivity(intent);
                    break;

                case "DAPUR SUSU":
                    Intent intent1 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent1.putExtra("data1",  "DAPUR SUSU");
                    startActivity(intent1);
                    break;


                case "R.OBAT":
                    Intent intent2 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent2.putExtra("data1",  "R.OBAT");
                    startActivity(intent2);
                    break;


                case "NURSE STATION":
                    Intent intent3 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent3.putExtra("data1",  "NURSE STATION");
                    startActivity(intent3);
                    break;


                case "SH":
                    Intent intent4 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent4.putExtra("data1",  "SH");
                    startActivity(intent4);
                    break;


                case "BBRT NDN INFEKSIUS":
                    Intent intent5 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent5.putExtra("data1",  "BBRT NDN INFEKSIUS");
                    startActivity(intent5);
                    break;


                case "LAV":
                    Intent intent6 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent6.putExtra("data1",  "LAV");
                    startActivity(intent6);
                    break;


                case "LAV 2":
                    Intent intent7 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent7.putExtra("data1",  "LAV 2");
                    startActivity(intent7);
                    break;


                case "BBRT INFEKSIUS":
                    Intent intent8 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent8.putExtra("data1",  "BBRT INFEKSIUS");
                    startActivity(intent8);


                case "BBRT DIARE":
                    Intent intent9 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent9.putExtra("data1",  "BBRT DIARE");
                    startActivity(intent9);
                    break;

                case "PERINOTOLOGI":
                    Intent intent10 = new Intent(GedungNActivity. this, FormActivity.class);
                    intent10.putExtra("data1",  "PERINOTOLOGI");
                    startActivity(intent10);
                    break;
            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();


        //X semakin besar jumlah angkanya KEKANAN ,
        // Y semakin besar jumlah angkanya KEBAWAH , W semakin besar angkanya semakin LEBAR
        // , H semakin besar angknay semakin PANJANG
        clickableAreas.add(new ClickableArea(100, 320, 200, 200, new State("R.ALAT LINEN")));
        clickableAreas.add(new ClickableArea(450, 200, 200, 250, new State("DAPUR SUSU")));
        clickableAreas.add(new ClickableArea(820, 200, 200, 250, new State("R.OBAT")));
        clickableAreas.add(new ClickableArea(1300, 120, 200, 250, new State("NURSE STATION")));
        clickableAreas.add(new ClickableArea(1700, 120, 200, 250, new State("SH")));
        clickableAreas.add(new ClickableArea(950, 500, 150, 200, new State("PERINOTOLOGI")));
        clickableAreas.add(new ClickableArea(380, 850, 200, 350, new State("BBRT NDN INFEKSIUS")));
        clickableAreas.add(new ClickableArea(820, 750, 150, 150, new State("LAV")));
        clickableAreas.add(new ClickableArea(980, 750, 150, 150, new State("LAV 2")));
        clickableAreas.add(new ClickableArea(900, 1000, 100, 100, new State("BBRT INFEKSIUS")));
        clickableAreas.add(new ClickableArea(1500, 1200, 100, 100, new State("BBRT DIARE")));



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