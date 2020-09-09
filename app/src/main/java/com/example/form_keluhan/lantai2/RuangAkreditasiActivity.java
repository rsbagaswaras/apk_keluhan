package com.example.form_keluhan.lantai2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.form_keluhan.ClickableArea;
import com.example.form_keluhan.ClickableAreasImage;
import com.example.form_keluhan.CobaPindahBisaDihapus;
import com.example.form_keluhan.FormActivity;
import com.example.form_keluhan.R;
import com.example.form_keluhan.State;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

public class RuangAkreditasiActivity extends AppCompatActivity implements OnClickableAreaClickedListener, com.example.form_keluhan.OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruang_akreditasi);
        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.auditorium);

        // Create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();

            switch (text) {
                case "RUANG AKREDITASI":
                    Intent intent = new Intent(RuangAkreditasiActivity.this, FormActivity.class);
                    startActivity(intent);
                    break;
            }
        }

    }

    private List<ClickableArea> getClickableAreas() {
        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(200, 350, 700, 700, new State("RUANG AKREDITASI")));


        return clickableAreas;


    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}