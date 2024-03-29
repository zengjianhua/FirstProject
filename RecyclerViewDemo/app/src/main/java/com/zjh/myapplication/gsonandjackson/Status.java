package com.zjh.myapplication.gsonandjackson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/27.
 */
public class Status implements Serializable {
    private String error;
    private String status;
    private String date;
    private List<Results> results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results implements Serializable {
        private String currentCity;
        private String pm25;
        private List<Index> index;
        private List<Weather_data> weather_data;

        public String getCurrentCity() {
            return currentCity;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public List<Index> getIndex() {
            return index;
        }

        public void setIndex(List<Index> index) {
            this.index = index;
        }

        public List<Weather_data> getWeather_data() {
            return weather_data;
        }

        public void setWeather_data(List<Weather_data> weather_data) {
            this.weather_data = weather_data;
        }
    }

    public static class Index implements Serializable {
        private String title;
        private String zs;
        private String tipt;
        private String des;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getZs() {
            return zs;
        }

        public void setZs(String zs) {
            this.zs = zs;
        }

        public String getTipt() {
            return tipt;
        }

        public void setTipt(String tipt) {
            this.tipt = tipt;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }

    public static class Weather_data implements Serializable {
        private String date;
        private String dayPictureUrl;
        private String nightPictureUrl;
        private String weather;
        private String wind;
        private String temperature;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getNightPictureUrl() {
            return nightPictureUrl;
        }

        public void setNightPictureUrl(String nightPictureUrl) {
            this.nightPictureUrl = nightPictureUrl;
        }

        public String getDayPictureUrl() {
            return dayPictureUrl;
        }

        public void setDayPictureUrl(String dayPictureUrl) {
            this.dayPictureUrl = dayPictureUrl;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }
    }
}
