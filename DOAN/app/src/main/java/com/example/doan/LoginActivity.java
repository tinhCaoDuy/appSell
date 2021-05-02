package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.model.User;
import com.example.doan.retrofit.APIUltils;
import com.example.doan.retrofit.DataClient;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnRegister,btnLogin;
    TextView txtLogin;
    TextInputEditText editEmail,editPassword;

    String email = "";
    String pass = "";
    public static User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setControll();
        setEvent();
    }

    private void setEvent() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(txtLogin,"txtLogin");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,activityOptions.toBundle());
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()){
                    return;
                }
                DataClient data = APIUltils.getData();
                Call<User> callback = data.login(email,pass);
                callback.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        user = new User();
                        user = response.body();
                        if (user == null){
                            Toast.makeText(LoginActivity.this, "TÀI KHOẢN KHÔNG TỒN TẠI", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if (user.getQuyen().compareTo("1") == 0){
                                Intent intent = new Intent(LoginActivity.this,AdminActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                intent.putExtra("USER", (Serializable) user);
                                startActivity(intent);
                            }

                        }


                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "TÀI KHOẢN KHÔNG TỒN TẠI", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void setControll(){
        btnRegister = findViewById(R.id.imgbtnRegister);
        txtLogin = findViewById(R.id.txtLogin);
        editEmail = findViewById(R.id.editEmail_Login);
        editPassword = findViewById(R.id.editPassword_Login);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public boolean validate(){
        email = editEmail.getText().toString();
        pass = editPassword.getText().toString();
        if (email.isEmpty()){
            editEmail.setError("Email không được trống");
            return false;
        }
        else{
            editEmail.setError(null);
        }

        if (pass.isEmpty()){
            editPassword.setError("Password không được trống");
            return false;
        }
        else{
            editPassword.setError(null);
        }
        return true;
    }
}