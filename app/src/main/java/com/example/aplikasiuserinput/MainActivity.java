package com.example.aplikasiuserinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edSisi;
    Button btnHitung;
    TextView tvHasil;
    Spinner spinnerPilihan;
    String[] pilihanHitung = {"Volume", "Keliling", "Luas Pemukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSisi = findViewById(R.id.ed_sisi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        spinnerPilihan = findViewById(R.id.spinner_pilihan);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[0])) {
                    //rumus volume
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    Double hasil = sisi * sisi * sisi;
                    tvHasil.setText(hasil.toString());
                } else if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[1])) {
                    //rumus keliling
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    Double hasil = 6 * sisi * sisi;
                    tvHasil.setText(hasil.toString());
                } else if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[2])) {
                    //rumus luas permukaan
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    Double hasil = 12 * sisi * sisi;
                    tvHasil.setText(hasil.toString());
                }
            }
        });

        //data
        //adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihanHitung);
        spinnerPilihan.setAdapter(adapter);
    }
}