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

public class GedungTActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_t);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.t);

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
            Toast.makeText(this,text, Toast.LENGTH_SHORT).show();

            switch (text) {
                case "R.DOKTER":
                    Intent K = new Intent(GedungTActivity. this, FormActivity.class);
                    K.putExtra("data1", "R. DOKTOR");
                    startActivity(K);
                    break;

                case "R.KA INSTALASI":
                    Intent G = new Intent(GedungTActivity. this, FormActivity.class);
                    G.putExtra("data1", "R. KA INSTALASI");
                    startActivity(G);
                    break;

                case "SH":
                    Intent S = new Intent(GedungTActivity. this, FormActivity.class);
                    S.putExtra("data1", "SH");
                    startActivity(S);
                    break;

                case "LAV":
                    Intent intent = new Intent(GedungTActivity. this, FormActivity.class);
                    intent.putExtra("data1", "LAV");
                    startActivity(intent);
                    break;

                case "PANTRY":
                    Intent intent1 = new Intent(GedungTActivity. this, FormActivity.class);
                    intent1.putExtra("data1", "PANTRY");
                    startActivity(intent1);
                    break;

                case "R.ALAT & LINEN":
                    Intent intent2 = new Intent(GedungTActivity. this, FormActivity.class);
                    intent2.putExtra("data1", "R. ALAT & LINEN");
                    startActivity(intent2);
                    break;

                case "PERAWATAN KELAS 1":
                    Intent intent3 = new Intent(GedungTActivity. this, FormActivity.class);
                    intent3.putExtra("data1", "PERAWATAN KELAS 1");
                    startActivity(intent3);
                    break;


            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(40, 30, 100, 50, new State("R.DOKTER")));
        clickableAreas.add(new ClickableArea(70, 30, 100, 50, new State("R.KA INTALASI")));
        clickableAreas.add(new ClickableArea(40, 200, 50, 70, new State("SH")));
        clickableAreas.add(new ClickableArea(70, 280, 50, 50, new State("LAV")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("PANTRY")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("R.ALAT & LINEN")));
        clickableAreas.add(new ClickableArea(100, 50, 50, 50, new State("PERAWATAN KELAS 1")));


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