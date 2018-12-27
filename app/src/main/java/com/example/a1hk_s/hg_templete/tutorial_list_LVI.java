package com.example.a1hk_s.hg_templete;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

public class tutorial_list_LVI extends AppCompatActivity {
    private Drawable picDrawable ;
    private String cheese;
    private String title;

    public void setPic(Drawable icon) {
        picDrawable = icon ;
    }
    public void settitle(String str){title = str;}
    public void setcheese(String str){cheese = str;}

    public Drawable getPic() {
        return this.picDrawable ;
    }
    public String gettitle(){return this.title;}
    public String getcheese(){return this.cheese;}
}
