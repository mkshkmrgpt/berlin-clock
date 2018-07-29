package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BerlinTimeTest {

    @Test
    public void whenNormalTimeIsProvidedShouldReturnBerlinTime(){
        String berlinTimeBuilder = new StringBuilder().append("O\n")
                .append("RROO\n").append("RRRO\n")
                .append("YYROOOOOOOO\n")
                .append("YYOO")
                .toString();
        NormalTime normalTime = new NormalTime(13,17,1);
        String berlinTime = new BerlinTime().getTime(normalTime);
        assertNotNull(berlinTime);
        assertEquals(berlinTimeBuilder, berlinTime);
    }

}
