package com.example.doan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.R;
import com.example.doan.model.DetailCart;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class ITCartAdapter extends RecyclerView.Adapter<ITCartAdapter.ItemHolder> {
    Context context;
    List<DetailCart> list;

    public ITCartAdapter(Context context, List<DetailCart> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ct_lsmh,null);
        Animation ani = AnimationUtils.loadAnimation(context,R.anim.ani_itemlistview);
        view.setAnimation(ani);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        DetailCart cart = list.get(position);
        Picasso.with(context).load(cart.getHa()).into(holder.imageView);
        holder.txtTen.setText(cart.getTen());
        DecimalFormat format = new DecimalFormat("###,###,###");
        holder.txtGia.setText("Giá : " + format.format(Double.valueOf(cart.getGia()))+ " VNĐ");
        holder.txtSl.setText("Số Lượng : " + String.valueOf(cart.getSoluong()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ItemHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;
        TextView txtTen,txtGia,txtSl;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cvItemCart);
            imageView = itemView.findViewById(R.id.imgLSMH);
            txtTen = itemView.findViewById(R.id.txtTenSP_LSMH);
            txtGia = itemView.findViewById(R.id.txtGiaSP_LSMH);
            txtSl = itemView.findViewById(R.id.txtSL_LSMH);
        }
    }
}
