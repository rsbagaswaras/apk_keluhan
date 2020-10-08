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

public class GedungUActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedung_u);


        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.u);

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
                case "NS":
                    Intent N = new Intent(GedungUActivity. this, FormActivity.class);
                    N.putExtra("data1", "NS");
                    startActivity(N);
                    break;

                case "R. PERAWAT":
                    Intent P = new Intent(GedungUActivity. this, FormActivity.class);
                    P.putExtra("data1", "R. PERAWATAN");
                    startActivity(P);
                    break;

                case "R. DOKTER":
                    Intent D = new Intent(GedungUActivity. this, FormActivity.class);
                    D.putExtra("data1", "R. DOKTOR");
                    startActivity(D);
                    break;

                case "R. KA INSTALASI":
                    Intent K = new Intent(GedungUActivity. this, FormActivity.class);
                    K.putExtra("data1", "R. KA INSTALASI");
                    startActivity(K);
                    break;

                case "PERAWATAN KELAS 2":
                    Intent R = new Intent(GedungUActivity. this, FormActivity.class);
                    R.putExtra("data1", "PERAWATAN KELAS 2");
                    startActivity(R);
                    break;

                case "SELASAR PETUGAS":
                    Intent S = new Intent(GedungUActivity. this, FormActivity.class);
                    S.putExtra("data1", "SELASAR PETUGAS");
                    startActivity(S);
                    break;

                case "PERAWATAN KELAS 3":
                    Intent W = new Intent(GedungUActivity. this, FormActivity.class);
                    W.putExtra("data1", "PERAWATAN KELAS 3");
                    startActivity(W);
                    break;
            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(0, 0, 1840, 2840, new State("NS")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2840, new State("R. PERAWAT")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2840, new State("R. DOKTER")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2840, new State("R. KA INSTALASI")));

        clickableAreas.add(new ClickableArea(0, 0, 1840, 2840, new State("PERAWATAN KELAS 2")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2840, new State("SELASAR PETUGAS")));
        clickableAreas.add(new ClickableArea(0, 0, 1840, 2840, new State("PERAWATAN KELAS 3")));


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