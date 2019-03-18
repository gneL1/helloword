package com.example.helloword;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment1 extends Fragment {

    public MyFragment1(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment1,container,false);
        TextView txtcontent = (TextView) view.findViewById(R.id.txt_content1);
        txtcontent.setText("第一个Fragment");
        Log.e("test","测试第一页");
        return view;
    }
}
