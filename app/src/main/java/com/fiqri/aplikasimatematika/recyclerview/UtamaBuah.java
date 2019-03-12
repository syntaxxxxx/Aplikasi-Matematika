package com.fiqri.aplikasimatematika.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fiqri.aplikasimatematika.R;

public class UtamaBuah extends AppCompatActivity {

    // TODO 8 deklarasi
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama_buah);

        // TODO 9 casting view / hub dengan id nya masing"
        recyclerView = findViewById(R.id.recyclerview);

        // buat object dari class adapter
        BuahAdapter adapter = new BuahAdapter(this);

        // kalo tidak ada penambahan data kasih value ture
        recyclerView.setHasFixedSize(true);

        // cara nampilin data list nya mau seperti apa
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // add recyclerview ke dalam adapter
        recyclerView.setAdapter(adapter);
    }
}
