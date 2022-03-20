package com.example.hotro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {
    private EditText mamon;
    private EditText lop;
    private EditText ngaythi;
    private EditText kyhoc;
    private EditText lichhoc;
    private Button update;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        mamon = (EditText) findViewById(R.id.mamon);
        lop = (EditText) findViewById(R.id.lop);
        ngaythi = (EditText) findViewById(R.id.ngaythi);
        kyhoc = (EditText) findViewById(R.id.kyhoc);
        lichhoc = (EditText) findViewById(R.id.lichhoc);
        update = (Button) findViewById(R.id.btn_update);

        mamon.setText(getIntent().getExtras().getString("mamon"));
        lop.setText(getIntent().getExtras().getString("lop"));
        ngaythi.setText(getIntent().getExtras().getString("ngaythi"));
        kyhoc.setText(getIntent().getExtras().getString("kyhoc"));
        lichhoc.setText(getIntent().getExtras().getString("lichhoc"));
        String id = getIntent().getExtras().getString("id");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String mamon_txt = mamon.getText().toString().trim();
                String lop_txt = lop.getText().toString().trim();
                String ngaythi_txt = ngaythi.getText().toString().trim();
                String kyhoc_txt = kyhoc.getText().toString().trim();
                String lichhoc_txt = lichhoc.getText().toString().trim();
                if (mamon_txt.equals("") || lop_txt.equals("") || ngaythi_txt.equals("") || kyhoc_txt.equals("") || lichhoc_txt.equals(""))
                {
                    Toast.makeText(UpdateData.this, "Update that bai ", Toast.LENGTH_SHORT).show();
                }else
                {
                    DatabaseClass.getDatabase(getApplicationContext()).getDao().updateData(mamon_txt,lop_txt,ngaythi_txt,kyhoc_txt,lichhoc_txt,Integer.parseInt(id));
                    finish();
                }
            }
        });
    }
}