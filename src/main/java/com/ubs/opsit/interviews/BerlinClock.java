package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClock implements TimeConverter {

    private static final Logger logger = LoggerFactory.getLogger(BerlinClock.class);

    @Override
    public String convertTime(String aTime) {
        if (aTime == null || aTime.isEmpty())
            return "";
        NormalTime normalTime = parseDate(aTime);
        if (isValidDate(normalTime)) {
            return getBerlinTime(normalTime);
        } else {
            logger.error("Invalid time", aTime);
            return "";
        }
    }

    private String getBerlinTime(NormalTime normalTime) {
        BerlinTime berlinTime = new BerlinTime();
        berlinTime.setHour(BerlinTimeUtil.getBerlinHour(normalTime.getHour()));
        berlinTime.setMinute(BerlinTimeUtil.getBerlinMinute(normalTime.getMin()));
        berlinTime.setSecond(BerlinTimeUtil.getBerlinSecond(normalTime.getSec()));
        return berlinTime.getBerlinTime();
    }

    private NormalTime parseDate(String time) {
        String[] timeArr = time.split(":");
        try {
            int hour = Integer.parseInt(timeArr[0]);
            int min = Integer.parseInt(timeArr[1]);
            int sec = Integer.parseInt(timeArr[2]);
            return new NormalTime(hour, min, sec);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            logger.error("Invalid time", time);
        }
        return null;
    }

    private boolean isValidDate(NormalTime normalTime) {
        if (normalTime == null) {
            return false;
        }
        int hour = normalTime.getHour();
        int min = normalTime.getMin();
        int sec = normalTime.getSec();
        return hour >= 0 && hour <= 24 && min >= 0 && min < 60 && sec >= 0 && sec < 60;
    }
}
