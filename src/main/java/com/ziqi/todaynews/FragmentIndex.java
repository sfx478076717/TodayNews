package com.ziqi.todaynews;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */
public class FragmentIndex extends Fragment {

    public List<News> list = new ArrayList<>();
    private RadioButton Indexlogin;
    private ListView lv_index;
    private  DBHelper dbHelper;
    private SQLiteDatabase db;
    private boolean one = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*重写onCreateView方法*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        dbHelper = new DBHelper(this.getActivity().getApplicationContext());

        //获取view对象
        View view=inflater.inflate(R.layout.fragment_index,null);

        //从view容器中获取组件
        Indexlogin = (RadioButton) view.findViewById(R.id.IndexLogin);
        lv_index = (ListView) view.findViewById(R.id.lv_index);

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

        ImageAdapter imageAdapter=new ImageAdapter(this.getActivity(),list);
        lv_index.setAdapter(imageAdapter);

        if (MainActivity.flag){
            Indexlogin.setText("已登录");
        }

        Indexlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.flag){
                    showDialog();
                }else{
                    Intent intent = new Intent(getActivity(),LoginActivty.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

//    public void find(){
//        //任务 查询数据库中的所有新闻，显示在列表中
//        List<News> newses=newsDao.getNews();
//        NewsAdapter newsAdapter=new NewsAdapter(this.getActivity(),R.layout.index_item3,newses);
//        lv_index.setAdapter(newsAdapter);
//    }

    public void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this.getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("温馨提示");
        builder.setMessage("是否要注销登录？");
        builder.setPositiveButton("是！",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.flag = false;
                        Toast.makeText(FragmentIndex.this.getActivity(), "已经注销！", Toast.LENGTH_SHORT).show();
                        Indexlogin.setText("未登录");
                    }
                });
        builder.setNegativeButton("否！",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(FragmentIndex.this.getActivity(), "保持登录！", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }

    public void onPause(){
        super.onPause();
    }

}
