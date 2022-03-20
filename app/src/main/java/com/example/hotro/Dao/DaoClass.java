package com.example.hotro.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hotro.EntityClass.HocTap;

import java.util.List;

@Dao
public interface DaoClass {


    @Insert
    void insertAllData(HocTap hocTapmodel);

    @Query("select * from hoctap")
    List<HocTap> getAllData();

    //detele Data
    @Query("delete from hoctap where `key` = :id")
    void deleteData(int id);

    //update data
    @Query("update hoctap SET mamon = :mamon,lop = :lop,ngaythi = :ngaythi,kyhoc = :kyhoc,lichhoc = :lichhoc where `key` = :key ")
    void updateData(String mamon, String lop, String ngaythi, String kyhoc, String lichhoc, int key);
}
