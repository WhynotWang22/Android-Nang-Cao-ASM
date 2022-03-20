package com.example.hotro.EntityClass;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hoctap")
public class HocTap {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;


    @ColumnInfo(name = "mamon")
    private String mamon;

    @ColumnInfo(name = "lop")
    private String lop;

    @ColumnInfo(name = "ngaythi")
    private String ngaythi;

    @ColumnInfo(name = "kyhoc")
    private String kyhoc;

    @ColumnInfo(name = "lichhoc")
    private String lichhoc;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }

    public String getLichhoc() {
        return lichhoc;
    }

    public void setLichhoc(String lichhoc) {
        this.lichhoc = lichhoc;
    }
}
