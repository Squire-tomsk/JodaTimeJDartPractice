package org.joda.time.format;

import java.io.IOException;

/**
 * Created by abuca on 05.04.17.
 */
public class DriveFormatUtils {

    public void testAppendPaddedInteger(long value, int size) throws IOException {
        StringBuilder sb = new StringBuilder();
        System.out.println("[*] value: " + value);
        System.out.println("[*] size: " + size);
        FormatUtils.appendPaddedInteger(sb,value,size);
    }

    public static void main(String[] args) {
        try {
            new DriveFormatUtils().testAppendPaddedInteger(0l,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
