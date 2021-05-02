package com.example.doan.retrofit;

import com.example.doan.model.Cart;
import com.example.doan.model.DetailCart;
import com.example.doan.model.SanPham;
import com.example.doan.model.User;

import org.json.JSONArray;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataClient {
    @GET("getSPMN.php")
    Call<List<SanPham>> getSanPham();

    @FormUrlEncoded
    @POST("getDSSP.php")
    Call<List<SanPham>> getDSSP(@Field("IDLOAISP") int id);

    @GET("QLSP.php")
    Call<List<SanPham>> QLSP();

    @FormUrlEncoded()
    @POST("getDSHA.php")
    Call<List<String>> getDSHA(@Field("IDSP") int id);

    @FormUrlEncoded()
    @POST("signup.php")
    Call<String> signup(@Field("Ten") String ten,@Field("Email") String email
            ,@Field("MatKhau") String matkhau,@Field("SDT") String sdt,@Field("DiaChi") String diachi);

    @FormUrlEncoded()
    @POST("login.php")
    Call<User> login(@Field("Email") String email,@Field("MatKhau") String matkhau);

    @FormUrlEncoded()
    @POST("insertCart.php")
    Call<String> insertCart(@Field("IDUSER") int id, @Field("NGAY") String date, @Field("TONGTIEN") String tongtien,@Field("TRANGTHAI") String tt,@Field("LIST") JSONArray list);

    @FormUrlEncoded()
    @POST("insertDetailCart.php")
    Call<String> insertDetailCart (@Field("LIST") JSONArray list);

    @FormUrlEncoded()
    @POST("getLISTCARTBYID.php")
    Call<List<Cart>> getCartByID (@Field("IDUSER") int id);

    @FormUrlEncoded()
    @POST("getListDetailCart.php")
    Call<List<DetailCart>> getDetailCart(@Field("IDCART") int id);

    @FormUrlEncoded()
    @POST("verifymail.php")
    Call<String> verifyMail(@Field("email") String mail,@Field("content") String content);

    @FormUrlEncoded()
    @POST("getDSDH_T.php")
    Call<List<DetailCart>> hihi(@Field("begin") String begin, @Field("end") String end);
}
