package com.example.hotro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hotro.Adapter.HocTapAdapter;
import com.example.hotro.EntityClass.HocTap;

import java.util.ArrayList;
import java.util.List;

public class GetData3 extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<HocTap>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata3);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);


    }
   @Override
   protected void onResume(){
        super.onResume();
       getData();
   }
    private void getData() {
        list = new ArrayList<>();
        list = DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData();
        recyclerview.setAdapter(new HocTapAdapter(getApplicationContext(), list, new HocTapAdapter.DeleteItemClicklistner() {
            @Override
            public void onItemDelete(int position, int id) {
             DatabaseClass.getDatabase(getApplicationContext()).getDao().deleteData(id);
             getData();
            }
        }));
    }
}