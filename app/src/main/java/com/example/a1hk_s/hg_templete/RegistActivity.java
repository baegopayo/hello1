package com.example.a1hk_s.hg_templete;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegistActivity extends AppCompatActivity {

    Button register_btn;
    ImageButton nick_overlap_btn, id_overlap_btn, email_overlap_btn, pw_overlap_btn;

    ApiService apiService;
    Retrofit retrofit;
    TextView input_nick;
    TextView input_id, input_pw, input_pw_check, input_email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register);

        register_btn = (Button) findViewById(R.id.registerBtn);

        input_nick = findViewById(R.id.input_nick);
        input_id = findViewById(R.id.input_id);
        input_email = findViewById(R.id.input_email);
        input_pw = findViewById(R.id.input_pw);
        input_pw_check = findViewById(R.id.input_pw_check);

        nick_overlap_btn = (ImageButton) findViewById(R.id.nick_overlap_btn);
        id_overlap_btn = (ImageButton) findViewById(R.id.id_overlap_btn);
        pw_overlap_btn = (ImageButton) findViewById(R.id.pw_overlap_btn);
        email_overlap_btn = (ImageButton) findViewById(R.id.email_overlap_btn);

        //retrofit 사용 준비
        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_nick = input_nick.getText().toString();
                String val_id = input_id.getText().toString();
                String val_email = input_email.getText().toString();
                String val_pw = input_pw.getText().toString();

                Call<ResponseBody> comment = apiService.post_regist(val_nick, val_id, val_pw, val_email);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            String res = response.body().string();
                            if(res.equals("ok")){
                                Toast.makeText(RegistActivity.this, "회원가입 성공!",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegistActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(RegistActivity.this, res,Toast.LENGTH_SHORT).show();
                            }
                        } catch (IOException e){
                            Toast.makeText(RegistActivity.this, "Exception erro",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(RegistActivity.this, "network fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        nick_overlap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_nick = input_nick.getText().toString();
                Call<ResponseBody> comment = apiService.check_overlap("nick",val_nick);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            Toast.makeText(RegistActivity.this, response.body().string(),Toast.LENGTH_SHORT).show();
                        } catch (IOException e){
                            Toast.makeText(RegistActivity.this, "Exception erro",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(RegistActivity.this, "network fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        id_overlap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_id = input_id.getText().toString();
                Call<ResponseBody> comment = apiService.check_overlap("id",val_id);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            Toast.makeText(RegistActivity.this, response.body().string(),Toast.LENGTH_SHORT).show();
                        } catch (IOException e){
                            Toast.makeText(RegistActivity.this, "Exception error",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(RegistActivity.this, "network fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        email_overlap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_email = input_email.getText().toString();
                Call<ResponseBody> comment = apiService.check_overlap("email",val_email);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            Toast.makeText(RegistActivity.this, response.body().string(),Toast.LENGTH_SHORT).show();
                        } catch (IOException e){
                            Toast.makeText(RegistActivity.this, "Exception error",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(RegistActivity.this, "network fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        pw_overlap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_pw = input_pw.getText().toString();
                String val_pw_check = input_pw_check.getText().toString();

                Call<ResponseBody> comment = apiService.check_overlap_pw("pw_check",val_pw, val_pw_check);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            Toast.makeText(RegistActivity.this, response.body().string(),Toast.LENGTH_SHORT).show();
                        } catch (IOException e){
                            Toast.makeText(RegistActivity.this, "Exception error",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(RegistActivity.this, "network fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
