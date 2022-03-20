package com.example.hotro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotro.EntityClass.HocTap;

public class MainActivity2 extends AppCompatActivity {
    private EditText mamon;
    private EditText lop;
    private EditText ngaythi;
    private EditText kyhoc;
    private EditText lichhoc;
    private Button btnSave,btngetData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mamon = (EditText) findViewById(R.id.mamon);
        lop = (EditText) findViewById(R.id.lop);
        ngaythi = (EditText) findViewById(R.id.ngaythi);
        kyhoc = (EditText) findViewById(R.id.kyhoc);
        lichhoc = (EditText) findViewById(R.id.lichhoc);
        btnSave = (Button) findViewById(R.id.btn_save);
      btngetData = findViewById(R.id.btn_getData);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               saveData();
            }
        });
        btngetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GetData3.class));
            }
        });

    }
    private void saveData(){
        String mamon_txt = mamon.getText().toString().trim();
        String lop_txt = lop.getText().toString().trim();
        String ngaythi_txt = ngaythi.getText().toString().trim();
        String kyhoc_txt = kyhoc.getText().toString().trim();
        String lichhoc_txt = lichhoc.getText().toString().trim();




            HocTap model = new HocTap();

            model.setMamon(mamon_txt);
            model.setLop(lop_txt);
            model.setNgaythi(ngaythi_txt);
            model.setKyhoc(kyhoc_txt);
            model.setLichhoc(lichhoc_txt);


            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(model);

            mamon.setText("");
        lop.setText("");
        ngaythi.setText("");
        kyhoc.setText("");
        lichhoc.setText("");
            Toast.makeText(this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();


    }
}