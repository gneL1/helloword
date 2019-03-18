package com.example.helloword;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class DisplayMessageActivity extends AppCompatActivity {
    Button mbtn_user;
    Button mbtn_job;
    Button mbtn_vp;
    Button mbtn_vp2;
    Button mbtn_vf;
    Button mbtn_lst;
    Button mbtn_ht;
    Button mbtn_adapter;
    Button mbtn_sp_adapter;
    Button mbtn_Rcle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.Message);
        TextView textView = new TextView(this     );
        textView.setTextSize(40);
        textView.setText(message );

        ViewGroup layout = (ViewGroup)findViewById(R.id.activity_display_message);
        ViewGroup sv_linear = (ViewGroup)findViewById(R.id.SV_Linear);
        sv_linear.addView(textView);

        mbtn_job = (Button)findViewById(R.id.Btn_Content_Job);
        mbtn_user = (Button)findViewById(R.id.Btn_Content_User);

        //ViewPage
        mbtn_vp = (Button) findViewById(R.id.View_Page);
        mbtn_vp2 = (Button) findViewById(R.id.View_Page2);
        mbtn_vf = (Button) findViewById(R.id.View_Frag);
        mbtn_lst = (Button)findViewById(R.id.Listener);
        mbtn_ht = (Button) findViewById(R.id.Handle_Thread);
        mbtn_adapter = (Button) findViewById(R.id.Adapter);
        mbtn_adapter = (Button) findViewById(R.id.SimpleAdapter);
        mbtn_Rcle = (Button) findViewById(R.id.RecycleView);
        setlisteners();
    }


    private void setlisteners(){
        OnClick onClick = new OnClick();
        mbtn_user.setOnClickListener(onClick);
        mbtn_job.setOnClickListener(onClick);
        mbtn_vp.setOnClickListener(onClick);
        mbtn_vp2.setOnClickListener(onClick);
        mbtn_vf.setOnClickListener(onClick);
        mbtn_lst.setOnClickListener(onClick);
        mbtn_ht.setOnClickListener(onClick);
        mbtn_adapter.setOnClickListener(onClick);
        mbtn_adapter.setOnClickListener(onClick);
        mbtn_Rcle.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.View_Page:

                    Intent intent = new Intent(DisplayMessageActivity.this,Vp_Activity.class);
                    startActivity(intent);
                    break;

                case R.id.View_Page2:
                    Intent intent1 = new Intent(DisplayMessageActivity.this,Vp2_Activity.class);
                    startActivity(intent1);
                    break;

                case R.id.View_Frag:
                    Intent intent2 = new Intent(DisplayMessageActivity.this,Vf_Activity.class);
                    startActivity(intent2);
                    break;
                case R.id.Listener:
                    Intent intent3 = new Intent(DisplayMessageActivity.this,LstActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.Handle_Thread:
                    Intent intent4 = new Intent(DisplayMessageActivity.this,Ht_Activity.class);
                    startActivity(intent4);
                    break;
                case R.id.Adapter:
                    Intent intent5 = new Intent(DisplayMessageActivity.this,AdapterActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.SimpleAdapter:
                    Intent intent6 = new Intent(DisplayMessageActivity.this,SpAdapterActivity.class);
                    startActivity(intent6);
                    break;

                case R.id.RecycleView:
                    Intent intent7 = new Intent(DisplayMessageActivity.this,RecycleActivity.class);
                    startActivity(intent7);
                    break;


                case R.id.Btn_Content_User:
                    Uri uri_user = Uri.parse("content://com.example.maindata.myprovider/user");

                    ContentValues values = new ContentValues();
                    values.put("_id",4);
                    values.put("name","Jordan");

                    ContentResolver resolver = getContentResolver();

                    resolver.insert(uri_user,values);

                    Cursor cursor = resolver.query(uri_user,new String[]{"_id","name"},null,null,null);
                    while (cursor.moveToNext()){
                        System.out.println("query book:" + cursor.getInt(0) + " " + cursor.getString(1));
                    }
                    cursor.close();
                    break;
                case R.id.Btn_Content_Job:
                    Uri uri_job = Uri.parse("content://com.example.maindata.myprovider/job");

                    ContentValues values1 = new ContentValues();
                    values1.put("_id",4);
                    values1.put("job","player");

                    ContentResolver resolver1 = getContentResolver();

                    resolver1.insert(uri_job,values1);

                    Cursor cursor1 = resolver1.query(uri_job,new String[]{"_id","job"},null,null,null);
                    while (cursor1.moveToNext()){
                        System.out.println("query job: " + cursor1.getInt(0) + " " + cursor1.getString(1));
                    }

                    cursor1.close();
                    break;
                default:
                    break;
            }

        }
    }




}
