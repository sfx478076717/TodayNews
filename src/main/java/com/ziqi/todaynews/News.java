package com.ziqi.todaynews;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018/6/7.
 */
public class News {
    private int id;
    private String title;//标题
    private String author;//作者
    private String commentsNum;//评论数
    private String time;//发布时间
    private int type;//类型，判断有几个图片
    private Drawable drawable1;//图片1的地址url
    private Drawable drawable2;//图片2的地址url
    private Drawable drawable3;//图片3的地址url

    public News(String title, String author, String commentsNum, String time, int type, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        this.title = title;
        this.author = author;
        this.commentsNum = commentsNum;
        this.time = time;
        this.type = type;
        this.drawable1 = drawable1;
        this.drawable2 = drawable2;
        this.drawable3 = drawable3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(String commentsNum) {
        this.commentsNum = commentsNum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Drawable getDrawable1() {
        return drawable1;
    }

    public void setDrawable1(Drawable drawable1) {
        this.drawable1 = drawable1;
    }

    public Drawable getDrawable2() {
        return drawable2;
    }

    public void setDrawable2(Drawable drawable2) {
        this.drawable2 = drawable2;
    }

    public Drawable getDrawable3() {
        return drawable3;
    }

    public void setDrawable3(Drawable drawable3) {
        this.drawable3 = drawable3;
    }
}
