package com.example.helloword;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

//          ①在该组件上触发屏幕事件: boolean onTouchEvent(MotionEvent event);
////        ②在该组件上按下某个按钮时: boolean onKeyDown(int keyCode,KeyEvent event);
////        ③松开组件上的某个按钮时: boolean onKeyUp(int keyCode,KeyEvent event);
////        ④长按组件某个按钮时: boolean onKeyLongPress(int keyCode,KeyEvent event);
////        ⑤键盘快捷键事件发生: boolean onKeyShortcut(int keyCode,KeyEvent event);
////        ⑥在组件上触发轨迹球屏事件: boolean onTrackballEvent(MotionEvent event);
////        *⑦当组件的焦点发生改变在View中重写哦！ protected void onFocusChanged(boolean gainFocus, int direction, Rect previously FocusedRect)

public class Vf_Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    //UI Object:
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vf_);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
    }


    private void bindViews(){
        txt_topbar = (TextView)findViewById(R.id.txt_top_bar);
        rg_tab_bar = (RadioGroup)findViewById(R.id.rg_tab_bar);
        btn1 = (Button)findViewById(R.id.Btn_1);
        btn2 = (Button)findViewById(R.id.Btn_2);
        btn3 = (Button)findViewById(R.id.Btn_3);
        btn4 = (Button)findViewById(R.id.Btn_4);
      //  rg_tab_bar.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);
        setlisteners();

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener((ViewPager.OnPageChangeListener) this);
    }


    private void setlisteners(){
        OnClick onClick = new OnClick();
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }


    private void setShadows(Button button){
        btn1.setBackgroundColor(Color.parseColor("#BDB8B8"));
        btn2.setBackgroundColor(Color.parseColor("#BDB8B8"));
        btn3.setBackgroundColor(Color.parseColor("#BDB8B8"));
        btn4.setBackgroundColor(Color.parseColor("#BDB8B8"));
        button.setBackgroundColor(Color.parseColor("#8A8A8F"));
    }


    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2){
            Button button = null;
            switch (vpager.getCurrentItem()){
                case PAGE_ONE:
                    button = (Button) findViewById(R.id.Btn_1);
                    setShadows(button);
                    break;
                case PAGE_TWO:
                    button = (Button) findViewById(R.id.Btn_2);
                    setShadows(button);
                    break;
                case PAGE_THREE:
                    button = (Button) findViewById(R.id.Btn_3);
                    setShadows(button);
                    break;
                case PAGE_FOUR:
                    button = (Button) findViewById(R.id.Btn_4);
                    setShadows(button);
                    break;

            }
        }
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Btn_1:
                    vpager.setCurrentItem(PAGE_ONE);
                    break;
                case R.id.Btn_2:
                    vpager.setCurrentItem(PAGE_TWO);
                    break;
                case R.id.Btn_3:
                    vpager.setCurrentItem(PAGE_THREE);
                    break;
                case R.id.Btn_4:
                    vpager.setCurrentItem(PAGE_FOUR);
                    break;
            }
        }
    }





}
