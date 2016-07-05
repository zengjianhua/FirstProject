package com.zjh.myapplication.timeline;

/**
 * Created by zjh on 2016/6/30
 */
public class TimeEntity {
    private String time;
    private String content;

    public TimeEntity(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
