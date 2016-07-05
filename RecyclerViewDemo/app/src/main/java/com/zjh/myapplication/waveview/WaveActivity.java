package com.zjh.myapplication.waveview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zjh.myapplication.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by zjh on 2016/7/5
 */
@ContentView(R.layout.activity_wave)
public class WaveActivity extends Activity implements View.OnClickListener{
    @ViewInject(R.id.wavedemo1)
    Button wavedemo1;
    @ViewInject(R.id.wavedemo2)
    Button wavedemo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initListener();
    }

    private void initListener() {
        wavedemo1.setOnClickListener(this);
        wavedemo2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wavedemo1:
                startActivity(new Intent(this,WaveDemo1Activity.class));
                break;
            case R.id.wavedemo2:
                startActivity(new Intent(this,WaveDemo2Activity.class));
                break;
        }
    }
}
