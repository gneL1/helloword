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

public class MyFragment3 extends Fragment {


    public MyFragment3() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment3, container, false);
        TextView txtcontent = (TextView) view.findViewById(R.id.txt_content3);
        txtcontent.setText("第三个Fragment");
        Log.e("test", "测试第三页");
        return view;
    }
}
