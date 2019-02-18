package com.example.baijunling0218.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.baijunling0218.R;
import com.example.baijunling0218.model.JsonBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/18 10:15:31
 * @Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {
    Context context;
   ArrayList<JsonBean.ResultBean> beans= new  ArrayList<JsonBean.ResultBean>();
    public MyAdapter(Context context) {
         this.context=context;
    }

    public void setData(List<JsonBean.ResultBean> list) {
        if (list!=null){
            beans.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.res, viewGroup, false);
        MyView myViewview = new MyView(view);

        return myViewview;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView myView, int i) {
          myView.text.setText(beans.get(i).getCommodityName());
        Glide.with(context)
                .load(beans.get(i).getMasterPic())
                .into(myView.img);

    }




    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class MyView extends RecyclerView.ViewHolder {

      ImageView img;
    TextView text;
        public MyView(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
        }
    }
}
