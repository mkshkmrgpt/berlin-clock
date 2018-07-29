package com.ubs.opsit.interviews;

public class TimeParser {

    public static CustomTime parseDate(String time) {
        try {
            String[] timeArr = time.split(":");
            int hour = Integer.parseInt(timeArr[0]);
            int min = Integer.parseInt(timeArr[1]);
            int sec = Integer.parseInt(timeArr[2]);
            CustomTime normalTime = new NormalTime(hour, min, sec);
            if (normalTime.isValidDate()){
                return normalTime;
            }else {
                throw new TimeConverterException();
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new TimeConverterException();
        }
    }
}
