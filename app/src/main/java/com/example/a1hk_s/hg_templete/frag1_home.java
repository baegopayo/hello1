package com.example.a1hk_s.hg_templete;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class frag1_home extends android.support.v4.app.Fragment {
    public frag1_home() {
        // Required empty public constructor
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag1_home, container,false);
        ListView listview = view.findViewById(R.id.listview1);
        ListView listview2 = view.findViewById(R.id.listview2);
        ListView listview3 = view.findViewById(R.id.listview3);

        frag1_listview1_LVA adapter = new frag1_listview1_LVA() ;
        listview.setAdapter(adapter);

        frag1_listview1_LVA adapter2 = new frag1_listview1_LVA() ;
        listview2.setAdapter(adapter2);

        frag1_listview1_LVA adapter3 = new frag1_listview1_LVA() ;
        listview3.setAdapter(adapter3);

        // 아이템 추가하는 방법 (제목, 내용, 이름, 시간)
        adapter.addItem("MISC","2018-07-03 12:30pm");
        adapter.addItem("MISC","2018-11-12 11:30am");
        adapter.addItem("CRYPTO","2018-11-13 10:00am");

        adapter2.addItem("해킹대회 질문","2018-07-03 12:30pm");
        adapter2.addItem("팀구합니다","2018-11-12 11:30am");
        adapter2.addItem("개발자입니다","2018-11-13 10:00am");

        adapter3.addItem("안녕하세요 개발자..","2018-07-03 12:30pm");
        adapter3.addItem("MISC 난이도 2 치즈2개..","2018-11-12 11:30am");
        adapter3.addItem("해킹대회 질문2","2018-11-13 10:00am");

         /*   listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position == 0) {
                        Intent intent = new Intent(getActivity(), Bulletin_Main.class);
                        startActivity(intent);
                    }
                }
            });*/


        return view;
    }
}