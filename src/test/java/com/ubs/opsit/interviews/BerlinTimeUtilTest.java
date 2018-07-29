package com.ubs.opsit.interviews;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BerlinTimeUtilTest {

    @Test
    public void whenMidnightTimeProvidedReturnsBerlinMidnightTime(){
        String hourBuilder = "OOOO\n" + "OOOO";
        String berlinHour = BerlinTimeUtil.getBerlinHour(0);
        assertEquals(hourBuilder, berlinHour);
    }

    @Test
    public void whenMidnightTime24HrProvidedReturnsBerlinMidnightTime(){
        StringBuilder hourBuilder = new StringBuilder();
        hourBuilder.append("RRRR\n")
                .append("RRRR");
        String berlinHour = BerlinTimeUtil.getBerlinHour(24);
        assertEquals(hourBuilder.toString(), berlinHour);
    }

    @Test
    public void whenHourProvidedReturnsBerlinHour(){
        StringBuilder hourBuilder = new StringBuilder();
        hourBuilder.append("RROO\n")
                .append("RRRO");
        String berlinHour = BerlinTimeUtil.getBerlinHour(13);
        assertEquals(hourBuilder.toString(), berlinHour);
    }

    @Test
    public void whenMintueProvidedReturnsBerlinMinute(){
        StringBuilder hourBuilder = new StringBuilder();
        hourBuilder.append("YYROOOOOOOO\n")
                .append("YYOO");
        String berlinHour = BerlinTimeUtil.getBerlinMinute(17);
        assertEquals(hourBuilder.toString(), berlinHour);
    }

    @Test
    public void whenSecondIsEvenReturnsY(){
        assertEquals("Y", BerlinTimeUtil.getBerlinSecond(2));
    }

    @Test
    public void whenSecondIsOddReturnsO(){
        assertEquals("O", BerlinTimeUtil.getBerlinSecond(1));
    }
}