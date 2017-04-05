package org.joda.time.format;

import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormatterBuilder;

/**
 * Created by abuca on 04.04.17.
 */
public class DriveDateTimeFormatterBuilder {
    public void testAppendFractionOfMinute(int minDigits, int maxDigits){
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        System.out.println("[*] minDigits: " + minDigits);
        System.out.println("[*] maxDigits: " + maxDigits);
        dateTimeFormatterBuilder.appendFractionOfMinute(minDigits,maxDigits);
    }

    public static void main(String[] args) {
        new DriveDateTimeFormatterBuilder().testAppendFractionOfMinute(0,1);
    }
}
