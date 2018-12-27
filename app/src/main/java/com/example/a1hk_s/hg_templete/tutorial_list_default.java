package com.example.a1hk_s.hg_templete;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class tutorial_list_default extends AppCompatActivity{

    TextView back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tutorial_list);

        ListView listview = (ListView) findViewById(R.id.tutorial_list);
        back_btn = (TextView) findViewById(R.id.back);

        tutorial_list_LVA adapter = new tutorial_list_LVA();
        listview.setAdapter(adapter);

        // 아이템 추가하는 방법 (제목, 내용, 이름, 시간)
        adapter.addItem("HELLO","CHEESE : 5", ContextCompat.getDrawable(this,R.drawable.tutorial_btn));
        adapter.addItem("","",ContextCompat.getDrawable(this,R.drawable.tutorial_btn_dark));
        adapter.addItem("","", ContextCompat.getDrawable(this,R.drawable.tutorial_btn_dark));
        adapter.addItem("","", ContextCompat.getDrawable(this,R.drawable.tutorial_btn_dark));

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
