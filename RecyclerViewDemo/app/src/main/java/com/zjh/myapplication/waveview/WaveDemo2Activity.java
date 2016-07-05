package com.zjh.myapplication.waveview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.zjh.myapplication.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by zjh on 2016/7/5
 */
@ContentView(R.layout.activity_wave_demo2)
public class WaveDemo2Activity extends Activity{
    private WaveView mWaveView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        mWaveView= (WaveView) findViewById(R.id.wave2);
        mWaveView.setColor(Color.parseColor("#ff0000"));
        mWaveView.setDuration(6000);
        mWaveView.setStyle(Paint.Style.FILL);
        mWaveView.setSpeed(800);
        mWaveView.setInitialRadius(20);
        mWaveView.setmMaxRadius(300);
        mWaveView.start();
    }
}
