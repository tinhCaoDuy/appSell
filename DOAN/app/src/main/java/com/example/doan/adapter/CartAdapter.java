package com.example.doan.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.CartActivity;
import com.example.doan.MainActivity;
import com.example.doan.R;
import com.example.doan.model.DetailCart;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ItemHoler> {
    Context context;
    List<DetailCart> list;

    public CartAdapter(Context context, List<DetailCart> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,null);
        Animation ani = AnimationUtils.loadAnimation(context,R.anim.ani_itemlistview);
        view.setAnimation(ani);
        return new ItemHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHoler holder, int position) {
        DetailCart detailCart = list.get(position);
        Picasso.with(context).load(detailCart.getHa()).into(holder.imgSP);
        holder.txtTenSP.setText(detailCart.getTen());
        holder.txtSL.setText(String.valueOf(detailCart.getSoluong()));
        DecimalFormat format = new DecimalFormat("###,###,###");
        Double gia = Double.valueOf(detailCart.getGia());
        holder.txtGiaSP.setText(format.format(gia) + " VNĐ");

        holder.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailCart.setSoluong(detailCart.getSoluong() + 1);
                holder.txtSL.setText(String.valueOf(detailCart.getSoluong()));
                MainActivity.tongtien += Double.valueOf(detailCart.getGia());
                CartActivity.txtTT.setText("TỔNG TIỀN : " + format.format(MainActivity.tongtien) + "VNĐ");
                if (Integer.valueOf(holder.txtSL.getText().toString()) == 10){
                    holder.btnCong.setVisibility(View.INVISIBLE);
                    holder.btnTru.setVisibility(View.VISIBLE);
                }
                else{
                    if (Integer.valueOf(holder.txtSL.getText().toString()) == 1){
                        holder.btnCong.setVisibility(View.VISIBLE);
                        holder.btnTru.setVisibility(View.INVISIBLE);
                    }
                    else{
                        holder.btnCong.setVisibility(View.VISIBLE);
                        holder.btnTru.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        holder.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailCart.getSoluong() == 1){
                    return;
                }
                detailCart.setSoluong(detailCart.getSoluong() - 1);
                holder.txtSL.setText(String.valueOf(detailCart.getSoluong()));
                MainActivity.tongtien -= Double.valueOf(detailCart.getGia());
                CartActivity.txtTT.setText("TỔNG TIỀN : " + format.format(MainActivity.tongtien) + " VNĐ");
                if (Integer.valueOf(holder.txtSL.getText().toString()) == 10){
                    holder.btnCong.setVisibility(View.INVISIBLE);
                    holder.btnTru.setVisibility(View.VISIBLE);
                }
                else{
                    if (Integer.valueOf(holder.txtSL.getText().toString()) == 1){
                        holder.btnCong.setVisibility(View.VISIBLE);
                        holder.btnTru.setVisibility(View.INVISIBLE);
                    }
                    else{
                        holder.btnCong.setVisibility(View.VISIBLE);
                        holder.btnTru.setVisibility(View.VISIBLE);
                    }
                }

            }
        });

        if (Integer.valueOf(holder.txtSL.getText().toString()) == 10){
            holder.btnCong.setVisibility(View.INVISIBLE);
            holder.btnTru.setVisibility(View.VISIBLE);
        }
        else{
            if (Integer.valueOf(holder.txtSL.getText().toString()) == 1){
                holder.btnCong.setVisibility(View.VISIBLE);
                holder.btnTru.setVisibility(View.INVISIBLE);
            }
            else{
                holder.btnCong.setVisibility(View.VISIBLE);
                holder.btnTru.setVisibility(View.VISIBLE);
            }
        }

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("XÁC NHẬN");
                dialog.setMessage("BẠN CÓ CHẮC CHẮN MUỐN XÓA SẢN PHẨM NÀY KHỎI GIỎ HÀNG KHÔNG");
                dialog.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.listCart.remove(detailCart);
                        MainActivity.tongtien -= detailCart.getSoluong() * Double.valueOf(detailCart.getGia());
                        CartActivity.txtTT.setText("TỔNG TIỀN : " + format.format(MainActivity.tongtien) + " VNĐ");
                        CartActivity.adapter.notifyDataSetChanged();
                        if (MainActivity.listCart.size() == 0){
                            CartActivity.txtTB.setVisibility(View.VISIBLE);
                        }
                    }
                });

                dialog.setNegativeButton("KHÔNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemHoler extends RecyclerView.ViewHolder{

        TextView txtTenSP,txtGiaSP,txtSL;
        Button btnCong,btnTru;
        ImageView imgSP;
        CardView cardView;

        public ItemHoler(@NonNull View itemView) {
            super(itemView);
            txtTenSP = itemView.findViewById(R.id.txtTenSP_Cart);
            txtGiaSP = itemView.findViewById(R.id.txtGiaSP_Cart);
            imgSP = itemView.findViewById(R.id.imgCart);
            txtSL = itemView.findViewById(R.id.txtSL_Cart);
            btnCong = itemView.findViewById(R.id.btnCong);
            btnTru = itemView.findViewById(R.id.btnTru);
            cardView = itemView.findViewById(R.id.cvItemCart);
        }
    }
}
