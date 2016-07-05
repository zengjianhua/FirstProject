package com.zjh.myapplication.waveview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义水波纹
 * Created by zjh on 2016/7/5
 */
public class WaveView extends View{
    private float mInitialRadius;//初始波纹半径
    private float mMaxRadius;//最大波纹半径
    private long mDuration=2000;//一个波纹从创建到消失的时间
    private int mSpeed=500;//波纹的创建速度没500ms创建一个
    private List<Circle> mCircleList=new ArrayList<>();//将创建的圆放在一个list集合中
    private boolean mIsRunning;
    private boolean mMaxRadiusSet;
    private Paint mPaint;
    private long mLastCreateTime;//创建最后一个
    private float mMaxRadiusRate=0.85f;
    private Interpolator mInterpolator=new LinearInterpolator();
    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (!mMaxRadiusSet){
           mMaxRadius=Math.min(w,h)*mMaxRadiusRate/2.0f;
        }
    }

    private Runnable mCreateCircle=new Runnable() {
        @Override
        public void run() {
            if(mIsRunning){
                newCircle();
                postDelayed(mCreateCircle,mSpeed);
            }
        }
    };
    //水波纹开始
    public void start(){
        if(!mIsRunning){
            mIsRunning=true;
            mCreateCircle.run();
        }
    }
    //水波纹停止
    public void stop(){
        mIsRunning=false;
    }

    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        if (mInterpolator == null) {
            mInterpolator = new LinearInterpolator();
        }
    }

    //设置画笔颜色
    public void setColor(int color){
       mPaint.setColor(color);
    }

    public void setMaxRadiusRate(float maxRadiusRate) {
        this.mMaxRadiusRate = maxRadiusRate;
    }
    //设置最初半径
    public void setInitialRadius(float radius ) {
        this.mInitialRadius = radius;
    }
    //设置最大半径
    public void setmMaxRadius(float maxRadius) {
        this.mMaxRadius = maxRadius;
        mMaxRadiusSet=true;
    }
    //水波纹持续事件
    public void setDuration(long duration) {
        mDuration = duration;
    }
    //创建圆的速度
    public void setSpeed(int speed) {
        this.mSpeed = speed;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Iterator<Circle> iterator=mCircleList.iterator();
        while(iterator.hasNext()){
            Circle circle=iterator.next();
            if(System.currentTimeMillis()-circle.mCreateTime<mDuration){
                mPaint.setAlpha(circle.getAlpha());
                canvas.drawCircle(getWidth()/2,getHeight()/2,circle.getCurrentRadius(),mPaint);
            }else {
                iterator.remove();
            }

        }
        if (mCircleList.size()>0){
            postInvalidateDelayed(10);
        }
    }

    //设置样式
    public void setStyle(Paint.Style style){
        mPaint.setStyle(style);
    }
    //创建一个圆
    private void newCircle(){
        long currentTime=System.currentTimeMillis();
        if(currentTime-mLastCreateTime<mSpeed){
            return;
        }
        Circle circle=new Circle();
        mCircleList.add(circle);
        invalidate();
        mLastCreateTime=currentTime;
    }
    //Circle代表一个圆
    private class Circle{
        private long mCreateTime;//创建时间

        public Circle() {
            this.mCreateTime=System.currentTimeMillis();
        }
        //获得当前的透明度
        public int getAlpha(){
            float percent=(System.currentTimeMillis()-mCreateTime)*1.0f/mDuration;
            return (int) ((1.0f-mInterpolator.getInterpolation(percent))*255);
        }
        //
        public float getCurrentRadius(){
            float percent=(System.currentTimeMillis()-mCreateTime)*1.0f/mDuration;
            return mInitialRadius+mInterpolator.getInterpolation(percent)*(mMaxRadius-mInitialRadius);
        }

    }
    //设置画笔宽度
    public void setStrokeWidth(float width){
         mPaint.setStrokeWidth(width);
    }
}
