package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.doan.model.User;
import com.example.doan.retrofit.APIUltils;
import com.example.doan.retrofit.DataClient;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    RelativeLayout layout;
    Animation animation;
    Toolbar toolbar;
    Button btnSignup;
    TextInputEditText editUsername,editEmail,editPassword,editPhone,editAddress;

    String username;
    String email;
    String pass ;
    String phone ;
    String address ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setControll();
        setEvent();
    }


    private void setControll() {
        layout = findViewById(R.id.formSignup);
        toolbar = findViewById(R.id.toolbarheader);
        btnSignup = findViewById(R.id.btnSignup);
        editEmail = findViewById(R.id.editEmail_Signup);
        editAddress = findViewById(R.id.editAddress);
        editPassword = findViewById(R.id.editPassword_Signup);
        editPhone = findViewById(R.id.editPhone);
        editUsername = findViewById(R.id.editUsername);
    }

    private void setEvent() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        animation = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        layout.setAnimation(animation);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()){
                    return;
                }
                else{
                    DataClient data = APIUltils.getData();
                    Call<String> callback = data.signup(username,email,pass,phone,address);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result = response.body();
                            if (result.compareTo("success") ==0){
                                Toast.makeText(SignUpActivity.this, "????NG K?? TH??NH C??NG", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else{
                                Toast.makeText(SignUpActivity.this, "????NG K?? TH???T B???I", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this, "L???i", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean validate(){
        boolean check = true;
         username = editUsername.getText().toString();
         email = editEmail.getText().toString();
         pass = editPassword.getText().toString();
         phone = editPhone.getText().toString();
         address = editAddress.getText().toString();

        if (username.isEmpty()){
            editUsername.setError("VUI L??NG NH???P T??N");
            check = false;
        }
        else{
            editUsername.setError(null);
            check = true;
        }

        if (email.isEmpty()){
            editEmail.setError("VUI L??NG NH???P EMAIL");
            check = false;
        }
        else{
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            if (!email.matches(emailPattern)){
                editEmail.setError("EMAIL KH??NG H???P L???");
                check = false;
            }
            else{
                editEmail.setError(null);
                check = true;
            }
        }

        if (pass.length() < 6){
            editPassword.setError("M???T KH???U PH???I ????? 6 K?? T???");
            check =  false;
        }
        else{
            editPassword.setError(null);
            check = true;
        }

        if (phone.length() < 10){
            editPhone.setError("SDT KH??NG H???P L???");
            check =  false;
        }
        else{
            editPhone.setError(null);
            check = true;
        }

        if (address.isEmpty()){
            editAddress.setError("VUI L??NG NH???P ?????A CH???");
            check = false;
        }
        else{
            editAddress.setError(null);
            check = true;
        }

        return check;

    }
}