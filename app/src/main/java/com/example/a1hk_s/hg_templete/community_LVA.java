package com.example.a1hk_s.hg_templete;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class community_LVA extends BaseAdapter {

    private ArrayList<community_LVI> listViewItemList = new ArrayList<community_LVI>() ;

    public community_LVA() {
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        // "main_frag_1_lvi" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.frag3_community_lvi, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView titleTextView = (TextView) convertView.findViewById(R.id.title) ;
        TextView commentTextView = (TextView) convertView.findViewById(R.id.comment) ;
        TextView heartTextView = (TextView) convertView.findViewById(R.id.heart) ;
        TextView contetTextView = (TextView) convertView.findViewById(R.id.content) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        community_LVI listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewItem.gettitle()+"");
        commentTextView.setText(listViewItem.getcomment()+"");
        heartTextView.setText(listViewItem.getheart()+"");
        contetTextView.setText(listViewItem.getcontent()+"");

        return convertView;

    }

    public void addItem(String title, String content,int heart,int comment) {

       community_LVI item = new community_LVI();

        item.settitle(title);
        item.setcontent(content);
        item.setheart(heart);
        item.setcomment(comment);

        listViewItemList.add(item);
    }
}
