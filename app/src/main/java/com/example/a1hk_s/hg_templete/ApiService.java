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
    public static final String API_URL = "http://www.nalsaem.com/hello_apple/";

    //로그인
    @FormUrlEncoded
    @POST("user/login.php")
    Call<ResponseBody> post_login(@Field("id") String id, @Field("pw") String pw);

    //회원가입
    @FormUrlEncoded
    @POST("user/regist.php")
    Call<ResponseBody> post_regist(@Field("nick") String nick, @Field("id") String id, @Field("pw") String pw, @Field("email") String email);

    //중복 체크
    @FormUrlEncoded
    @POST("user/check_overlap.php")
    Call<ResponseBody> check_overlap(@Field("type") String type, @Field("input") String nick);

    //패스워드 확인
    @FormUrlEncoded
    @POST("user/check_overlap.php")
    Call<ResponseBody> check_overlap_pw(@Field("type") String type, @Field("pw") String pw, @Field("pw_check") String pw_check);

    //닉네임 가져오기
    @POST("user/nick.php")
    Call<ResponseBody> get_nick();

}

