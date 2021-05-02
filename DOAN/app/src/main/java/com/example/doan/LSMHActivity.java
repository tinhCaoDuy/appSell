package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.doan.adapter.LSMHAdapter;
import com.example.doan.model.Cart;
import com.example.doan.retrofit.APIUltils;
import com.example.doan.retrofit.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LSMHActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Cart> list = new ArrayList<>();
    LSMHAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_s_m_h);
        setControl();
        setEvent();
        getDSGH();
    }

    private void getDSGH() {
        DataClient data = APIUltils.getData();
        Call<List<Cart>> callback = data.getCartByID(LoginActivity.user.getId());
        callback.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                List<Cart> listCart = new ArrayList<>();
                listCart = response.body();
                for(Cart item : listCart){
                    list.add(new Cart(item.getId(),item.getIdUser(),item.getNgayMua(),item.getTongtien(),item.getTrangthai()));
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {

            }
        });
        Log.d("AAA",String.valueOf(list.size()));
    }

    private void setEvent() {
        adapter = new LSMHAdapter(this,list);
        GridLayoutManager layout = new GridLayoutManager(LSMHActivity.this,1);
        recyclerView.setHasFixedSize(false);
        layout.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
    }

    private void setControl() {
        toolbar = findViewById(R.id.toolbarLSMH);
        recyclerView = findViewById(R.id.recyclerViewLSMH);
    }
}