package com.example.a1hk_s.hg_templete;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class tutorial_list_LVA extends BaseAdapter {

    private ArrayList<tutorial_list_LVI> listViewItemList = new ArrayList<tutorial_list_LVI>() ;

    public tutorial_list_LVA() {
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
            convertView = inflater.inflate(R.layout.tutorial_list_lvi, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        LinearLayout iconImageView = (LinearLayout) convertView.findViewById(R.id.img_bg) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.title) ;
        TextView timeTextView = (TextView) convertView.findViewById(R.id.cheese) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        tutorial_list_LVI listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(listViewItem.gettitle()+"");
        timeTextView.setText(listViewItem.getcheese()+"");
        iconImageView.setBackground(listViewItem.getPic());

        return convertView;

    }

    public void addItem(String title, String cheese, Drawable pic) {

        tutorial_list_LVI item = new tutorial_list_LVI();

        item.settitle(title);
        item.setcheese(cheese);
        item.setPic(pic);

        listViewItemList.add(item);
    }
}
