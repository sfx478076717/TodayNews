package com.ziqi.todaynews;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/6/5.
 */
public class FragmentLittleVideo extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    /**
     * 重写onCreateView方法
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        //获取view对象
        View view=inflater.inflate(R.layout.fragment_littlevideo,null);
        //从view容器中获取组件
        return view;
    }
    public void onPause(){
        super.onPause();
    }
}
