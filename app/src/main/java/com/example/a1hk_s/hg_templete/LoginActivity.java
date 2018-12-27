package com.example.a1hk_s.hg_templete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    EditText input_id;
    EditText input_pw;

    ApiService apiService;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button regist = (Button) findViewById(R.id.registerBtn);
        TextView login = (TextView) findViewById(R.id.login) ;

        input_id = (EditText) findViewById(R.id.input_id);
        input_pw = (EditText) findViewById(R.id.input_pw);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new AddCookiesInterceptor(this));
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(this));

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).client(okHttpClient.build()).build();
        apiService = retrofit.create(ApiService.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_id = input_id.getText().toString();
                String val_pw = input_pw.getText().toString();

                Call<ResponseBody> comment = apiService.post_login(val_id,val_pw);
                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            String res = response.body().string();
                            Log.i("Test2", res);

                            if(res.equals("fail"))
                                Toast.makeText(LoginActivity.this, "로그인 실패!, 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                            else{
                                Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } catch (IOException e){
                            Toast.makeText(LoginActivity.this, "hi3",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                            Log.i("Test1", "fail2");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, "hi4",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

    }
}
