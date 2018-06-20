package com.example.android.new_nds_study.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.new_nds_study.R;
import com.example.android.new_nds_study.m_v_p.bean.MyCoursesBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

public class MyClassAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MyCoursesBean.DataBean.ListBean> list=new ArrayList<MyCoursesBean.DataBean.ListBean>();
    public MyClassAdapter(Context context, List<MyCoursesBean.DataBean.ListBean> list) {
        this.context=context;
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.myclassfragment_recycler,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder mHolder=(MyViewHolder)holder;
        String cover = list.get(position).getCover();
        Uri uri = Uri.parse(cover);
        mHolder.myclassfragment_iv.setImageURI(uri);
        mHolder.myclassfragment_course.setText(list.get(position).getTitle());
        mHolder.myclassfragment_college.setText(list.get(position).getStart_time());
//        String cover = list.get(position).getList().get(position).getCover();
//        Uri uri = Uri.parse(cover);
//        mHolder.myclassfragment_iv.setImageURI(uri);
//        mHolder.myclassfragment_college.setText(list.get(position).getList().get(position).getStart_time());
//        mHolder.myclassfragment_course.setText(list.get(position).getList().get(position).getTitle());
        mHolder.itemView.setTag(position);
        //设置RecyclerView 点击条目事件
        mHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,(int)v.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("MyClassAdapter", "getItemCount: "+list.size() );
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView myclassfragment_iv;
        private final TextView myclassfragment_college;
        private final TextView myclassfragment_course;

        public MyViewHolder(View view) {
            super(view);
            myclassfragment_iv = view.findViewById(R.id.myclassfragment_iv);
            myclassfragment_college = view.findViewById(R.id.myclassfragment_college);
            myclassfragment_course= view.findViewById(R.id.myclassfragment_course);
        }
    }

    OnItemClickListener mOnItemClickListener;
    public  void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
    }
    //自定义接口
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
