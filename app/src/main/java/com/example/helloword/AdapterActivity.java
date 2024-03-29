package com.example.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterActivity extends AppCompatActivity {

    private String[] names = new String[]{"B神", "基神", "曹神"};
    private String[] says = new String[]{"无形被黑，最为致命", "大神好厉害~", "我将狗~"};
    private int[] imgIds = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("name", names[i]);
            showitem.put("says", says[i]);
            listitem.add(showitem);
        }

        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.activity_sp_adapter, new String[]{"touxiang", "name", "says"}, new int[]{R.id.imagetou, R.id.name, R.id.says});
        ListView listView = (ListView) findViewById(R.id.list_test);
        listView.setAdapter(myAdapter);

//        //要显示的数据
//        String[] strs = {"11","22"};
//
//        //创建ArrayAdapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                (this,android.R.layout.simple_expandable_list_item_1,strs);
//
//        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
//        ListView list_test = (ListView) findViewById(R.id.list_test);
//        list_test.setAdapter(adapter);




    }

}
