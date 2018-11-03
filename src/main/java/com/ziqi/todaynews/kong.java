package com.ziqi.todaynews;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */
public class kong extends AppCompatActivity{
    public List<News> list = new ArrayList<>();
    private ListView lv_index;
    private  DBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        dbHelper = new DBHelper(getApplicationContext());
        setContentView(R.layout.activity_index);
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_news",null);
        String path = Environment.getExternalStorageDirectory().getPath();

        while(cursor.moveToNext()){
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String author=cursor.getString(cursor.getColumnIndex("author"));
            String commentsNum=cursor.getString(cursor.getColumnIndex("commentsNum"));
            String time=cursor.getString(cursor.getColumnIndex("time"));
            int type = cursor.getInt(cursor.getColumnIndex("type"));

            Bitmap bitmap1 = BitmapFactory.decodeFile(path + cursor.getString(cursor.getColumnIndex("drawable1")));
            Bitmap bitmap2 = BitmapFactory.decodeFile(path + cursor.getString(cursor.getColumnIndex("drawable2")));
            Bitmap bitmap3 = BitmapFactory.decodeFile(path + cursor.getString(cursor.getColumnIndex("drawable3")));
            Drawable drawable1 = new BitmapDrawable(bitmap1);
            Drawable drawable2 = new BitmapDrawable(bitmap2);
            Drawable drawable3 = new BitmapDrawable(bitmap3);

            News news = new News(title,author,commentsNum,time,type,drawable1,drawable2,drawable3);
            list.add(news);
        }

        lv_index = (ListView) findViewById(R.id.lv_index);
        NewsAdapter newsAdapter=new NewsAdapter(this,R.layout.index_item3,list);
        lv_index.setAdapter(newsAdapter);
    }
}
