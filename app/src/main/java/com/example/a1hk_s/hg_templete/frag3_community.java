package com.example.a1hk_s.hg_templete;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class frag3_community extends android.support.v4.app.Fragment {

    TextView notice_btn, free_btn, qna_btn;
    ListView listview;
    community_LVA adapter;

    public frag3_community() {
        // Required empty public constructor
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag3_community, container,false);

        listview = view.findViewById(R.id.community_list);
        notice_btn = view.findViewById(R.id.notice_btn);
        free_btn = view.findViewById(R.id.free_btn);
        qna_btn = view.findViewById(R.id.qna_btn);

        adapter = new community_LVA() ;

        listview.setAdapter(adapter);


        // 아이템 추가하는 방법 (제목, 내용, 좋아요 수, 댓글 수)
        adapter.addItem("안녕하세요 날샘입니다", "대규모 업데이트를 통해 여러분들이 느끼실 불편했던 사항을 아래 URL로…", 3, 4);
        adapter.addItem("안녕하세요 날샘입니다", "대규모 업데이트를 통해 여러분들이 느끼실 불편했던 사항을 아래 URL로…", 3, 4);
        adapter.addItem("안녕하세요 날샘입니다", "대규모 업데이트를 통해 여러분들이 느끼실 불편했던 사항을 아래 URL로…", 3, 4);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), community_detail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        free_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return view;
    }
}