package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TimeParserTest {

    @Test
    public void whenCalledShouldParseStringToNormalTime(){
        NormalTime normalTime = (NormalTime) TimeParser.parseDate("13:32:00");
        assertNotNull(normalTime);
        assertEquals(Integer.valueOf(13),normalTime.getHour() );
        assertEquals(Integer.valueOf(32), normalTime.getMin());
        assertEquals(Integer.valueOf(00), normalTime.getSec());
    }

    @Test(expected = TimeConverterException.class)
    public void whenInvalidHourIsProvidedShouldThrowException(){
        TimeParser.parseDate("25:40:00");
    }


    @Test(expected = TimeConverterException.class)
    public void whenInvalidMInIsProvidedShouldThrowException(){
        TimeParser.parseDate("23:60:00");
    }


    @Test(expected = TimeConverterException.class)
    public void whenInvalidSecIsProvidedShouldThrowException(){
        TimeParser.parseDate("22:40:60");
    }

    @Test(expected = TimeConverterException.class)
    public void whenInvalidStringIsProvidedShouldThrowException(){
        TimeParser.parseDate("sfdjsljf");
    }
}
