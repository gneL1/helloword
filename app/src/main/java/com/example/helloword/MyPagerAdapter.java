package com.example.helloword;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {

    private ArrayList<View> viewLists;

    public MyPagerAdapter(){

    }

    public MyPagerAdapter(ArrayList<View> viewLists){
        super();
        this.viewLists = viewLists;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }
}
