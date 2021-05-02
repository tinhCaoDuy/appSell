package com.example.doan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.CTSPActivity;
import com.example.doan.CartActivity;
import com.example.doan.MainActivity;
import com.example.doan.R;
import com.example.doan.model.DetailCart;
import com.example.doan.model.SanPham;
import com.example.doan.retrofit.APIUltils;
import com.example.doan.retrofit.DataClient;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemViewHolder> {

    Context context;
    List<SanPham> listSP;

    public SanPhamAdapter(Context context, List<SanPham> listSP) {
        this.context = context;
        this.listSP = listSP;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dt,null);
        Animation ani = AnimationUtils.loadAnimation(context,R.anim.ani_itemlistview);
        view.setAnimation(ani);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        SanPham sp = listSP.get(position);
        holder.txtTenSP_title.setText(sp.getTensp());
        holder.txtTenSP_content.setText(sp.getTensp());
        DecimalFormat format = new DecimalFormat("###,###,###");
        holder.txtGiaSP_title.setText("GIÁ : " + format.format(Double.valueOf(sp.getGia()))+ " VNĐ");
        Picasso.with(context).load(sp.getHinhanh()).into(holder.imgSP_title);
        //Picasso.with(context).load(sp.getHinhanh()).into(holder.imgSP_content);

        ArrayList<String> arr = new ArrayList<>();

        DataClient data = APIUltils.getData();
        retrofit2.Call<List<String>> callback = data.getDSHA(sp.getId());
        callback.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> list = response.body();
                for (String item : list){
                    arr.add(item);
                }
                arr.add(sp.getHinhanh());
                for (int  i = 0 ; i < arr.size(); i++){
                    ImageView img = new ImageView(context);
                    Picasso.with(context).load(arr.get(i)).into(img);
                    img.setScaleType(ImageView.ScaleType.FIT_XY);
                    holder.viewFlipper.addView(img);
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });

        holder.viewFlipper.setFlipInterval(2500);
        holder.viewFlipper.setAutoStart(true);
        Animation animation_in = AnimationUtils.loadAnimation(context,R.anim.slide_in_right);
        Animation animation_out = AnimationUtils.loadAnimation(context,R.anim.slide_out_right);
        holder.viewFlipper.setInAnimation(animation_in);
        holder.viewFlipper.setOutAnimation(animation_out);

        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.foldingCell.toggle(false);
            }
        });

        holder.btnXCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CTSPActivity.class);
                intent.putExtra("SANPHAM", (Serializable) sp);
                context.startActivity(intent);
            }
        });

        holder.btnMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CartActivity.class);
                intent.putExtra("SANPHAM", (Parcelable) sp);
                int id = sp.getId();
                String ten = sp.getTensp();
                String ha = sp.getHinhanh();
                int sl = 1;
                String gia  = sp.getGia();
                DetailCart detailCart = new DetailCart(1,id,ten,ha,sl,gia);
                boolean check = false;
                for (DetailCart item : MainActivity.listCart){
                    if (item.getIdSP() == sp.getId()){
                        item.setSoluong(item.getSoluong() + 1);
                        check = true;
                        break;
                    }
                }
                if (!check){
                    MainActivity.listCart.add(detailCart);
                }
                MainActivity.tongtien += sl * Double.valueOf(sp.getGia());
                context.startActivity(new Intent(context,CartActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSP.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        FoldingCell foldingCell;
        ImageView imgSP_title;
        ViewFlipper viewFlipper;
        TextView txtTenSP_title,txtTenSP_content,txtGiaSP_title;
        Button btnXCT,btnMH;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            foldingCell = itemView.findViewById(R.id.folding_cell);
            imgSP_title = itemView.findViewById(R.id.imgSP_title);
            viewFlipper = itemView.findViewById(R.id.viewFlipperCTSP);
            txtTenSP_title = itemView.findViewById(R.id.txtTenSP_title);
            txtTenSP_content = itemView.findViewById(R.id.txtTenSP_content);
            txtGiaSP_title = itemView.findViewById(R.id.txtGiaSP_title);
            btnXCT = itemView.findViewById(R.id.btnCTDT);
            btnMH = itemView.findViewById(R.id.btnMuaHang);
        }
    }
}
