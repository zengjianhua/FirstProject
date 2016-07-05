package com.zjh.myapplication.timeline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjh.myapplication.R;

import java.util.List;

/**
 * Created by zjh on 2016/6/30
 */
public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {
    private List<TimeEntity> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public TimeLineAdapter(Context context,List<TimeEntity> list ) {
        this.list = list;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.timeline_recycler_item,parent,false);
        TimeLineViewHolder holder=new TimeLineViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        holder.time.setText(list.get(position).getTime());
        holder.title.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }else {
            return 0;
        }
    }
}
