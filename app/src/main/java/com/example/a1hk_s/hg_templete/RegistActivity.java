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
    ImageButton nick_overlap_btn;

    ApiService apiService;
    Retrofit retrofit;
    TextView input_nick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register);

        register_btn = (Button) findViewById(R.id.registerBtn);

        input_nick = findViewById(R.id.input_nick);
        nick_overlap_btn = (ImageButton) findViewById(R.id.nick_overlap_btn);

        //retrofit 사용 준비
        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        nick_overlap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_nick = input_nick.getText().toString();
                Call<ResponseBody> comment = apiService.check_overlap_id("nick",val_nick);

                comment.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            Toast.makeText(RegistActivity.this, response.body().string(),Toast.LENGTH_SHORT).show();
                        } catch (IOException e){
                            Toast.makeText(RegistActivity.this, "hi3",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                            Log.i("Test1", "fail2");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        Toast.makeText(RegistActivity.this, "hi4",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
