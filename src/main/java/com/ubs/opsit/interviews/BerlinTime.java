package com.ubs.opsit.interviews;

public class BerlinTime {

    public String getTime(CustomTime normalTime) {
        String hour = BerlinTimeUtil.convertToBerlinHour((Integer) normalTime.getHour());
        String min = BerlinTimeUtil.convertToBerlinMinute((Integer) normalTime.getMin());
        String sec = BerlinTimeUtil.getBerlinSecond((Integer) normalTime.getSec());
        return sec + "\n" + hour + "\n" + min;
    }
}
