package com.example.helloword;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Vp2_Activity extends AppCompatActivity {

    private View view1,view2,view3;
    private List<View> viewsList;
    private ViewPager viewPager;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;

    private ImageView cursor;
    private int bmpw = 0;//游标宽度
    private int offset = 0;//动画图片偏移量;
    private int currIndex = 0;//当前页卡编号
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp2_);

        viewPager = (ViewPager)findViewById(R.id.View_Page_Cursor);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout1,null);
        view2 = inflater.inflate(R.layout.layout2,null);
        view3 = inflater.inflate(R.layout.layout3,null);

        tv_1 = (TextView) findViewById(R.id.Tv_1);
        tv_2 = (TextView) findViewById(R.id.Tv_2);
        tv_3 = (TextView) findViewById(R.id.Tv_3);
        setlisteners();

        viewsList = new ArrayList<View>();
        viewsList.add(view1);
        viewsList.add(view2);
        viewsList.add(view3);


        //初始化指示器位置
        initCursorPos();

        viewPager.setAdapter(new MyPagerAdapter(viewsList));
        viewPager.setOnPageChangeListener(new MyPageChangeListener());

    }


    private void setlisteners(){
        OnClick onClick = new OnClick();
        tv_1.setOnClickListener(onClick);
        tv_2.setOnClickListener(onClick);
        tv_3.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.Tv_1:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.Tv_2:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.Tv_3:
                    viewPager.setCurrentItem(2);
                    break;
                default:
                    break;
            }
        }
    }


    //初始化指示器位置
    public void initCursorPos(){
        //初始化动画
        cursor = (ImageView)findViewById(R.id.cursor);
        bmpw = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)
                .getWidth();//获取图片宽度


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;//获取分辨率宽度
        offset = (screenW/viewsList.size() - bmpw) / 2;//计算偏移量

        Matrix matrix = new Matrix();
        matrix.postTranslate(offset,0);//这里用postTranslate方法定义初始位置为（offset，0），初始位置设定之后一直是这个值，不会改变。
        cursor.setImageMatrix(matrix);//设置动画初始位置
    }



    //页面改变监听器
    public class MyPageChangeListener implements ViewPager.OnPageChangeListener{

        int one = offset * 2 + bmpw;//页卡1到页卡2的偏移量
        int two = one * 2;//页卡1到页卡3的偏移量

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            Animation animation = null;
            switch (i){
                case 0:
                    if (currIndex == 1){
                        //matrix.postTranslate(offset,0);
//float fromXDelta:这个参数表示动画开始的点离当前View X坐标上的差值；
//
//float toXDelta, 这个参数表示动画结束的点离当前View X坐标上的差值；
//
//float fromYDelta, 这个参数表示动画开始的点离当前View Y坐标上的差值；
//
//float toYDelta)这个参数表示动画开始的点离当前View Y坐标上的差值；
                        animation = new TranslateAnimation(one,0,0,0);
                    }else if (currIndex == 2){
                        animation = new TranslateAnimation(two,0,0,0);
                    }
                    break;
                case 1:
                    if (currIndex == 0){
                        animation = new TranslateAnimation(0,one,0,0);
                    }else if (currIndex == 2){
                        animation = new TranslateAnimation(two,one,0,0);
                    }
                    break;
                case 2:
                    if (currIndex == 0){
                        animation = new TranslateAnimation(0,two,0,0);
                    }else if (currIndex == 1){
                        animation = new TranslateAnimation(one,two,0,0);
                    }
                    break;
            }
            currIndex = i;
            animation.setFillAfter(true);//True:图片停在动画结束位置
            animation.setDuration(300);
            cursor.startAnimation(animation);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }


    //ViewPager适配器
    public class MyPagerAdapter extends PagerAdapter{
        public List<View> mListViews;

        public MyPagerAdapter(List<View> mListViews){
            this.mListViews = mListViews;
        }
        @Override
        public int getCount() {
            return mListViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mListViews.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(mListViews.get(position));
            return  mListViews.get(position);
        }
    }





}
