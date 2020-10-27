package com.example.form_keluhan.lantai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

public class GedungABActivity extends AppCompatActivity implements OnClickableAreaClickedListener {




    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_a_b);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.ab);

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
                case "PENERIMAAN LINER KOTOR":
                    Intent intent = new Intent(GedungABActivity. this, FormActivity.class);
                    intent.putExtra("data1", "PENERIMAAN LINER KOTOR");
                    startActivity(intent);
                    break;

                case "ADMINISTRASI LAUNDRY":
                    Intent intent1 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent1.putExtra("data1", "ADMINISTRASI LAUNDRY");
                    startActivity(intent1);
                    break;

                case "SETRIKA DAN JAHIT":
                    Intent intent2 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent2.putExtra("data1", "SETRIKA DAN JAHIT");
                    startActivity(intent2);
                    break;

                case "DELIVERY":
                    Intent intent3 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent3.putExtra("data1", "DELIVERY");
                    startActivity(intent3);
                    break;

                case "INFEKSIUS":
                    Intent intent4 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent4.putExtra("data1", "INFEKSIUS");
                    startActivity(intent4);
                    break;

                case "CUCI":
                    Intent intent5 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent5.putExtra("data1", "CUCI");
                    startActivity(intent5);
                    break;




            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 1840, 1293, new State("R. KONSULTAS")));


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