package kyu5.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanReadableTimeTest {

    @Test
    public void testOneHour() {
        assertEquals("makeReadable(0)", "01:00:00", HumanReadableTime.makeReadable(3600));
    }

    @Test
    public void testTenHour() {
        assertEquals("makeReadable(0)", "10:00:00", HumanReadableTime.makeReadable(36000));
    }

    @Test
    public void testOneMinute() {
        assertEquals("makeReadable(0)", "00:01:00", HumanReadableTime.makeReadable(60));
    }

    @Test
    public void test59Minutes() {
        assertEquals("makeReadable(0)", "00:01:00", HumanReadableTime.makeReadable(60));
    }

    @Test
    public void testZeroSeconds() {
        assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
    }

    @Test
    public void testOnlySecondsSingleDigit() {
        assertEquals("makeReadable(0)", "00:00:05", HumanReadableTime.makeReadable(5));
    }

    @Test
    public void testOnlySecondsDoubleDigit() {
        assertEquals("makeReadable(0)", "00:00:15", HumanReadableTime.makeReadable(15));
    }

    @Test
    public void test() {
        assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
        assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
        assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
    }
}
