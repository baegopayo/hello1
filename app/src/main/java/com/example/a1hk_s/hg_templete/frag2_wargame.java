package com.example.a1hk_s.hg_templete;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class frag2_wargame extends android.support.v4.app.Fragment {
    public frag2_wargame() {
        // Required empty public constructor
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag2_tutorial, container, false);

        //ListView listview = view.findViewById(R.id.listview1);
        ImageView web_btn = view.findViewById(R.id.web_btn);
        ImageView icebreak_btn = view.findViewById(R.id.icebreak_btn);
        ImageView misc_btn = view.findViewById(R.id.misc_btn);
        ImageView forensic_btn = view.findViewById(R.id.fornsic_btn);
        ImageView crypto_btn = view.findViewById(R.id.crypto_btn);

        icebreak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),tutorial_list.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("name","ICEBREAKING");
                startActivity(intent);
            }
        });
        web_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),tutorial_list.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("name","WEB");
                startActivity(intent);
            }
        });
        misc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),tutorial_list.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("name","MISC");
                startActivity(intent);
            }
        });
        crypto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),tutorial_list.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("name","CRYPTO");
                startActivity(intent);
            }
        });
        forensic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),tutorial_list.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("name","FORENSIC");
                startActivity(intent);
            }
        });

        return view;
    }
}
