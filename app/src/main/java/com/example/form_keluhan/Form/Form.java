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


}
