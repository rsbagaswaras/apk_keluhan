package com.example.form_keluhan.Form;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.form_keluhan.Admin.AdminActivityy;
import com.example.form_keluhan.R;
import com.example.form_keluhan.RegLogin.EmailLoginActivity;
import com.example.form_keluhan.RegLogin.PhoneLoginActivity;
import com.example.form_keluhan.RegLogin.RegisterActivity;
import com.example.form_keluhan.lantai1.Lantai1Activity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Form {
    private String postKey;
    private String tanggal_penyampaian;
    private String nama_responden;
    private String ruangan;
    private String keluhan;
    private String picture;
    private String kategori;

    public Form(String tanggal_penyampaian, String nama, String ruangan,String kategori, String keluhan, String picture) {
        this.postKey = postKey;
        this.tanggal_penyampaian = tanggal_penyampaian;
        this.nama_responden = nama;
        this.ruangan = ruangan;
        this.kategori = kategori;
        this.keluhan = keluhan;
        this.picture = picture;
    }

    public Form() {

    }

    public String getPostKey() {
        return postKey;
    }

    public String getTanggal_penyampaian() {
        return tanggal_penyampaian;
    }

    public String getNama_responden() {
        return nama_responden;
    }

    public String getRuangan() {
        return ruangan;
    }

    public String getKategori() {
        return kategori;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getPicture() {
        return picture;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public void setTanggal_penyampaian(String tanggal_penyampaian) {
        this.tanggal_penyampaian = tanggal_penyampaian;
    }

    public void setNama_responden(String nama_responden) {
        this.nama_responden = nama_responden;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public static class LoginActivity extends AppCompatActivity {

        LinearLayout linearLayout;
        AnimationDrawable animationDrawable;

        private static final String TAG = "Login" ;
        private GoogleSignInClient mGoogleSignInClient;
        private final static int RC_SIGN_IN = 123;

        Button verify, btn_reg, btn_login, btn_number;
        private FirebaseAuth mAuth;
        private GoogleSignInOptions gso;

        private boolean doubleBacktoExit = false;

        private TextView sayaadmin;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            linearLayout = (LinearLayout) findViewById(R.id.login);
            animationDrawable = (AnimationDrawable) linearLayout.getBackground();

            animationDrawable.setEnterFadeDuration(2000);
            animationDrawable.setExitFadeDuration(2000);

            sayaadmin =findViewById(R.id.sayaadmin);
            Admin();

            btn_number = findViewById(R.id.btn_phonenumber);
            btn_number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, PhoneLoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });


            btn_reg = findViewById(R.id.btn_reg);
            btn_reg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            });


            btn_login = findViewById(R.id.btn_login);
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, EmailLoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });


            mAuth = FirebaseAuth.getInstance();

            createRequest();

            findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signIn();
                }
            });


        }

        //On click listener to tv login to move to login activity
        public void Admin() {
            sayaadmin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, AdminActivityy.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onStart() {
            super.onStart();

            FirebaseUser user = mAuth.getCurrentUser();
            if(user!=null){
                Intent intent = new Intent(getApplicationContext(), Lantai1Activity.class );
                startActivity(intent);
                finish();
            }
        }

        private void createRequest() {
            // Configure Google Sign In
            gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build();

            // Build a GoogleSignInClient with the options specified by gso.
            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        }

        private void signIn() {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
            if (requestCode == RC_SIGN_IN) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                try {
                    //Google Sign In was successful, authenticate with Firebase
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                    firebaseAuthWithGoogle(account.getIdToken());
                } catch (ApiException e) {
                    // Google Sign In failed, update UI appropriately
                    //  Log.w(TAG, "Google sign in failed", e);
                    // ...
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }

        private void firebaseAuthWithGoogle(String idToken) {

            AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithCredential:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class );
                                startActivity(intent);
                                finish();

                                // } else {
                                //   Toast.makeText(MainActivity.this, "Sorry Auth Failed", Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user.
                                // Log.w(TAG, "signInWithCredential:failure", task.getException());
                                //  updateUI(null);
                            }

                            // ...
                        }
                    });
        }



        @Override
        public void onBackPressed() {
            if (doubleBacktoExit){
                super.onBackPressed();
                return;
            }
            this.doubleBacktoExit = true;
            Toast.makeText(this, "Tekan Lagi Untuk Keluar",Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBacktoExit = false;
                }
            }, 2000);
        }

        @Override
        protected void onPause() {
            super.onPause();

            if (animationDrawable != null && animationDrawable.isRunning()){
                animationDrawable.stop();
            }
        }

        @Override
        protected void onResume() {
            super.onResume();

            if (animationDrawable != null && !animationDrawable.isRunning()){
                animationDrawable.start();
            }
        }


    }
}