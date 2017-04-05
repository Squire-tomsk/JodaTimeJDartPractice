package org.joda.time;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestUTCDateTimeZone{
    @Test
    public void Test1UTCDateTimeZone(){
        assertEquals(0, new UTCDateTimeZone().getStandardOffset(0l));
    }

    @Test
    public void Test2TCDateTimeZone(){
        long var = 0l;
        assertEquals(var, new UTCDateTimeZone().nextTransition(var));
    }

    @Test
    public void Test3TCDateTimeZone(){
        long var = 0l;
        assertEquals(var, new UTCDateTimeZone().previousTransition(var));
    }
}

