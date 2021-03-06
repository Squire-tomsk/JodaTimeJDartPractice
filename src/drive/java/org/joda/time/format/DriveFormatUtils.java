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

    public void testCalculateDigitCount(long value) {
	System.out.println("[*] value: " + value);
	FormatUtils.calculateDigitCount(value);
    }

	public void testAppendPaddedIntegerWithIntValue(int value, int size) throws IOException {
		StringBuilder sb = new StringBuilder();
		System.out.println("[*] value: " + value);
		System.out.println("[*] size: " + size);
		FormatUtils.appendPaddedInteger(sb, value, size);
	}

public void testAppendUnpaddedInteger(int value) throws IOException {
		StringBuilder sb = new StringBuilder();
	System.out.println("[*] value: " + value);
	FormatUtils.appendUnpaddedInteger(sb, value);
    }
	
    
    public static void main(String[] args) {
        try {
            new DriveFormatUtils().testAppendPaddedInteger(0l,1);
	    new DriveFormatUtils().testCalculateDigitCount(0l);
	    new DriveFormatUtils().testAppendPaddedIntegerWithIntValue(0, 0);
	    new DriveFormatUtils().testAppendUnpaddedInteger(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
