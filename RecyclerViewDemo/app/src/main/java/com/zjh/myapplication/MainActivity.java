package com.zjh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zjh.myapplication.gsonandjackson.JsonActivity;
import com.zjh.myapplication.timeline.TimeLineActivity;
import com.zjh.myapplication.waveview.WaveActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by zjh on 2016/7/1
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @ViewInject(R.id.json)
    TextView json;
    @ViewInject(R.id.timeline)
    TextView timeline;
    @ViewInject(R.id.wave)
    TextView wave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initListener();
    }

    private void initListener() {
        json.setOnClickListener(this);
        timeline.setOnClickListener(this);
        wave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.json:
                startActivity(new Intent(this, JsonActivity.class));
                break;
            case R.id.timeline:
                startActivity(new Intent(this, TimeLineActivity.class));
                break;
            case R.id.wave:
                startActivity(new Intent(this, WaveActivity.class));
        }
    }
}
