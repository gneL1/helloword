package com.example.helloword;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecycleDemoAdapter extends RecyclerView.Adapter<RecycleDemoAdapter.MyHolder> {

    Context context;
    List<String> list;

    public RecycleDemoAdapter(Context context,List<String> list) {
        this.context = context;
        this.list = list;
    }


    public void  update(List<String> list){
        this.list = list;
        notifyDataSetChanged();//如果适配器的内容改变时需要强制调用getView来刷新每个Item的内容。
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    //viewholder是用来初始化控件
    public class MyHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView =(TextView) itemView.findViewById(R.id.text);
        }
    }
}
