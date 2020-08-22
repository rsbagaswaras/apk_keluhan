package com.example.form_keluhan;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KomiteMedikActivity extends AppCompatActivity {

    Dialog popAddPost;
    ImageView popupPostImage, popupAddBtn;
    TextView popupJudul, popupNama,popupRuangan, popupKeluhan;
    EditText edt_nama, edt_ruangan, edt_keluhan;
    Button addForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komite_medik);

        iniPopup();
        setupPopupImageClick();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popAddPost.show();
            }
        });
    }

    private void setupPopupImageClick() {

        popupPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here when image clicked we need to open the gallery
                // before we open the gallery we need to check if our app have the access to user files
                // we did this before in register activity I'm just going to copy the code to save time ...
                checkAndRequestForPermission();
            }
        });
    }

    private void checkAndRequestForPermission() {
        //Request for camera permission
        if (ContextCompat.checkSelfPermission(KomiteMedikActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(KomiteMedikActivity.this,
                    new String[] {
                            Manifest.permission.CAMERA
                    },
                    100
            );
        }
        else {
            //Open Camera
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 100);
        }
    }

    private void iniPopup() {
        popAddPost = new Dialog(this);
        popAddPost.setContentView(R.layout.activity_form);
        popAddPost.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popAddPost.getWindow().setLayout(Toolbar.LayoutParams.WRAP_CONTENT,Toolbar.LayoutParams.WRAP_CONTENT);
        popAddPost.getWindow().getAttributes().gravity = Gravity.CENTER;

        // ini popup widgets
        popupPostImage = popAddPost.findViewById(R.id.gambar);
        popupJudul = popAddPost.findViewById(R.id.form);
        popupNama = popAddPost.findViewById(R.id.txt_nama);
        popupRuangan = popAddPost.findViewById(R.id.txt_ruangan);
        popupKeluhan = popAddPost.findViewById(R.id.txt_keluhan);
        edt_nama = popAddPost.findViewById(R.id.edt_nama);
        edt_ruangan = popAddPost.findViewById(R.id.edt_ruangan);
        edt_keluhan = popAddPost.findViewById(R.id.edt_keluhan);
        popupAddBtn = popAddPost.findViewById(R.id.btn_add);

        //Add post click listener
        popupAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Alert Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(KomiteMedikActivity.this);
                builder.setTitle("Pemberitahuan");
                builder.setMessage("Form Berhasil di Upload !");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("info", "OK");
                    }
                });
                builder.show();
            }
        });
    }
}