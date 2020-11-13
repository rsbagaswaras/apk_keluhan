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

public class AuditoriumActivity extends AppCompatActivity implements OnClickableAreaClickedListener, com.example.form_keluhan.Clickable.OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_auditorium);

        //add image
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.auditorium);

        //create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(imageView), this);

        //
        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    //memberikan toast pada setiap nama ruangan
    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();

            switch (text) {
                case "AUDITORIUM":
                    Intent intent = new Intent(AuditoriumActivity.this, FormActivity.class);
                    intent.putExtra("data1", "AUDITORIUM");
                    startActivity(intent);
                    break;
            }
        }
    }

    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    private List<ClickableArea> getClickableAreas() {
        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 400, 498, new State("AUDITORIUM")));

        return clickableAreas;

    }



}