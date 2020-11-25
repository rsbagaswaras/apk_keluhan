package com.example.form_keluhan.lantai2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.form_keluhan.Clickable.ClickableArea;
import com.example.form_keluhan.Clickable.ClickableAreasImage;
import com.example.form_keluhan.Form.FormActivity;
import com.example.form_keluhan.R;
import com.example.form_keluhan.Clickable.State;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

public class RekapMedikActivity extends AppCompatActivity implements OnClickableAreaClickedListener, com.example.form_keluhan.Clickable.OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekapmedik);
        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.rekapmedik);

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
                case "REKAP MEDIK":
                    Intent intent = new Intent(RekapMedikActivity.this, FormActivity.class);
                    intent.putExtra("data1", "REKAP MEDIK");
                    startActivity(intent);
                    break;
            }
        }
    }

    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 572, 332, new State("REKAP MEDIK")));


        return clickableAreas;

    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}