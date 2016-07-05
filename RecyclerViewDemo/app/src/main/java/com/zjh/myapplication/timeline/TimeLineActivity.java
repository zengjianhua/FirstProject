package com.zjh.myapplication.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zjh.myapplication.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjh on 2016/7/1
 */
@ContentView(R.layout.activity_timeline)
public class TimeLineActivity extends AppCompatActivity {
    @ViewInject(R.id.recyclerView)
    RecyclerView recyclerView;
    List<TimeEntity> list;
    TimeLineAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initdata();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter=new TimeLineAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }

    private void initdata() {
        list=new ArrayList<>();
        list.add(new TimeEntity("04:30:40","我只是来测试的1"));
        list.add(new TimeEntity("05:30:40","我只是来测试的2"));
        list.add(new TimeEntity("06:30:40","我只是来测试的3"));
        list.add(new TimeEntity("07:30:40","我只是来测试的4"));
        list.add(new TimeEntity("08:30:40","我只是来测试的5"));
        list.add(new TimeEntity("09:30:40","我只是来测试的6"));
        list.add(new TimeEntity("10:30:40","我只是来测试的7"));
        list.add(new TimeEntity("11:30:40","我只是来测试的8"));
        list.add(new TimeEntity("12:30:40","我只是来测试的9"));
        list.add(new TimeEntity("13:30:40","我只是来测试的10"));
        list.add(new TimeEntity("14:30:40","我只是来测试的11"));
        list.add(new TimeEntity("15:30:40","我只是来测试的12"));
        list.add(new TimeEntity("16:30:40","我只是来测试的13"));
        list.add(new TimeEntity("17:30:40","我只是来测试的14"));
        list.add(new TimeEntity("18:30:40","我只是来测试的15"));
        list.add(new TimeEntity("19:30:40","我只是来测试的16"));
        list.add(new TimeEntity("20:30:40","我只是来测试的17"));
        list.add(new TimeEntity("21:30:40","我只是来测试的18"));
        list.add(new TimeEntity("22:30:40","我只是来测试的19"));
        list.add(new TimeEntity("23:30:40","我只是来测试的20"));
    }

}
