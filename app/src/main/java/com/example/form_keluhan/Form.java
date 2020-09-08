package com.example.form_keluhan;


import com.google.firebase.database.ServerValue;

public class Form {
    private String postKey;
    private String nama;
    private String ruangan;
    private String keluhan;
    private String picture;
    private String userId;
    private String userPhoto;
    private Object timeStamp ;


    public Form(String nama, String ruangan, String keluhan, String picture, String userId, String userPhoto) {
        this.postKey = postKey;
        this.nama = nama;
        this.ruangan = ruangan;
        this.keluhan = keluhan;
        this.picture = picture;
        this.userId = userId;
        this.userPhoto = userPhoto;
        this.timeStamp = ServerValue.TIMESTAMP;
    }

    public Form() {
    }

    public String getPostKey() {
        return postKey;
    }

    public String getNama() {
        return nama;
    }

    public String getRuangan() {
        return ruangan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getPicture() {
        return picture;
    }

    public String getUserId() { return userId; }

    public String getUserPhoto() { return userPhoto; }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public void setUserPhoto(String userPhoto) { this.userPhoto = userPhoto; }


}
