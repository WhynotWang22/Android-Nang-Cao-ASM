package com.example.hotro.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hotro.Dao.DaoClass;
import com.example.hotro.EntityClass.HocTap;

@Database(entities = {HocTap.class},version = 1)
public abstract class DatabaseClass extends RoomDatabase {
    public abstract DaoClass getDao();
    private static DatabaseClass insance;

   static DatabaseClass getDatabase(final Context context){
        if (insance == null){
            synchronized (DatabaseClass.class){
                insance = Room.databaseBuilder(context,DatabaseClass.class,"DATABASE").build();
            }
        }
        return insance;
    }
}
