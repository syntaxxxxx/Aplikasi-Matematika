package com.fiqri.aplikasimatematika;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // TODO 1 deklarasi
    EditText edtPanjang, edtLebar, edtTinggi;
    Button btnHitung;
    TextView tvResult;

    // variable penampung
    String panjang, lebar, tinggi;

    // TODO 8 deklarasi key sbg penjaga state data
    final String STATE_DATA = "STATE_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 2 casting view / hub dengan id nya masing"
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar = findViewById(R.id.edt_lebar);
        edtTinggi = findViewById(R.id.edt_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvResult = findViewById(R.id.tv_hasil);

        // TODO 3 event click listener / button something to do
        btnHitung.setOnClickListener(this);

        // TODO 9
        if (savedInstanceState != null) {
            String state = savedInstanceState.getString(STATE_DATA);
            tvResult.setText(state);
        }
    }

    // TODO 7
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_DATA, tvResult.getText().toString().trim());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hitung:
                setSelectionInput();
                break;
        }
    }

    // TODO 4 selection inputan user
    private void setSelectionInput() {

        // ambil inputan user didalam edit text
        panjang = edtPanjang.getText().toString().trim();
        lebar = edtLebar.getText().toString().trim();
        tinggi = edtTinggi.getText().toString().trim();

        String empty = "Tidak Boleh Kosong";
        String inValid = "Harus Berupa Valid Number";

        boolean isEmpty = false;
        boolean isValid = false;

        // buat kondisi
        if (TextUtils.isEmpty(panjang)) {
            isEmpty = true;
            edtPanjang.setError(empty);
            edtPanjang.requestFocus();

        } else if (!isDouble(panjang)) {
            isValid = true;
            edtPanjang.setError(inValid);
            edtPanjang.requestFocus();
        }

        if (TextUtils.isEmpty(lebar)) {
            isEmpty = true;
            edtLebar.setError(empty);
            edtLebar.requestFocus();

        } else if (!isDouble(lebar)) {
            isValid = true;
            edtLebar.setError(inValid);
            edtLebar.requestFocus();
        }

        if (TextUtils.isEmpty(tinggi)) {
            isEmpty = true;
            edtTinggi.setError(empty);
            edtTinggi.requestFocus();

        } else if (!isDouble(tinggi)) {
            isValid = true;
            edtTinggi.setError(inValid);
            edtTinggi.requestFocus();
        }

        // TODO 6 buat kondisi untuk kalkulasi hitungan
        if (!isEmpty && !isValid) {

            // parsing type data dari String => double
            double p = Double.parseDouble(panjang);
            double l = Double.parseDouble(lebar);
            double t = Double.parseDouble(tinggi);

            // kalikan
            double result = p * l * t;

            // tampilkan
            tvResult.setText(String.valueOf(result));
        }
    }

    // TODO 5 method / function untuk value double
    boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
