package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

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

public class GedungSSActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_s_s);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.ss);

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

            switch (text) {
                case "PERAWATAN KELAS VIP":
                    Intent S = new Intent(GedungSSActivity. this, FormActivity.class);
                    startActivity(S);
                    break;


            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 1840, 1723, new State("PERAWATAN KELAS VIP")));


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