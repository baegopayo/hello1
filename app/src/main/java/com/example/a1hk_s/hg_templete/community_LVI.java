package com.example.a1hk_s.hg_templete;

import android.support.v7.app.AppCompatActivity;

public class community_LVI extends AppCompatActivity {
    private int comment;
    private int heart;
    private String title;
    private String content;

    public void settitle(String str){title = str;}
    public void setcontent(String str){content = str;}
    public void setcomment(int num){comment = num;}
    public void setheart(int num){heart = num;}

    public String gettitle(){return this.title;}
    public String getcontent(){return this.content;}
    public int getcomment(){return this.comment;}
    public int getheart(){return this.heart;}
}
