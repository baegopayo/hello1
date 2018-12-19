package com.example.a1hk_s.hg_templete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class frag1_listview1_LVA extends BaseAdapter{


    private ArrayList<frag1_listview1_lVI> listViewItemList = new ArrayList<frag1_listview1_lVI>() ;

    public frag1_listview1_LVA() {
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
            convertView = inflater.inflate(R.layout.frag1_listview1_lvi, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView titleTextView = (TextView) convertView.findViewById(R.id.title) ;
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        frag1_listview1_lVI listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewItem.getTitle()+"");
        timeTextView.setText(listViewItem.getTime()+"");

        return convertView;

    }

    public void addItem(String title, String time) {

        frag1_listview1_lVI item = new frag1_listview1_lVI();

        item.setTitle(title);
        item.setTime(time);

        listViewItemList.add(item);
    }
}
