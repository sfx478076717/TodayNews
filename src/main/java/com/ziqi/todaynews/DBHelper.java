package com.ziqi.todaynews;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/5/22.
 */
public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sdb;
    private static final String DB_NAME = "db_news.db";//数据库名
    private static final String TBL_USER = "user";//用户表的表名
    private static final String TBL_NEWS = "tb_news";//新闻表的表名
    private static int version = 1;//版本号

    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        this.sdb = sdb;
        try{
            String CREATE_USER = "create table user (_id integer primary key autoincrement," +
                    "username text,password text)";
            sdb.execSQL(CREATE_USER);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            String CREATE_NEWS = "create table tb_news (_id integer primary key autoincrement," +
                    "title text,author text,commentsNum text,time text,type integer," +
                    "drawable1 text,drawable2 text,drawable3 text)";
            sdb.execSQL(CREATE_NEWS);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

/*    public void add(News news){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",news.getTitle());
        contentValues.put("author",news.getAuthor());
        contentValues.put("commentsNum",news.getCommentsNum());
        contentValues.put("time",news.getTime());
        contentValues.put("type",news.getType());
        contentValues.put("drawable1",news.getDrawable1().toString());
        contentValues.put("drawable2",news.getDrawable1().toString());
        contentValues.put("drawable3",news.getDrawable3().toString());
        sqLiteDatabase.insert("tb_news",null,contentValues);
    }*/

    public boolean register(String username, String password) {
        SQLiteDatabase sdb = getWritableDatabase();
        String sql = "insert into user(username,password) values (?,?)";
        Object obj[] = {username, password};
        sdb.execSQL(sql,obj);
        return true;
    }

    public boolean login(String username,String password){
        SQLiteDatabase sdb = getReadableDatabase();
        String sql = "select * from user where username=? and password=?";
        String user [] = {username,password};

        Cursor cursor = sdb.rawQuery(sql,user);
        if(cursor.moveToFirst() == true ){
            cursor.close();
            return true;
        }else
            return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
