package com.example.a1hk_s.hg_templete;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class tutorial_list extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tutorial_list);

        ListView listview = (ListView) findViewById(R.id.tutorial_list);

        tutorial_list_LVA adapter = new tutorial_list_LVA();
        listview.setAdapter(adapter);

        // 아이템 추가하는 방법 (제목, 내용, 이름, 시간)
        adapter.addItem("HELLO","CHEESE : 5");
        adapter.addItem("HELLO","CHEESE : 5");
        adapter.addItem("HELLO","CHEESE : 5");
        adapter.addItem("HELLO","CHEESE : 5");


    }
}
