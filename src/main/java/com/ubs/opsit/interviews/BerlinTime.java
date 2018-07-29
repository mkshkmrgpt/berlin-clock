package com.ubs.opsit.interviews;

public class BerlinTime {
    private String hour;
    private String minute;
    private String second;

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getBerlinTime(){
        return second+"\n"+hour+"\n"+minute;
    }
}
