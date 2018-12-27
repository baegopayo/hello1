package com.example.a1hk_s.hg_templete;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {
    //API Gateway Stage URL
    //호출할 기본적인 위치랄까?
    public static final String API_URL = "http://192.168.0.10/nalsaem/server/";

    //로그인
    @FormUrlEncoded
    @POST("user/login.php")
    Call<ResponseBody> post_login(@Field("id") String id, @Field("password") String pw);

    //닉네임 중복 체크
    @FormUrlEncoded
    @POST("user/check_overlap.php")
    Call<ResponseBody> check_overlap_id(@Field("type") String type, @Field("nick") String nick);

}

