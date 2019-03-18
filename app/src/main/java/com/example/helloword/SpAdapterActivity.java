package com.example.helloword;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpAdapterActivity extends AppCompatActivity {

//    private String[] names = new String[]{"张三","李四"};
//    private String[] says = new String[]{"。。。。。。。。。。。",".................."};
//    private int[] imgIds = new int[]{
//            R.mipmap.ic_launcher,R.mipmap.ic_launcher
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_adapter);

//
//        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < names.length; i++) {
//            Map<String, Object> showitem = new HashMap<String, Object>();
//            showitem.put("头像", imgIds[i]);
//            showitem.put("name", names[i]);
//            showitem.put("says", says[i]);
//            listitem.add(showitem);
//        }
//
//        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.activity_sp_adapter,
//                new String[]{"touxiang,name,says"
//                }, new int[]{R.id.imagetou, R.id.name, R.id.activity_display_message});
//        View view = this.getLayoutInflater().inflate(R.id.list_test,null);
//   //     ListView listView = (ListView) findViewById(R.id.list_test);
//        ListView listView1 = view.findViewById(R.id.list)
//
//        listView.setAdapter(myAdapter);
    }
}
