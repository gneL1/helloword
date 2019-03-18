package com.example.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RecycleActivity extends AppCompatActivity {

    //数据：list
    //主题：recyclerView
    //适配器：adapter
    List<String> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecycleDemoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        //初始化主体(recyclerView)
 //       recyclerView = findViewById(R)
    }
}
