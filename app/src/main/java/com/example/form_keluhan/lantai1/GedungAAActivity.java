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

public class GedungAAActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_a_a);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.aa);

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
                case "RUANG DELIVERY":
                    Intent intent = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent.putExtra("data1", "RUANG DELIVERY");
                    startActivity(intent);
                    break;

                case "RUANG SAJI":
                    Intent intent1 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent1.putExtra("data1", "RUANG SAJI");
                    startActivity(intent1);
                    break;

                case "GUDANG ALAT BERSIH":
                    Intent intent2 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent2.putExtra("data1", "GUDANG ALAT BERSIH");
                    startActivity(intent2);
                    break;

                case "RUANG RACIK":
                    Intent intent3 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent3.putExtra("data1", "RUANG RACIK");
                    startActivity(intent3);
                    break;

                case "RUANG MASAK":
                    Intent intent4 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent4.putExtra("data1", "RUANG MASAK");
                    startActivity(intent4);
                    break;

                case "INSTALASI GIZI":
                    Intent intent5 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent5.putExtra("data1", "INSTALASI GIZI");
                    startActivity(intent5);
                    break;

                case "RUANG CUCI":
                    Intent intent6 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent6.putExtra("data1", "RUANG CUCI");
                    startActivity(intent6);
                    break;

                case "TROLEY KOTOR":
                    Intent intent7 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent7.putExtra("data1", "TROLEY KOTOR");
                    startActivity(intent7);
                    break;

                case "DAPUR SUSU & SNACK":
                    Intent intent8 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent8.putExtra("data1", "DAPUR SUSU & SNACK");
                    startActivity(intent8);
                    break;

                case "RUANG PENGOLAHAN":
                    Intent intent9 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent9.putExtra("data1", "RUANG PENGOLAHAN");
                    startActivity(intent9);
                    break;

                case "BASAH KERING":
                    Intent intent10 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent10.putExtra("data1", "BASAH KERING");
                    startActivity(intent10);
                    break;

                case "GUDANG BASAH":
                    Intent intent11 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent11.putExtra("data1", "GUDANG BASAH");
                    startActivity(intent11);
                    break;

                case "KA INSTALASI GIZI":
                    Intent intent12 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent12.putExtra("data1", "KA INSTALASI GIZI");
                    startActivity(intent12);
                    break;

                case "ADMIN R.GIZI & PENERIMAAN BAHAN":
                    Intent intent13 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent13.putExtra("data1", "ADMIN R.GIZI & PENERIMAAN BAHAN");
                    startActivity(intent13);
                    break;

                case "TOILET 1":
                    Intent intent14 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent14.putExtra("data1", "TOILET 1");
                    startActivity(intent14);
                    break;

                case "TOILET 2":
                    Intent intent15 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent15.putExtra("data1", "TOILET 2");
                    startActivity(intent15);
                    break;

                case "GUDANG KERING":
                    Intent intent16 = new Intent(GedungAAActivity. this, FormActivity.class);
                    intent16.putExtra("data1", "GUDANG KERING");
                    startActivity(intent16);
                    break;

            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(70, 60, 60, 60, new State("RUANG DELIVERY")));

        clickableAreas.add(new ClickableArea(70, 170, 40, 40, new State("RUANG SAJI")));

        clickableAreas.add(new ClickableArea(70, 250, 40, 40, new State("GUDANG ALAT BERSIH")));

        clickableAreas.add(new ClickableArea(180, 120, 85, 85, new State("RUANG RACIK")));

        clickableAreas.add(new ClickableArea(220, 180, 85, 85, new State("RUANG MASAK")));

        clickableAreas.add(new ClickableArea(180, 220, 100, 80, new State("INSTALASI GIZI")));

        clickableAreas.add(new ClickableArea(70, 280, 80, 80, new State("RUANG CUCI")));

        clickableAreas.add(new ClickableArea(70, 350, 80, 80, new State("TROLEY KOTOR")));

        clickableAreas.add(new ClickableArea(350, 600, 200, 200, new State("DAPUR SUSU & SNACK")));

        clickableAreas.add(new ClickableArea(240, 275, 80, 80, new State("RUANG PENGOLAHAN")));

        clickableAreas.add(new ClickableArea(240, 375, 80, 80, new State("BASAH KERING")));

        clickableAreas.add(new ClickableArea(350, 360, 80, 80, new State("GUDANG BASAH")));

        clickableAreas.add(new ClickableArea(470, 360, 80, 80, new State("GUDANG KERING")));

        clickableAreas.add(new ClickableArea(600, 320, 70, 70, new State("KA INSTALASI GIZI")));

        clickableAreas.add(new ClickableArea(660, 320, 70, 70, new State("ADMIN R.GIZI & PENERIMAAN BAHAN")));

        clickableAreas.add(new ClickableArea(670, 370, 40, 40, new State("TOILET 1")));

        clickableAreas.add(new ClickableArea(690, 370, 40, 40, new State("TOILET 2")));


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