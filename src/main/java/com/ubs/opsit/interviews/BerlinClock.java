package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClock implements TimeConverter {

    private static final Logger logger = LoggerFactory.getLogger(BerlinClock.class);

    @Override
    public String convertTime(String aTime) {

        CustomTime normalTime;
        try {
            normalTime = TimeParser.parseDate(aTime);
        } catch (TimeConverterException ex) {
            logger.error("Invalid Time", aTime);
            return "";
        }
        return new BerlinTime().getTime(normalTime);
    }
}
