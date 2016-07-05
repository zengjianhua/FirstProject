package com.zjh.myapplication.gsonandjackson;

/**
 * Created by Administrator on 2016/6/24.
 */
public class UserBean {
    private String DAYS;
    private String CELL_COUNT;
    private String IMSI;
    private String DANGER_CELL;

    public String getDAYS() {
        return DAYS;
    }

    public void setDAYS(String DAYS) {
        this.DAYS = DAYS;
    }

    public String getDANGER_CELL() {
        return DANGER_CELL;
    }

    public void setDANGER_CELL(String DANGER_CELL) {
        this.DANGER_CELL = DANGER_CELL;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getCELL_COUNT() {
        return CELL_COUNT;
    }

    public void setCELL_COUNT(String CELL_COUNT) {
        this.CELL_COUNT = CELL_COUNT;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "DAYS='" + DAYS + '\'' +
                ", CELL_COUNT='" + CELL_COUNT + '\'' +
                ", IMSI='" + IMSI + '\'' +
                ", DANGER_CELL='" + DANGER_CELL + '\'' +
                '}';
    }
}
