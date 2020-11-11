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
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

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

                case "MESIN CUCI":
                    Intent intent6 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent6.putExtra("data1", "MESIN CUCI");
                    startActivity(intent6);
                    break;

                case "DRYING":
                    Intent intent7 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent7.putExtra("data1", "CUCI");
                    startActivity(intent7);
                    break;

                case "GUDANG LINEN BERSIH":
                    Intent intent8 = new Intent(GedungABActivity. this, FormActivity.class);
                    intent8.putExtra("data1", "CUCI");
                    startActivity(intent8);
                    break;




            }
        }
    }


    //untuk menentukan titik koordinat disesuaikan dengan nama state nya
    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(200, 200, 300 ,300, new State("PENERIMAAN LINER KOTOR")));
        clickableAreas.add(new ClickableArea(650, 300, 300, 300, new State("ADMINISTRASI LAUNDRY")));
        clickableAreas.add(new ClickableArea(1000, 320, 300, 300, new State("SETRIKA DAN JAHIT")));
        clickableAreas.add(new ClickableArea(1500, 300, 300, 300, new State("DELIVERY")));
        clickableAreas.add(new ClickableArea(200, 900, 300, 300, new State("INFEKSIUS")));
        clickableAreas.add(new ClickableArea(700, 900, 300, 300, new State("MESIN CUCI")));
        clickableAreas.add(new ClickableArea(1000, 800, 300, 300, new State("DRYING")));
        clickableAreas.add(new ClickableArea(1500, 860, 300, 300, new State("GUDANG LINEN BERSIH")));
        clickableAreas.add(new ClickableArea(300, 970, 300, 300, new State("CUCI")));


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