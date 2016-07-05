package com.zjh.myapplication.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zjh.myapplication.R;

/**
 * Created by zjh on 2016/6/30
 */
public class TimeLineViewHolder extends RecyclerView.ViewHolder {
    TextView time;
    TextView title;
    public TimeLineViewHolder(View itemView) {
        super(itemView);
        time= (TextView) itemView.findViewById(R.id.show_time);
        title= (TextView) itemView.findViewById(R.id.title);
    }
}
