package com.example.helloword;

import android.os.Handler;

import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ht_Activity extends AppCompatActivity {

    Handler mainHandler;
    Handler workHandler;
    HandlerThread mHandlerThread;
    TextView text;
    Button button1,button2,button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht_);

        //显示文本
        text = (TextView)findViewById(R.id.Tv_1);

        //创建与主线程关联的Handler
        mainHandler = new Handler();

        //步骤一：创建HandlerThread实例对象
        //传入参数=线程名字，作用=标记该线程mainHandler
        mHandlerThread = new  HandlerThread("handlerThread");

        //步骤二：启动线程
        mHandlerThread.start();


        //步骤三：创建工作线程Handler&复写handleMessage()
        //作用：关联HandlerThread的Looper对象、实现消息处理操作&与其他线程进行通信
        //消息处理操作（HandleMessage())的执行线程 = mHandlerThread所创建的工作线程中执行

        workHandler = new Handler(mHandlerThread.getLooper()){

            @Override
            //消息处理的操作
            public void handleMessage(Message msg) {
                //设置了两种消息处理操作，通过msg来进行识别
                switch (msg.what){
                    //消息1
                    case 1:
                        try{
                            //延时操作
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        //通过主线程Handler.post方法进行在主线程的UI更新操作
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                text.setText("消息1的post更新");
                            }
                        });
                        break;

                        //消息2
                    case 2:
                        try{
                            Thread.sleep(3000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                text.setText("消息2的post更新");
                            }
                        });
                        break;
                    default:
                        break;
                }
           //     super.handleMessage(msg);
            }
        };

        //步骤四：使用工作线程Handler向工作线程的消息队列发送消息
        //在工作线程中，当消息循环时取出对应消息&在工作线程执行相关操作


        button1 = (Button)findViewById(R.id.Btn_1);
        button2 = (Button) findViewById(R.id.Btn_2);
        button3 = (Button)findViewById(R.id.Btn_3);
        serlisteners();

    }


    private void serlisteners(){
        OnClick onClick = new OnClick();
        button1.setOnClickListener(onClick);
        button2.setOnClickListener(onClick);
        button3.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //点击Button1
                case R.id.Btn_1:
                    //通过sendMessage()发送
                    //a.定义要发送的消息
                    Message msg1 = Message.obtain();
                    msg1.what = 1;//消息的标识
                    msg1.obj = "A";//消息的存放
                    //b.通过Handler发送消息到其绑定的消息队列
                    workHandler.sendMessage(msg1);
                    break;

                case R.id.Btn_2:
                    Message msg2 = Message.obtain();
                    msg2.what = 2;
                    msg2.obj = "B";

                    workHandler.sendMessage(msg2);
                    break;

                case R.id.Btn_3:
                    //退出消息循环
                    mHandlerThread.quit();
                    break;
            }
        }
    }


}
