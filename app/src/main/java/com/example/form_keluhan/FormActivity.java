package com.example.form_keluhan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Locale;

public class FormActivity extends AppCompatActivity  {

    ImageView postImage;
    Button btn_add;
    EditText edt_nama, edt_ruangan, edt_keluhan;
    Spinner spinner;

    private Uri pickedImgUri = null;
    private static final int PReqCode = 2 ;
    private static final int REQUESCODE = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        imageClick();



    }

    private void imageClick() {
        postImage = findViewById(R.id.gambar);
        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
    }

    private void selectImage() {

        final CharSequence[] options = { "Ambil Foto", "Pilih dari Galeri" };
        AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
        builder.setTitle("Tambah Foto");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Ambil Foto"))
                {
                    //Request for camera permission
                    if (ContextCompat.checkSelfPermission(FormActivity.this,
                            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(FormActivity.this,
                                new String[] { Manifest.permission.CAMERA}, PReqCode);
                    }
                    else {
                        //Open Camera
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(intent, 1);
                        }
                    }
                }
                else if (options[item].equals("Pilih dari Galeri"))
                {
                    if (ContextCompat.checkSelfPermission(FormActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(FormActivity.this,
                                new String[] { Manifest.permission.READ_EXTERNAL_STORAGE}, PReqCode);
                    }
                    else
                        // everything goes well : we have permission to access user gallery
                        openGallery();
                }
            }
        });
        builder.show();
    }

    private void openGallery() {
        //TODO: open gallery intent and wait for user to pick an image !
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,2);
    }


    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                //Get Capture Image
                Bundle extras = data.getExtras();
                Bitmap captureImage = (Bitmap) extras.get("data");
                //set capture to image
                postImage.setImageBitmap(captureImage);
            } else if (requestCode == 2) {
                // the user has successfully picked an image
                // we need to save its reference to a Uri variable
                pickedImgUri = data.getData() ;
                postImage.setImageURI(pickedImgUri);
            }

        }

    }


    //setting popup
    public void Click3(View view) {

        //deklarasi
        edt_nama = findViewById(R.id.edt_nama);
        edt_ruangan = findViewById(R.id.edt_ruangan);
        edt_keluhan = findViewById(R.id.edt_keluhan);
        spinner = findViewById(R.id.spinner);
        postImage = findViewById(R.id.gambar);
        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        //untuk memasukkan ke firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //membuat server pada realtime database
        DatabaseReference ref = database.getReference("RSBW/Keluhan");

            //Referensi database yang dituju
            DatabaseReference myRef = ref.child("Laporan");

            //Fungsi push() untuk menghasilkan kunci unik untuk setiap turunan baru
            DatabaseReference newmyRef = myRef.push();

            //memberi nilai pada referensi yang dituju
            newmyRef.child("Nama").setValue(edt_nama.getText().toString());
            newmyRef.child("Ruangan").setValue(edt_ruangan.getText().toString());
            newmyRef.child("Keluhan").setValue(edt_keluhan.getText().toString());


        Toast.makeText(getApplicationContext(), "Data Keluhan Sudah Tersimpan", Toast.LENGTH_SHORT).show();

        //mengosongkan isian setelah klik button upload
        edt_nama.setText("");
        edt_ruangan.setText("");
        edt_keluhan.setText("");
        edt_keluhan.setText("");
        edt_nama.requestFocus();

    }

}
