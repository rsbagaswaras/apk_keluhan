package com.example.form_keluhan.Form;

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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.form_keluhan.Checklist;
import com.example.form_keluhan.R;
import com.example.form_keluhan.lantai1.Lantai1Activity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;

public class FormActivity extends AppCompatActivity  {

    ImageView postImage;
    Button btn_add;
    EditText edt_nama, edt_keluhan;
    Spinner spinner;
    TextView txt_namru;
    TextView textView;
    int hari, bulan, tahun;


    private Uri pickedImgUri = null;
    private static final int PReqCode = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        imageClick();
        uploadPicture();

        edt_nama = findViewById(R.id.edt_nama);
        edt_keluhan = findViewById(R.id.edt_keluhan);
        spinner = findViewById(R.id.spinner);
        txt_namru = findViewById(R.id.txt_namru);
        txt_namru.setText(getIntent().getStringExtra("data1"));

        Calendar calendar = Calendar.getInstance();
        hari = calendar.get(Calendar.DAY_OF_MONTH);
        bulan = calendar.get(Calendar.MONTH);
        bulan = bulan+1;
        tahun = calendar.get(Calendar.YEAR);

        String finalTanggal = hari + "/" + bulan + "/" + tahun;

        textView = findViewById(R.id.idtanggal);
        textView.setText(finalTanggal);

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

    private void uploadPicture() {
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // we need to test all input fields (Title and description ) and post image

                if (!textView.getText().toString().isEmpty()
                        && !edt_nama.getText().toString().isEmpty()
                        && !txt_namru.getText().toString().isEmpty()
                        && !spinner.getSelectedItem().toString().isEmpty()
                        && !edt_keluhan.getText().toString().isEmpty()
                        && pickedImgUri != null ){
                    //everything is okey no empty or null value
                    // TODO Create Post Object and add it to firebase database
                    // first we need to upload post Image
                    // access firebase storage
                    StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("foto_keluhan");
                    final StorageReference imageFilePath = storageReference.child(pickedImgUri.getLastPathSegment());
                    imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String imageDownlaodLink = uri.toString();
                                    // create post Object
                                    Form form = new Form(textView.getText().toString(),
                                            edt_nama.getText().toString(),
                                            txt_namru.getText().toString(),
                                            spinner.getSelectedItem().toString(),
                                            edt_keluhan.getText().toString(),
                                            imageDownlaodLink);

                                    // Add form to firebase database

                                    Click3(form);

                                }
                            });
                        }
                    });
                }
            }
        });
    }

    public void Click3(Form form) {

        //untuk memasukkan ke firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //membuat server pada realtime database
        DatabaseReference ref = database.getReference("RSBW").child("Keluhan").push();

        //Referensi database yang dituju
        //Fungsi push() untuk menghasilkan kunci unik untuk setiap turunan baru

        ref.setValue(form).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                //setelah loading maka akan langsung berpindah ke bottom nav activity
                Intent home=new Intent(FormActivity.this, Checklist.class);
                startActivity(home);
                finish();

                //mengosongkan isian setelah klik button upload
                edt_nama.setText("");
                edt_keluhan.setText("");
                spinner.setSelection(0);
                postImage.setImageResource(R.drawable.ic_camera_alt_black_24dp);
            }
        });
    }

}
