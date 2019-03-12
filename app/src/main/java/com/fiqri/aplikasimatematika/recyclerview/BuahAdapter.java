package com.fiqri.aplikasimatematika.recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fiqri.aplikasimatematika.R;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.ViewHolder> {

    // TODO 1 deklarasi data yang akan ditampilkan
    private String nameBuah[] = {"Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};
    private int imagesBuah[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri,
            R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};

    // TODO 2 deklarasi context
    private Context ctx;

    // TODO 3 constructor
    public BuahAdapter(Context ctx) {
        this.ctx = ctx;
    }

    // TODO 4
    /**
     * function / method ini digunakan untuk menyisipkan layout untuk penampung item nya
     */
    @NonNull
    @Override
    public BuahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup vg, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_buah, vg, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // TODO 6
    /**
     * function / method ini digunakan untuk return data yang akan ditampilkan sesuai index nya
     */
    @Override
    public void onBindViewHolder(@NonNull BuahAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvBuah.setText(nameBuah[i]);
        viewHolder.ivBuah.setImageResource(imagesBuah[i]);
    }

    // TODO 7
    /**
     * funtion / method ini digunakan untuk return jumlah value yang mau ditampilkan / looping
     */
    @Override
    public int getItemCount() {
        return nameBuah.length;
    }

    // TODO 5
    /**
     * class ini digunakan untuk deklarasi dan casting view id sesuai dengan id nya masing"
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBuah;
        TextView tvBuah;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvBuah = itemView.findViewById(R.id.tv_nama_buah);
            ivBuah = itemView.findViewById(R.id.iv_buah);
        }
    }
}
