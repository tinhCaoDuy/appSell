package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.adapter.CartAdapter;
import com.example.doan.model.Cart;
import com.example.doan.model.DetailCart;
import com.example.doan.model.SanPham;
import com.example.doan.retrofit.APIUltils;
import com.example.doan.retrofit.DataClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    public static TextView txtTT,txtTB;
    Button btnTT,btnMH;
    public static CartAdapter adapter;
    public static int idCart = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setControll();
        setEvent();
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


    private void setEvent() {
        Intent intent = getIntent();
        SanPham sp = (SanPham) intent.getSerializableExtra("SANPHAM");
        adapter = new CartAdapter(this,MainActivity.listCart);
        GridLayoutManager layout = new GridLayoutManager(CartActivity.this,1);
        recyclerView.setHasFixedSize(false);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
        DecimalFormat format  = new DecimalFormat("###,###,###");
        if (MainActivity.listCart.size() ==0){
            txtTT.setText("TỔNG TIỀN : 0 VNĐ");
            txtTB.setVisibility(View.VISIBLE);
        }
        else{
            txtTT.setText("TỔNG TIỀN : " + format.format(MainActivity.tongtien) + " VNĐ");
            txtTB.setVisibility(View.INVISIBLE);
        }

        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.listCart.size() == 0){
                    Toast.makeText(CartActivity.this, "Giỏ Hàng Đang Trống.Vui Lòng Chọn Sản Phẩm", Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(CartActivity.this,ConfirmActivity.class));
//                    try {
//
//                        insertCart();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });



        btnMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,MainActivity.class));
            }
        });


    }

    private void setControll() {
        toolbar = findViewById(R.id.toolbarCart);
        recyclerView = findViewById(R.id.recyclerViewCart);
        txtTT = findViewById(R.id.txtTongTien);
        btnMH = findViewById(R.id.btnTTMH);
        btnTT = findViewById(R.id.btnThanhToan);
        txtTB = findViewById(R.id.txtTB);
    }
}