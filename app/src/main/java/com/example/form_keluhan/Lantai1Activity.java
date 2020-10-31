package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import uk.co.senab.photoview.PhotoViewAttacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.form_keluhan.lantai1.GedungAAActivity;
import com.example.form_keluhan.lantai1.GedungABActivity;
import com.example.form_keluhan.lantai1.GedungAHActivity;
import com.example.form_keluhan.lantai1.GedungAIActivity;
import com.example.form_keluhan.lantai1.GedungAJActivity;
import com.example.form_keluhan.lantai1.GedungGActivity;
import com.example.form_keluhan.lantai1.GedungJActivity;
import com.example.form_keluhan.lantai1.GedungKActivity;
import com.example.form_keluhan.lantai1.GedungLActivity;
import com.example.form_keluhan.lantai1.GedungMActivity;
import com.example.form_keluhan.lantai1.GedungNActivity;
import com.example.form_keluhan.lantai1.GedungOActivity;
import com.example.form_keluhan.lantai1.GedungPActivity;
import com.example.form_keluhan.lantai1.GedungQActivity;
import com.example.form_keluhan.lantai1.GedungRActivity;
import com.example.form_keluhan.lantai1.GedungSActivity;
import com.example.form_keluhan.lantai1.GedungSSActivity;
import com.example.form_keluhan.lantai1.GedungTActivity;
import com.example.form_keluhan.lantai1.GedungUActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class Lantai1Activity extends AppCompatActivity implements OnClickableAreaClickedListener{

    Button btn_lant2, btn_fetch, btn_logout;
    FirebaseUser currentUser ;
    Toolbar toolbar;

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lantai1);

        btn_lant2= findViewById(R.id.btn_lant2);
        btn_lant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, Lantai2Activity.class);
                startActivity(intent);
            }
        });


        btn_fetch= findViewById(R.id.btn_fetch);
        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lantai1Activity.this, GolosariumActivity.class);
                startActivity(intent);
            }
        });

        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.resize);

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
                case "L. RADIOLOGI" :
                    Intent L = new Intent(Lantai1Activity.this, GedungLActivity.class);
                    startActivity(L);
                    break;

                case "K.LABORATORIUM" :
                    Intent K = new Intent(Lantai1Activity.this, GedungKActivity.class);
                    startActivity(K);
                    break;

                case "M.INSTALASI KEBIDANAN" :
                    Intent M = new Intent(Lantai1Activity.this, GedungMActivity.class);
                    startActivity(M);
                    break;

                case "N.PERINATAL" :
                    Intent N = new Intent(Lantai1Activity.this, GedungNActivity.class);
                    startActivity(N);
                    break;

                case "Q.R. KLAS IIIA (PERGIWA)" :
                    Intent Q = new Intent(Lantai1Activity.this, GedungQActivity.class);
                    startActivity(Q);
                    break;

                case "R.R. KLAS IIIB (KUNTHI)" :
                    Intent R = new Intent(Lantai1Activity.this, GedungRActivity.class);
                    startActivity(R);
                    break;

                case "S.R. VIP (SRIKANDI)" :
                    Intent S = new Intent(Lantai1Activity.this, GedungSActivity.class);
                    startActivity(S);
                    break;

                case "SS.R. VIP (SRIKANDI)" :
                    Intent SS = new Intent(Lantai1Activity.this, GedungSSActivity.class);
                    startActivity(SS);
                    break;

                case "J.ICU/PICU/NICU" :
                    Intent J = new Intent(Lantai1Activity.this, GedungJActivity.class);
                    startActivity(J);
                    break;

                case "P.FISIOTERAPI" :
                    Intent P = new Intent(Lantai1Activity.this, GedungPActivity.class);
                    startActivity(P);
                    break;

                case "O.HAEDEMOLISA" :
                    Intent O = new Intent(Lantai1Activity.this, GedungOActivity.class);
                    startActivity(O);
                    break;

                case "G. INSTALASI BEDAH SENTRAL" :
                    Intent G = new Intent(Lantai1Activity.this, GedungGActivity.class);
                    startActivity(G);
                    break;

                case "T. R. KLAS I (SHINTA)" :
                    Intent T = new Intent(Lantai1Activity.this, GedungTActivity.class);
                    startActivity(T);
                    break;

                case "U. R. KLAS II (ARIMBI)" :
                    Intent U = new Intent(Lantai1Activity.this, GedungUActivity.class);
                    startActivity(U);
                    break;

                case "AA. R. INSTALASI GIZI" :
                    Intent AA = new Intent(Lantai1Activity.this, GedungAAActivity.class);
                    startActivity(AA);
                    break;

                case "AB. INSTALASI LAUNDRY" :
                    Intent AB = new Intent(Lantai1Activity.this, GedungABActivity.class);
                    startActivity(AB);
                    break;

                case "AH. R. JENAZAH" :
                    Intent AH = new Intent(Lantai1Activity.this, GedungAHActivity.class);
                    startActivity(AH);
                    break;

                case "AI. R. MOBIL  JENAZAH" :
                    Intent AI = new Intent(Lantai1Activity.this, GedungAIActivity.class);
                    startActivity(AI);
                    break;

                case "AJ. R. GAS MEDIS" :
                    Intent AJ= new Intent(Lantai1Activity.this, GedungAJActivity.class);
                    startActivity(AJ);
                    break;
            }
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(270, 420, 50, 50, new State("L. RADIOLOGI")));
        clickableAreas.add(new ClickableArea(350, 420, 50, 50, new State("K.LABORATORIUM")));
        clickableAreas.add(new ClickableArea(350, 500, 50, 50, new State("M.INSTALASI KEBIDANAN")));

        clickableAreas.add(new ClickableArea(350, 570, 50, 50, new State("N.PERINATAL")));
        clickableAreas.add(new ClickableArea(310, 680, 50, 50, new State("V.RANAP GABUNG")));
        clickableAreas.add(new ClickableArea(310, 800, 50, 50, new State("W.RANAP ANAK")));

        clickableAreas.add(new ClickableArea(450, 750, 50, 50, new State("Q.R. KLAS IIIA (PERGIWA)")));
        clickableAreas.add(new ClickableArea(480, 750, 50, 50, new State("R.R. KLAS IIIB (KUNTHI)")));
        clickableAreas.add(new ClickableArea(570, 670, 50, 50, new State("S.R. VIP (SRIKANDI)")));

        clickableAreas.add(new ClickableArea(500, 530, 50, 50, new State("J.ICU/PICU/NICU")));
        clickableAreas.add(new ClickableArea(590, 530, 30, 50, new State("P.FISIOTERAPI")));
        clickableAreas.add(new ClickableArea(630, 530, 30, 50, new State("O.HAEDEMOLISA")));

        clickableAreas.add(new ClickableArea(550, 420, 50, 50, new State("G. INSTALASI BEDAH SENTRAL")));
        clickableAreas.add(new ClickableArea(490, 390, 50, 50, new State("H. SIMRS")));
        clickableAreas.add(new ClickableArea(630, 270, 50, 50, new State("A. INSTALASI GAWAT DARURAT")));

        clickableAreas.add(new ClickableArea(270, 270, 50, 50, new State("B. POLI")));
        clickableAreas.add(new ClickableArea(455, 320, 50, 50, new State("C. INSTALASI FARMASI")));
        clickableAreas.add(new ClickableArea(445, 270, 50, 50, new State("F. RUANG TUNGGU PASIEN")));

        clickableAreas.add(new ClickableArea(480, 240, 50, 50, new State("D. REKAM MEDIK")));
        clickableAreas.add(new ClickableArea(480, 280, 50, 50, new State("D. REKAM MEDIK")));
        clickableAreas.add(new ClickableArea(450, 240, 30, 30, new State("E. PENDAFTARAN")));

        clickableAreas.add(new ClickableArea(200, 650, 50, 50, new State("AS. PUJASERA")));
        clickableAreas.add(new ClickableArea(180, 180, 50, 50, new State("AW. MUSHOLA")));
        clickableAreas.add(new ClickableArea(705, 180, 50, 50, new State("AX. POST SATPAM")));

        clickableAreas.add(new ClickableArea(550, 100, 50, 50, new State("AX. POST SATPAM")));
        clickableAreas.add(new ClickableArea(570, 800, 50, 50, new State("T. R. KLAS I (SHINTA)")));
        clickableAreas.add(new ClickableArea(630, 800, 50, 50, new State("U. R. KLAS II (ARIMBI)")));

        clickableAreas.add(new ClickableArea(290, 920, 30, 30, new State("AH. R. JENAZAH")));
        clickableAreas.add(new ClickableArea(290, 960, 30, 30, new State("AI. R. MOBIL  JENAZAH")));
        clickableAreas.add(new ClickableArea(290, 1020, 30, 30, new State("AJ. R. GAS MEDIS")));

        clickableAreas.add(new ClickableArea(160, 930, 30, 30, new State("AR. SANITASI")));
        clickableAreas.add(new ClickableArea(130, 970, 20, 20, new State("AR. SANITASI")));
        clickableAreas.add(new ClickableArea(130, 1010, 30, 30, new State("AO. GUDANG GIZI")));

        clickableAreas.add(new ClickableArea(130, 1030, 30, 30, new State("AN. RUANG GENSET")));
        clickableAreas.add(new ClickableArea(160, 1010, 20, 20, new State("AQ. TOWER AIR")));
        clickableAreas.add(new ClickableArea(180, 1010, 20, 20, new State("AP. RUMAH POMPA")));

        clickableAreas.add(new ClickableArea(50, 1080, 50, 50, new State("AM. GUDANG ALKES")));
        clickableAreas.add(new ClickableArea(350, 1170, 50, 50, new State("AK. R. KLAS III")));
        clickableAreas.add(new ClickableArea(350, 1280, 50, 50, new State("AL. R. ISOLASI")));

        clickableAreas.add(new ClickableArea(500, 1170, 50, 50, new State("AK. R. KLAS III")));
        clickableAreas.add(new ClickableArea(330, 1080, 50, 50, new State("AX. POST SATPAM")));
        clickableAreas.add(new ClickableArea(630, 670, 50, 50, new State("SS. R. VIP(SRIKANDI)")));

        clickableAreas.add(new ClickableArea(650, 1100, 30, 30, new State("AX. POST SATPAM")));
        clickableAreas.add(new ClickableArea(500, 920, 50, 50, new State("AB. INSTALASI LAUNDRY")));
        clickableAreas.add(new ClickableArea(450, 950, 50, 50, new State("AA. R. INSTALASI GIZI")));

        clickableAreas.add(new ClickableArea(500, 1000, 30, 30, new State("AC. GUDANG FARMASI")));
        clickableAreas.add(new ClickableArea(520, 1030, 30, 30, new State("AD. GUDANG GIZI")));
        clickableAreas.add(new ClickableArea(480, 1030, 30, 30, new State("AE. RUANG DOKTER")));

        clickableAreas.add(new ClickableArea(420, 1030, 30, 30, new State("AF. R. GANTI KARYAWAN")));
        clickableAreas.add(new ClickableArea(400, 1000, 30, 30, new State("AG. R. KOPRASI")));
        clickableAreas.add(new ClickableArea(420, 955, 30, 30, new State("AC. GUDANG FARMASI")));

        clickableAreas.add(new ClickableArea(360, 925, 20, 20, new State("X. SANITAS")));
        clickableAreas.add(new ClickableArea(390, 925, 20, 20, new State("Y. RUANG CS")));
        clickableAreas.add(new ClickableArea(400, 970, 40, 20, new State("Z. IPSRS")));


        return clickableAreas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_lantai1_drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_Logout) {
            FirebaseAuth.getInstance().signOut();
            Intent loginActivity = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(loginActivity);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}


