package com.example.form_keluhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.concurrent.TimeUnit;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

public class RegisterActivity extends AppCompatActivity {

    ImageView ImgUserPhoto;
    static int PReqCode = 1 ;
    static int REQUESCODE = 1 ;
    Uri pickedImgUri ;

    private EditText inputNama, inputEmail, inputPassword, inputConfirmPassword, inputPhone;
    private Button btnRegister;
    private ProgressBar loadingProgress;
    private AwesomeText awesomeText, awesomeText2;
    private boolean pwd_status = true;

    FirebaseAuth mAuth;

    String nama, email, password, confirmPassword, phoneNumber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Init
        inputNama = findViewById(R.id.regName);
        inputEmail = findViewById(R.id.regMail);
        inputPassword = findViewById(R.id.regPassword);
        inputConfirmPassword = findViewById(R.id.regConfirmPassword);
        inputPhone = findViewById(R.id.et_phone);

        loadingProgress = findViewById(R.id.regProgressBar);
        loadingProgress.setVisibility(View.INVISIBLE);

        btnRegister = findViewById(R.id.regBtn);

        //Firebase Init
        mAuth = FirebaseAuth.getInstance();

        Register();

        //show hide password
        awesomeText = findViewById(R.id.awesome);
        awesomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwd_status){
                    inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status = false;
                    awesomeText.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    inputPassword.setSelection(inputPassword.length());
                }else {
                    inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status = true;
                    awesomeText.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    inputPassword.setSelection(inputPassword.length());
                }
            }
        });

        //show hide confirm password
        awesomeText2 = findViewById(R.id.awesome2);
        awesomeText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwd_status){
                    inputConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status = false;
                    awesomeText2.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    inputConfirmPassword.setSelection(inputConfirmPassword.length());
                }else {
                    inputConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status = true;
                    awesomeText2.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    inputConfirmPassword.setSelection(inputConfirmPassword.length());
                }
            }
        });


        ImgUserPhoto = findViewById(R.id.regUserPhoto) ;
        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 22) {
                    checkAndRequestForPermission();
                }
                else
                {
                    openGallery();
                }
            }
        });



    }


    //on click listener at btn register
    public void Register() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateDataAndDoRegister();
            }
        });
    }



    private void ValidateDataAndDoRegister() {

        nama = inputNama.getText().toString().trim();
        email = inputEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();
        confirmPassword = inputConfirmPassword.getText().toString().trim();
        phoneNumber = inputPhone.getText().toString().trim();


        if (nama.isEmpty())
        {
            inputNama.setError("Masukkan Nama");
            inputNama.requestFocus();
        }

        else if(email.isEmpty())
        {
            inputEmail.setError("Enter Email Address");
            inputEmail.requestFocus();
        }

        else if(email.length()<10)
        {
            inputEmail.setError("Enter valid email");
            inputEmail.requestFocus();
        }

        else if (password.isEmpty())
        {
            inputPassword.setError("Enter Password");
            inputPassword.requestFocus();
        }
        else if (inputPassword.length()<7)
        {
            inputPassword.setError("Password should be greater than 7 character");
            inputPassword.requestFocus();
        }
        else if (confirmPassword.isEmpty())
        {
            inputConfirmPassword.setError("Enter Confirm Password");
            inputConfirmPassword.requestFocus();
        }
        else if (confirmPassword.length()<7)
        {
            inputConfirmPassword.setError("Password should be greater than 7 character");
            inputConfirmPassword.requestFocus();
        }
        else if (!password.equals(confirmPassword)) //if password not equal to confirm password
        {
            inputPassword.setError("Password not matched");
            inputPassword.requestFocus();
            inputConfirmPassword.setError("Password not matched");
            inputConfirmPassword.requestFocus();
            inputPassword.setText("");
            inputConfirmPassword.setText("");
        }
        else if(phoneNumber.isEmpty()){
            inputPhone.setError("Masukkan Nomor Telefon");
            inputPhone.requestFocus();
        }
        else
        {
            doRegister(nama, email,password);
        }
    }

    private void doRegister( final String nama, String email, String password)
    {
        btnRegister.setEnabled(false);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    updateUserInfo( nama ,pickedImgUri,mAuth.getCurrentUser());
                    sendVerificationEmail();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof FirebaseAuthUserCollisionException) //this exception means email already registered
                {
                    btnRegister.setEnabled(true);
                    inputEmail.setError("Email Already Registered");
                    inputEmail.requestFocus();
                }
                else
                {
                    btnRegister.setEnabled(true);
                    Toast.makeText(RegisterActivity.this, "Opps! Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void updateUserInfo(final String nama, Uri pickedImgUri, final FirebaseUser currentUser) {

        // first we need to upload user photo to firebase storage and get url
        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = mStorage.child(pickedImgUri.getLastPathSegment());
        imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                // image uploaded succesfully
                // now we can get our image url
                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        // uri contain user image url
                        UserProfileChangeRequest profleUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(nama)
                                .setPhotoUri(uri)
                                .build();

                        currentUser.updateProfile(profleUpdate)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            // user info updated successfully
                                            showMessage("Register Complete");
                                            updateUI();
                                        }
                                    }
                                });
                    }
                });
            }
        });
    }

    //11
    private void updateUI() {
        Intent RegisterActivity = new Intent(getApplicationContext(),VerifyActivity.class);
        startActivity(RegisterActivity);
        finish();
    }

    // simple method to show toast message //7
    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }


    private void sendVerificationEmail()
    {
        if (mAuth.getCurrentUser()!=null)
        {
            mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        btnRegister.setEnabled(true);
                        sendToLoginWithEmailAndPassword();
                    }
                    else
                    {
                        btnRegister.setEnabled(true);
                        Toast.makeText(getApplicationContext(),"Oops! failed to send verification email",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendToLoginWithEmailAndPassword()
    {
        Intent intent = new Intent(getApplicationContext(), VerifyActivity.class);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        //forgot to start activity
        startActivity(intent);
    }

    private void openGallery() {
        //TODO: open gallery intent and wait for user to pick an image !
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);
    }


    private void checkAndRequestForPermission() {

        if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(RegisterActivity.this,"Please accept for required permission",Toast.LENGTH_SHORT).show();
            }
            else
            {
                ActivityCompat.requestPermissions(RegisterActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqCode);
            }
        }
        else
            openGallery();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null ) {
            // the user has successfully picked an image
            // we need to save its reference to a Uri variable
            pickedImgUri = data.getData() ;
            ImgUserPhoto.setImageURI(pickedImgUri);
        }
    }

}