package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doan.model.DetailCart;
import com.example.doan.retrofit.APIUltils;
import com.example.doan.retrofit.DataClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ConfirmActivity extends AppCompatActivity {

    EditText num1,num2,num3,num4;
    Button btnComfirm;
    String content = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        setControl();
        setEvent();

    }

    private void setControl() {
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        btnComfirm = findViewById(R.id.btnComfirm);
    }

    private void setEvent() {
        Random random = new Random();
        int code = random.nextInt(8999) + 1000;

        content = "MÃ CODE : " + String.valueOf(code) + "\n";
        content += "\nDANH SÁCH ĐƠN HÀNG";

        for(DetailCart item : MainActivity.listCart){
            content += "\n+ Tên Mặt Hàng : " + item.getTen() + " - Số Lượng " + String.valueOf(item.getSoluong());
        }

//        SendMail sendMail = new SendMail(this,LoginActivity.user.getEmail(),"VERIFY MAIL",content);
//        sendMail.execute();

        btnComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code_input = num1.getText().toString() + num2.getText().toString() + num3.getText().toString() + num4.getText().toString();
               if (code_input.compareTo(String.valueOf(code)) ==0){
//                   try {
//                       insertCart();
//                   } catch (JSONException e) {
//                       e.printStackTrace();
//                   }
                   Toast.makeText(ConfirmActivity.this, "MUA HANG THANH CONG", Toast.LENGTH_SHORT).show();
                  // startActivity(new Intent(ConfirmActivity.this,MainActivity.class));
               }
               else{
                   Toast.makeText(ConfirmActivity.this, "Ma Code chua dung!Xin kiem tra lai", Toast.LENGTH_SHORT).show();
               }

            }
        });



    }

    public void insertCart() throws JSONException {

        int idUser = LoginActivity.user.getId();
        long millis=System.currentTimeMillis();
        java.sql.Date date =new java.sql.Date(millis);
        String trangthai = "DANG GIAO HANG";
        JSONArray array = new JSONArray();
        for (DetailCart item : MainActivity.listCart){



            JSONObject object = new JSONObject();
            object.put("idSP",item.getIdSP());
            object.put("soluong",item.getSoluong());
            array.put(object);
        }

        DataClient data = APIUltils.getData();
        Call<String> callback = data.insertCart(idUser,String.valueOf(date),String.valueOf(MainActivity.tongtien),trangthai,array);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Toast.makeText(CartActivity.this, "CẢM ƠN BẠN ĐÃ MUA HÀNG", Toast.LENGTH_SHORT).show();
                MainActivity.listCart.clear();
                //txtTB.setVisibility(View.VISIBLE);
                //adapter.notifyDataSetChanged();
                MainActivity.tongtien = 0;
                //txtTT.setText("TỔNG TIỀN : 0 VNĐ");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                //Toast.makeText(CartActivity.this, String.valueOf(t), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class SendMail extends AsyncTask<Void,Void,Void>{
        private Session session;
        private Context context;
        private String email,subject,message;

        public SendMail(Context context, String email, String subject, String message) {
            this.context = context;
            this.email = email;
            this.subject = subject;
            this.message = message;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Properties pro  = new Properties();
            pro.put("mail.smtp.auth","true");
            pro.put("mail.smtp.socketFactory.port","465");
            pro.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            pro.put("mail.smtp.host","smtp.gmail.com");
            pro.put("mail.smtp.port","465");

            String mail = "caoduytinh1999@gmail.com";
            String pass = "1005990913576809";
            Session session = Session.getInstance(pro, new javax.mail.Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mail,pass);
                }
            });
            MimeMessage mimemessage = new MimeMessage(session);

            try {
                mimemessage.setFrom(new InternetAddress(mail));
                mimemessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(email)));
                mimemessage.setSubject(subject);
                mimemessage.setText(message);
                Transport.send(mimemessage);
                //Toast.makeText(ConfirmActivity.this, "Success", Toast.LENGTH_SHORT).show();
            } catch (MessagingException e) {
                e.printStackTrace();
                Log.d("AAA","CAO DUY TINH");
            }
            //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.setThreadPolicy(policy);
            Log.d("AAA","CAODUYTINH");

            return null;
        }
    }
}