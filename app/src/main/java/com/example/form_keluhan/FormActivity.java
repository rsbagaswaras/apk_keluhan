package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class FormActivity extends AppCompatActivity {
    Dialog popAddPost;
    ImageView popupPostImage, popupAddBtn;
    TextView txt_judul, txt_nama, txt_ruangan, txt_keluhan;
    EditText edt_nama, edt_ruangan, edt_keluhan;

    FirebaseAuth mAuth;
    FirebaseUser currentUser ;

    private Uri pickedImgUri = null;
    private static final int PReqCode = 2 ;
    private static final int REQUESCODE = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Variable

        iniPopup();
        setupPopupImageClick();

        Spinner spinner = findViewById(R.id.spinner);


    }

    //ketika icon camera di klik
    private void setupPopupImageClick() {

        popupPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here when image clicked we need to open the gallery
                // before we open the gallery we need to check if our app have the access to user files
                // we did this before in register activity I'm just going to copy the code to save time ...
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
                            startActivityForResult(intent, REQUESCODE);
                        }
                    }
                }
                else if (options[item].equals("Pilih dari Galeri"))
                {
                    if (ContextCompat.checkSelfPermission(FormActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(FormActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                            Toast.makeText(FormActivity.this,"Please accept for required permission",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            ActivityCompat.requestPermissions(FormActivity.this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    PReqCode);
                        }

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
        startActivityForResult(galleryIntent,REQUESCODE);
    }


    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null ) {
        //Get Capture Image
        //Bundle extras = data.getExtras();
        //Bitmap captureImage = (Bitmap) extras.get("data");
        //set capture to image
        //popupPostImage.setImageBitmap(captureImage);
        //}

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null ) {

            // the user has successfully picked an image
            // we need to save its reference to a Uri variable
            pickedImgUri = data.getData() ;
            popupPostImage.setImageURI(pickedImgUri);

        }

    }

    //setting popup
    private void iniPopup() {
        popAddPost = new Dialog(this);
        popAddPost.setContentView(R.layout.activity_form);
        popAddPost.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popAddPost.getWindow().setLayout(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        popAddPost.getWindow().getAttributes().gravity = Gravity.CENTER;

        // widgets yang muncul di popup
        popupPostImage = popAddPost.findViewById(R.id.gambar);
        txt_judul = popAddPost.findViewById(R.id.form);
        txt_nama = popAddPost.findViewById(R.id.txt_nama);
        txt_ruangan = popAddPost.findViewById(R.id.txt_ruangan);
        txt_keluhan = popAddPost.findViewById(R.id.txt_keluhan);
        edt_nama = popAddPost.findViewById(R.id.edt_nama);
        edt_ruangan = popAddPost.findViewById(R.id.edt_ruangan);
        edt_keluhan = popAddPost.findViewById(R.id.edt_keluhan);
        popupAddBtn = popAddPost.findViewById(R.id.btn_add);

        //Add post click listener
        popupAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startPosting();

            }
        });
    }

    private void startPosting(){

        // we need to test all input fields (Title and description ) and post image

        if (!edt_nama.getText().toString().isEmpty()
                && !edt_ruangan.getText().toString().isEmpty()
                && !edt_keluhan.getText().toString().isEmpty()
                && pickedImgUri != null ) {

            //everything is okey no empty or null value
            // TODO Create Post Object and add it to firebase database
            // first we need to upload post Image
            // access firebase storage

            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("blog_images");
            final StorageReference imageFilePath = storageReference.child(pickedImgUri.getLastPathSegment());
            imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String imageDownlaodLink = uri.toString();
                            // create post Object
                            Form form = new Form(edt_nama.getText().toString(),
                                    edt_ruangan.getText().toString(),
                                    edt_keluhan.getText().toString(),
                                    imageDownlaodLink,
                                    currentUser.getUid(),
                                    currentUser.getPhotoUrl().toString());

                            // Add post to firebase database

                            addPost(form);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // something goes wrong uploading picture
                            showMessage(e.getMessage());
                        }
                    });


                }
            });
        }
        else {
            showMessage("Please verify all input fields and choose Post Image") ;
        }
    }

    private void addPost(Form form) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Form").push();

        // get post unique ID and upadte post key
        String key = myRef.getKey();
        form.setPostKey(key);


        // add post data to firebase database

        myRef.setValue(form).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                //Alert Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
                builder.setTitle("Pemberitahuan");
                builder.setMessage("Form Berhasil di Upload !");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("info", "OK");
                    }
                });
                builder.show();
                popAddPost.dismiss();
            }
        });





    }

    private void showMessage(String message) {

        Toast.makeText(FormActivity.this,message,Toast.LENGTH_LONG).show();

    }
}
