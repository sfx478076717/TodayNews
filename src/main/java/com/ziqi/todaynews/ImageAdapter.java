package com.ziqi.todaynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private List<News> list = new ArrayList<>();

    public ImageAdapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        News news = list.get(position);
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        ViewHolder3 viewHolder3 = null;
        int type = getItemViewType(position);
        if (view == null){
            switch (type){
                case 0 :
                    viewHolder1 = new ViewHolder1();
                    view = LayoutInflater.from(context).inflate(R.layout.index_item1,null);

                    viewHolder1.title = (TextView) view.findViewById(R.id.tv_title);
                    viewHolder1.author = (TextView) view.findViewById(R.id.tv_author);
                    viewHolder1.commentsNum = (TextView) view.findViewById(R.id.tv_commentsNum);
                    viewHolder1.time = (TextView) view.findViewById(R.id.tv_time);

                    viewHolder1.title.setText(news.getTitle());
                    viewHolder1.author.setText(news.getAuthor());
                    viewHolder1.commentsNum.setText(news.getCommentsNum());
                    viewHolder1.time.setText(news.getTime());
                    break;
                case 1 :
                    viewHolder2 = new ViewHolder2();
                    view = LayoutInflater.from(context).inflate(R.layout.index_item2,null);

                    viewHolder2.title = (TextView) view.findViewById(R.id.tv_title);
                    viewHolder2.author = (TextView) view.findViewById(R.id.tv_author);
                    viewHolder2.commentsNum = (TextView) view.findViewById(R.id.tv_commentsNum);
                    viewHolder2.time = (TextView) view.findViewById(R.id.tv_time);
                    viewHolder2.photo1 = (ImageView) view.findViewById(R.id.photo1);

                    viewHolder2.title.setText(news.getTitle());
                    viewHolder2.author.setText(news.getAuthor());
                    viewHolder2.commentsNum.setText(news.getCommentsNum());
                    viewHolder2.time.setText(news.getTime());
                    viewHolder2.photo1.setImageDrawable(news.getDrawable1());
                    break;
                case 3 :
                    viewHolder3 = new ViewHolder3();
                    view = LayoutInflater.from(context).inflate(R.layout.index_item3,null);

                    viewHolder3.title = (TextView) view.findViewById(R.id.tv_title);
                    viewHolder3.author = (TextView) view.findViewById(R.id.tv_author);
                    viewHolder3.commentsNum = (TextView) view.findViewById(R.id.tv_commentsNum);
                    viewHolder3.time = (TextView) view.findViewById(R.id.tv_time);
                    viewHolder3.photo1 = (ImageView) view.findViewById(R.id.photo1);
                    viewHolder3.photo2 = (ImageView) view.findViewById(R.id.photo2);
                    viewHolder3.photo3 = (ImageView) view.findViewById(R.id.photo3);

                    viewHolder3.title.setText(news.getTitle());
                    viewHolder3.author.setText(news.getAuthor());
                    viewHolder3.commentsNum.setText(news.getCommentsNum());
                    viewHolder3.time.setText(news.getTime());
                    viewHolder3.photo1.setImageDrawable(news.getDrawable1());
                    viewHolder3.photo2.setImageDrawable(news.getDrawable2());
                    viewHolder3.photo3.setImageDrawable(news.getDrawable3());
                    break;
            }
        }
        return view;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        News news = list.get(position);
        int type = news.getType();
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    class ViewHolder1 {
        TextView title;
        TextView author;
        TextView commentsNum;
        TextView time;
    }
    class ViewHolder2 {
        TextView title;
        TextView author;
        TextView commentsNum;
        TextView time;
        ImageView photo1;
    }
    class ViewHolder3 {
        TextView title;
        TextView author;
        TextView commentsNum;
        TextView time;
        ImageView photo1;
        ImageView photo2;
        ImageView photo3;
    }
}
