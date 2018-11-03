package com.ziqi.todaynews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */
public class NewsDao {
    private DBHelper dbHelper;
    public NewsDao(Context context){
        dbHelper=new DBHelper(context);
    }
    public void add(News news){
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",news.getTitle());
        contentValues.put("author",news.getAuthor());
        contentValues.put("commentsNum",news.getCommentsNum());
        contentValues.put("time",news.getTime());
        contentValues.put("drawable1",news.getDrawable1().toString());
        contentValues.put("drawable2",news.getDrawable1().toString());
        contentValues.put("drawable3",news.getDrawable3().toString());
        sqLiteDatabase.insert("tb_news",null,contentValues);
    }
    public List<News> getNews(){
        //任务 完成查询所有数据的方法
        List<News> newses=new ArrayList<News>();
        SQLiteDatabase sqLiteDatabase=dbHelper.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.query("tb_news",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            int id= cursor.getInt(cursor.getColumnIndex("_id"));
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String author=cursor.getString(cursor.getColumnIndex("author"));
            String commentsNum=cursor.getString(cursor.getColumnIndex("commentsNum"));
            String time=cursor.getString(cursor.getColumnIndex("time"));
//            News news=new News(title,author,commentsNum,time);
//            news.setId(id);
//            newses.add(news);
        }
        return newses;
    }
}