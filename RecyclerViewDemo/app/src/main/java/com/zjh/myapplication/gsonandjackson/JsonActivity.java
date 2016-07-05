package com.zjh.myapplication.gsonandjackson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zjh.myapplication.R;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

@ContentView(R.layout.activity_json)
public class JsonActivity extends Activity {
    private static final String URL = "http://182.150.24.135:8091/asion_gz/specialUsers.do";
    private static final String WEATHER_URL = "http://api.map.baidu.com/telematics/v3/weather?location=成都&output=json&ak=mXBIDrvTOwwmYaTtN03Lo0j2";
    private static final String TAG = JsonActivity.class.getSimpleName();
    private String data;
    @ViewInject(R.id.demo1)
    Button demo1;
    @ViewInject(R.id.demo2)
    Button demo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        demo1.setText("gson解析");
        demo2.setText("jackson解析");
        getJson();
    }

    @Event(value = {R.id.demo1, R.id.demo2})
    private void getEvent(View view) {
        switch (view.getId()) {
            case R.id.demo1:
                Toast.makeText(this, "gson解析", Toast.LENGTH_LONG).show();
//                Log.i(TAG, "data---->" + data);
                if (data != null) {
                    gson2String(data);
                }
                break;
            case R.id.demo2:
                Toast.makeText(this, "jackson解析", Toast.LENGTH_LONG).show();
                if (data!=null){
                    jackson2String(data);
                }
                break;
        }
    }

    private void getJson() {
        XutilHttp.Get(WEATHER_URL, null, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
//                Log.i(TAG,"result---->"+result);
                if (result != null) {
                    data = result;
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.i(TAG, "获取数据失败");

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void gson2String(String data) {
        Gson gson = new Gson();
//        List<UserBean> list=gson.fromJson(data,new TypeToken<List<UserBean>>(){}.getType());
//        for (int i=0;i<list.size();i++){
//            UserBean userBean=list.get(i);
//            Log.i(TAG, "userBean---->" + userBean.getCELL_COUNT());
//            Log.i(TAG, "userBean---->" + userBean.getDANGER_CELL());
//            Log.i(TAG, "userBean---->" + userBean.getDAYS());
//            Log.i(TAG, "userBean---->" + userBean.getIMSI());
//        }
        Status status = gson.fromJson(data, Status.class);
        List<Status.Results> results = status.getResults();
        for (int i = 0; i < results.size(); i++) {
            Status.Results result = results.get(i);
            Log.i(TAG, "result---->" + result.getCurrentCity());
            Log.i(TAG, "result---->" + result.getPm25());
            Log.i(TAG, "result---->" + result.getIndex());
            List<Status.Index> indexes = result.getIndex();
            for (int j = 0; j < indexes.size(); j++) {
                Log.i(TAG, "indexes---->" + indexes.get(i).getTitle());
            }
            List<Status.Weather_data> weather_datas = result.getWeather_data();
            for (int n = 0; n < weather_datas.size(); n++) {
                Log.i(TAG, "indexes---->" + weather_datas.get(i).getDayPictureUrl());
            }
        }


    }

    private void jackson2String(String data) {
//        try {
//            List<UserBean> list = JacksonUtil.json2list(data, UserBean.class);
//            Log.i(TAG, "list--->" + list);
//            for (UserBean userBean : list) {
//                Log.i(TAG, "userBean---->" + userBean.getCELL_COUNT());
//                Log.i(TAG, "userBean---->" + userBean.getDANGER_CELL());
//                Log.i(TAG, "userBean---->" + userBean.getDAYS());
//                Log.i(TAG, "userBean---->" + userBean.getIMSI());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Status status = JacksonUtil.json2pojo(data, Status.class);
        Log.i(TAG, "status------>" + status.getDate());
        List<Status.Results> results = status.getResults();
        for (int i = 0; i < results.size(); i++) {
            Status.Results result = results.get(i);
            Log.i(TAG, "result---->" + result.getCurrentCity());
            Log.i(TAG, "result---->" + result.getPm25());
            Log.i(TAG, "result---->" + result.getIndex());
            List<Status.Index> indexes = result.getIndex();
            for (int j = 0; j < indexes.size(); j++) {
                Log.i(TAG, "indexes---->" + indexes.get(i).getTitle());
            }
            List<Status.Weather_data> weather_datas = result.getWeather_data();
            for (int n = 0; n < weather_datas.size(); n++) {
                Log.i(TAG, "indexes---->" + weather_datas.get(i).getDayPictureUrl());
            }
        }
    }
}
