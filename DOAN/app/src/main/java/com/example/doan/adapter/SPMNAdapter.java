package com.example.doan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.CTSPActivity;
import com.example.doan.MainActivity;
import com.example.doan.R;
import com.example.doan.model.SanPham;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class SPMNAdapter extends RecyclerView.Adapter<SPMNAdapter.ItemHolder> {
    Context context;
    List<SanPham> list;

    public SPMNAdapter(Context context, List<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spmoinhat,null);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        SanPham sp = list.get(position);
        holder.txtTenSP.setText(sp.getTensp());
        DecimalFormat format = new DecimalFormat("###,###,###");
        holder.txtGiaSP.setText("Giá : " + format.format(Double.valueOf(sp.getGia())) + " VND");
        Picasso.with(context).load(sp.getHinhanh()).into(holder.imgSP);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CTSPActivity.class);
                intent.putExtra("SANPHAM", (Serializable) sp);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgSP;
        public TextView txtTenSP,txtGiaSP;
        public CardView cardView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgSP = itemView.findViewById(R.id.imgSPMN);
            txtTenSP = itemView.findViewById(R.id.txtTenSPMN);
            txtGiaSP = itemView.findViewById(R.id.txtGiaSPMN);
            cardView = itemView.findViewById(R.id.cvSanPham);
        }
    }
}
