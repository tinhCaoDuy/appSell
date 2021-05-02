package com.example.doan.retrofit;

public class APIUltils {
    public static final String base_url = "http://192.168.1.44/doanwebservice/";
    public static DataClient getData(){
        return RetrofitClient.getClient(base_url).create(DataClient.class);
    }
}
