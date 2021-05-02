package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.doan.adapter.SPMNAdapter;
import com.example.doan.adapter.SanPhamAdapter;
import com.example.doan.model.SanPham;
import com.example.doan.retrofit.APIUltils;
import com.example.doan.retrofit.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DTActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    int idloaisp = 0;
    String tenloaisp = "";
    List<SanPham> listSP;
    SanPhamAdapter adapter;
    SPMNAdapter adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t);
        setControll();
        setEvent();
        ActionBar();
        getDSSP();
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

    public void ActionBar(){
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
        idloaisp = intent.getIntExtra("IDLOAISP",1);
        tenloaisp = intent.getStringExtra("TENLOAISP");
        toolbar.setTitle(tenloaisp);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setControll() {
        toolbar = findViewById(R.id.toolbarDSSP);
        recyclerView = findViewById(R.id.recyclerViewDSSP);
        listSP = new ArrayList<>();
        adapter = new SanPhamAdapter(DTActivity.this,listSP);
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);
        recyclerView.setFocusable(false);
    }

    public void getDSSP(){
        DataClient data = APIUltils.getData();
        Call<List<SanPham>> callback = data.getDSSP(idloaisp);
        callback.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                List<SanPham> list = response.body();
                for (SanPham item : list){
                    listSP.add(new SanPham(item.getId(),item.getTensp(),item.getGia(),item.getKhuyenmai(),item.getMota(),item.getHinhanh(),item.getIdloaisp(),item.getTtx()));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(DTActivity.this, "Fail roi", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("AAA","SIZE OUT :" + String.valueOf(listSP.size()));
    }

    public void SendInfo(SanPham sp){

    }
}