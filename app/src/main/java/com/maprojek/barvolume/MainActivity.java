package com.maprojek.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editPanjang, editLebar, editTinggi;
    private Button btnHitung;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi
        editPanjang = findViewById(R.id.edit_panjang);
        editLebar = findViewById(R.id.edit_lebar);
        editTinggi = findViewById(R.id.edit_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        txtHasil = findViewById(R.id.txt_hasil);

        //klik button
        btnHitung.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn_hitung){
            //mengambil text dalam bentuk string dan di trim(menghapus spasi diawal dan akhir text)
            String inputPanjang = editPanjang.getText().toString().trim();
            String inputLebar = editLebar.getText().toString().trim();
            String inputTinggi = editTinggi.getText().toString().trim();

            //inisialisasi field dan nilai double
            boolean fieldKosong = false;
            boolean invalidDouble = false;

            if(TextUtils.isEmpty(inputPanjang)){
                fieldKosong = true;
                editPanjang.setError("Field tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputLebar)){
                fieldKosong = true;
                editLebar.setError("Field tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputTinggi)){
                fieldKosong = true;
                editTinggi.setError("Field tidak boleh kosong");
            }

            //Double length = toDouble(inputPanjang);
            Double panjang = Double.parseDouble(inputPanjang);
            Double lebar = Double.parseDouble(inputLebar);
            Double tinggi = Double.parseDouble(inputTinggi);

            if(panjang == null){
                invalidDouble = true;
                editPanjang.setError("Field ini harus diisi dengan angka");
            }
            if(lebar == null){
                invalidDouble = true;
                editPanjang.setError("Field ini harus diisi dengan angka");
            }
            if(tinggi == null){
                invalidDouble = true;
                editPanjang.setError("Field ini harus diisi dengan angka");
            }

            if(!fieldKosong && !invalidDouble){
                Double volume = panjang*lebar*tinggi;
                //mengubah hasil dari double ke string
                txtHasil.setText(String.valueOf(volume));
            }


        }

    }


}
