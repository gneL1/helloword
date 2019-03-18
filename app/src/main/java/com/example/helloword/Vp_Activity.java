package com.example.helloword;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Vp_Activity extends Activity {


    private View view1,view2,view3;
    private ViewPager viewPager;//对应的viewPager

    private List<View> viewList;//view数组，装载上面的三个布局

    private List<String> titleList; //标题列表数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_);

        viewPager = (ViewPager) findViewById(R.id.pager);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout1,null);
        view2 = inflater.inflate(R.layout.layout2,null);
        view3 = inflater.inflate(R.layout.layout3,null);

        viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        titleList = new ArrayList<String>();//标题列表数组
        titleList.add("王先森");
        titleList.add("姜武");
        titleList.add("跑路");

        PagerTabStrip pagerTabStrip = (PagerTabStrip)findViewById(R.id.pagertab);
        pagerTabStrip.setTabIndicatorColorResource(R.color.colorPrimary);



        PagerAdapter pagerAdapter = new PagerAdapter() {

            //返回要滑动的view的个数
            @Override
            public int getCount() {
                return viewList.size();
            }


            //判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是代表的同一个视图
            // (即它俩是否是对应的，对应的表示同一个View),通常我们直接写 return view == object!
            @Override
            public boolean isViewFromObject(View view, Object o) {
                return  view == viewList.get((int)Integer.parseInt(o.toString()));
           //     return view == o;
            }


            //从当前container中删除指定位置（position）的View
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            //将当前视图添加到container中，返回当前View
            @Override
            public Object instantiateItem( ViewGroup container, int position) {
                container.addView(viewList.get(position));


                //把新增视图的位置（position)作为key传过去
                return position;
           //     return viewList.get(position);
            }


            //根据位置返回当前对应的标题
            public CharSequence getPageTitle(int position){
      //          SpannableStringBuilder ssb = new SpannableStringBuilder()
                return titleList.get(position);
            }
        };

        viewPager.setAdapter(pagerAdapter);
    }
}
