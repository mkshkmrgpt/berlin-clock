package com.ubs.opsit.interviews;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BerlinClockTest {

    private TimeConverter berlinClock;

    @Before
    public void init() {
        berlinClock = new BerlinClock();
    }

    @Test
    public void whenInvalidDateIsProvidedShouldReturnEmptyString() {

        assertEquals("", berlinClock.convertTime("25:00:00"));
        assertEquals("", berlinClock.convertTime("12:60:00"));
        assertEquals("", berlinClock.convertTime("04:04:60"));
        assertEquals("", berlinClock.convertTime(""));
        assertEquals("", berlinClock.convertTime("04:04"));
        assertEquals("", berlinClock.convertTime("afsjdfjaso"));
        assertEquals("", berlinClock.convertTime(null));
    }

    @Test
    public void whenNormalTimeIsProvidedBerlinTimeShouldBeReturn() {
        String berlinTimeBuilder = new StringBuilder().append("O\n")
                .append("RROO\n").append("RRRO\n")
                .append("YYROOOOOOOO\n")
                .append("YYOO")
                .toString();
        String berlinTime = berlinClock.convertTime("13:17:01");
        assertEquals(berlinTimeBuilder, berlinTime);
    }

    @Test
    public void givenNormalMidnightTimeShouldReturnBerlinMidnightTime() {
        String berlinTimeBuilder = new StringBuilder().append("Y\n").
                append("OOOO\n").append("OOOO\n").
                append("OOOOOOOOOOO\n").append("OOOO").toString();
        String berlinTime = berlinClock.convertTime("00:00:00");
        assertEquals(berlinTimeBuilder, berlinTime);
    }

    @Test
    public void givenNormalMidnightTimeShouldReturnBerlinMidnightTime24Hour() {
        String berlinTimeBuilder = new StringBuilder().append("Y\n")
                .append("RRRR\n").append("RRRR\n")
                .append("OOOOOOOOOOO\n").append("OOOO")
                .toString();
        String berlinTime = berlinClock.convertTime("24:00:00");
        assertEquals(berlinTimeBuilder, berlinTime);
    }
}
