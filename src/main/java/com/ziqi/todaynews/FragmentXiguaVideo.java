package com.ziqi.todaynews;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/6/5.
 */
public class FragmentXiguaVideo extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private RadioButton Xigualogin;

    /**
     * 重写onCreateView方法
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        //获取view对象
        View view=inflater.inflate(R.layout.fragment_xiguavideo,null);

        //从view容器中获取组件
        Xigualogin = (RadioButton) view.findViewById(R.id.XiguaLogin);

        if (MainActivity.flag){
            Xigualogin.setText("已登录");
        }

        Xigualogin.setOnClickListener(new View.OnClickListener() {
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
                        Toast.makeText(FragmentXiguaVideo.this.getActivity(), "已经注销！", Toast.LENGTH_SHORT).show();
                        Xigualogin.setText("未登录");
                    }
                });
        builder.setNegativeButton("否！",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(FragmentXiguaVideo.this.getActivity(), "保持登录！", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
    public void onPause(){
        super.onPause();
    }
}
