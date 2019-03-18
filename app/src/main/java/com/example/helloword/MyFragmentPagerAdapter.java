package com.example.helloword;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private  final int PAGER_COUNT =4;
    private MyFragment1 myFragment1 = null;
    private MyFragment2 myFragment2 = null;
    private MyFragment3 myFragment3 = null;
    private MyFragment4 myFragment4 = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
        myFragment4 = new MyFragment4();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case Vf_Activity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case Vf_Activity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case Vf_Activity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case Vf_Activity.PAGE_FOUR:
                fragment = myFragment4;
                break;
            default:
                break;
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        System.out.println("position Destory " + position);
        super.destroyItem(container, position, object);

    }
}
