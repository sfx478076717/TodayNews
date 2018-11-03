package com.ziqi.todaynews;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by Administrator on 2018/5/22.
 */
public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private RadioButton index;
    private RadioButton XiguaVideo;
    private RadioButton MicroHead;
    private RadioButton LittleVideo;
    public static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        index = (RadioButton) findViewById(R.id.index);
        XiguaVideo = (RadioButton) findViewById(R.id.XiguaVideo);
        MicroHead = (RadioButton) findViewById(R.id.MicroHead);
        LittleVideo = (RadioButton) findViewById(R.id.LittleVideo);

        index.setOnClickListener(this);
        XiguaVideo.setOnClickListener(this);
        MicroHead.setOnClickListener(this);
        LittleVideo.setOnClickListener(this);



        //获得一个FragmentTransaction的实例
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //用add方法加上Fragment的对象rightFragment
        FragmentIndex fragmentIndex = new FragmentIndex();
        transaction.replace(R.id.topLinear, fragmentIndex);
        //调用commit方法使得FragmentTransaction实例的改变生效
        transaction.commit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.index :
                Fragment indexFragment = new FragmentIndex();//创建一个新的Fragment对象
                //通过FragmentManager获取Fragment事务对象
                FragmentTransaction itransaction = getFragmentManager().beginTransaction();
                //通过replace方法把right替换成新的Fragment对象
                itransaction.replace(R.id.topLinear, indexFragment);
                itransaction.addToBackStack(null);//添加回退栈
                itransaction.commit();
                break;
            case R.id.XiguaVideo :
                Fragment xiguaVideoFragment = new FragmentXiguaVideo();//创建一个新的Fragment对象
                //通过FragmentManager获取Fragment事务对象
                FragmentTransaction xtransaction = getFragmentManager().beginTransaction();
                //通过replace方法把right替换成新的Fragment对象
                xtransaction.replace(R.id.topLinear, xiguaVideoFragment);
                xtransaction.addToBackStack(null);//添加回退栈
                xtransaction.commit();
                break;
            case R.id.MicroHead :
                Fragment microHeadFragment = new FragmentMicroHead();//创建一个新的Fragment对象
                //通过FragmentManager获取Fragment事务对象
                FragmentTransaction mtransaction = getFragmentManager().beginTransaction();
                //通过replace方法把right替换成新的Fragment对象
                mtransaction.replace(R.id.topLinear, microHeadFragment);
                mtransaction.addToBackStack(null);//添加回退栈
                mtransaction.commit();
                break;
            case R.id.LittleVideo :
                Fragment littleVideoFragment = new FragmentLittleVideo();//创建一个新的Fragment对象
                //通过FragmentManager获取Fragment事务对象
                FragmentTransaction ltransaction = getFragmentManager().beginTransaction();
                //通过replace方法把right替换成新的Fragment对象
                ltransaction.replace(R.id.topLinear, littleVideoFragment);
                ltransaction.addToBackStack(null);//添加回退栈
                ltransaction.commit();
                break;
        }
    }
}