package com.example.doan.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Parcelable, Serializable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("matkhau")
    @Expose
    private String matkhau;
    @SerializedName("sdt")
    @Expose
    private String SDT;
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("quyen")
    @Expose
    private String quyen;

    public User(){}

    public User(int id, String ten, String email, String matkhau, String SDT, String diachi) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.matkhau = matkhau;
        this.SDT = SDT;
        this.diachi = diachi;
    }

    protected User(Parcel in) {
        id = in.readInt();
        ten = in.readString();
        email = in.readString();
        matkhau = in.readString();
        SDT = in.readString();
        diachi = in.readString();
        quyen = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(ten);
        dest.writeString(email);
        dest.writeString(matkhau);
        dest.writeString(SDT);
        dest.writeString(diachi);
        dest.writeString(quyen);
    }
}
