package com.ubs.opsit.interviews;

public class NormalTime implements CustomTime{
    private int hour;
    private int min;
    private int sec;

    NormalTime(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    @Override
    public Integer getHour() {
        return hour;
    }

    @Override
    public Integer getMin() {
        return min;
    }

    @Override
    public Integer getSec() {
        return sec;
    }

    public boolean isValidDate() {
        return hour >= 0 && hour <= 24 && min >= 0 && min < 60 && sec >= 0 && sec < 60;
    }
}
