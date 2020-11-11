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

public class GedungAHActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_a_h);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.ah);

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

            String text = ((State) item).getName() ;
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

            switch (text) {
                case "Mandi Jenazah":
                    Intent intent = new Intent(GedungAHActivity. this, FormActivity.class);
                    intent.putExtra("data1", "R. REUSE");
                    startActivity(intent);
                    break;
                case "Admin":
                    Intent intent1 = new Intent(GedungAHActivity. this, FormActivity.class);
                    intent1.putExtra("data1", "ADMIN");
                    startActivity(intent1);
                    break;
                case "R.Jenazah":
                    Intent intent2 = new Intent(GedungAHActivity. this, FormActivity.class);
                    intent2.putExtra("data1", "R. JENAZAH");
                    startActivity(intent2);
                    break;
                case "R.Tunggu":
                    Intent intent3 = new Intent(GedungAHActivity. this, FormActivity.class);
                    intent3.putExtra("data1", "R. TUNGGU");
                    startActivity(intent3);
                    break;
            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(560, 800, 400, 400, new State("Mandi Jenazah")));
        clickableAreas.add(new ClickableArea(1060, 760, 200, 200, new State("Admin")));
        clickableAreas.add(new ClickableArea(680, 1200, 500, 300, new State("R.Jenazah")));
        clickableAreas.add(new ClickableArea(560, 1400, 500, 300, new State("R.Tunggu")));

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