package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.model.DetailCart;
import com.example.doan.model.SanPham;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.DecimalFormat;

public class CTSPActivity extends AppCompatActivity {

    TextView txtTenSP,txtGiaSP,txtMKSP,txtMoTaSP;
    ImageView imgSP;
    Button btnMH;
    TextView editSL;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_t_s_p);
        setControll();
        setEvent();
        setActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cart,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.cart){
            startActivity(new Intent(getApplicationContext(),CartActivity.class));
        }
        return true;
    }

    private void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setEvent() {
        Intent intent = getIntent();
        SanPham sp = (SanPham) intent.getSerializableExtra("SANPHAM");
        txtTenSP.setText(sp.getTensp());
        txtMoTaSP.setText(sp.getMota());
        Picasso.with(getApplicationContext()).load(sp.getHinhanh()).into(imgSP);
        Double gia = Double.valueOf(sp.getGia());
        Double gia_km = gia - gia * sp.getKhuyenmai() / 100;
        DecimalFormat format = new DecimalFormat("###,###,###");
        txtMKSP.setText("GIÁ : " + format.format(gia_km) + "VNĐ");
        txtGiaSP.setText(format.format(gia) + "VND");


        btnMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = sp.getId();
                int sl = Integer.valueOf(editSL.getText().toString());
                double tt = sl * Double.valueOf(sp.getGia());
                String ten = sp.getTensp();
                String ha = sp.getHinhanh();
                String gia = sp.getGia();
                DetailCart detailCart = new DetailCart(1,id,ten,ha,sl,gia);
                boolean check = false;
                for (DetailCart item : MainActivity.listCart){
                    if (item.getIdSP() == sp.getId()){
                        item.setSoluong(item.getSoluong() + sl);
                        check = true;
                        break;
                    }
                }
                if (!check){
                    MainActivity.listCart.add(detailCart);
                }
                MainActivity.tongtien += sl * Double.valueOf(sp.getGia());
                Intent intent1 = new Intent(CTSPActivity.this,CartActivity.class);
                intent1.putExtra("SANPHAM", (Serializable) sp);
                startActivity(intent1);
            }
        });
    }

    private void setControll() {
        txtTenSP = findViewById(R.id.txtTenSP_CTSP);
        txtGiaSP = findViewById(R.id.txtGia_CTSP);
        txtMKSP = findViewById(R.id.txtGiaKMSP_CTSP);
        txtMoTaSP = findViewById(R.id.txtMoTaSP);
        imgSP = findViewById(R.id.imgCTSP);
        btnMH = findViewById(R.id.btnMH_CTSP);
        editSL = findViewById(R.id.editSL);
        toolbar = findViewById(R.id.toolbarCTSP);
    }
}