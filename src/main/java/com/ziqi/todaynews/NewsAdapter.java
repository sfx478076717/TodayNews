package com.ziqi.todaynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private int resourceId;
    public NewsAdapter(Context context, int textViewResourceId,
                       List<News> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news= getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            //任务 补充完整
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.tv_title);
            viewHolder.author = (TextView) view.findViewById(R.id.tv_author);
            viewHolder.commentsNum = (TextView) view.findViewById(R.id.tv_commentsNum);
            viewHolder.time = (TextView) view.findViewById(R.id.tv_time);
            viewHolder.photo1 = (ImageView) view.findViewById(R.id.photo1);
            viewHolder.photo2 = (ImageView) view.findViewById(R.id.photo2);
            viewHolder.photo3 = (ImageView) view.findViewById(R.id.photo3);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(news.getTitle());
        viewHolder.author.setText(news.getAuthor());
        viewHolder.commentsNum.setText(news.getCommentsNum());
        viewHolder.time.setText(news.getTime());
        if(news.getType() == 1){
            viewHolder.photo1.setImageDrawable(news.getDrawable1());
        }else if(news.getType() == 3){
            viewHolder.photo1.setImageDrawable(news.getDrawable1());
            viewHolder.photo2.setImageDrawable(news.getDrawable2());
            viewHolder.photo3.setImageDrawable(news.getDrawable3());
        }
        return view;
    }

    class ViewHolder {
        TextView title;
        TextView author;
        TextView commentsNum;
        TextView time;
        ImageView photo1;
        ImageView photo2;
        ImageView photo3;

    }
}
