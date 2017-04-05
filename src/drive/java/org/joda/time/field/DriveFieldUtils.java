
package org.joda.time.field;

import java.io.IOException;


public class DriveFieldUtils{
	public void testSafeMultiply(long val1, long val2){
		FieldUtils.safeMultiply(val1,val2);
	}

	public static void main(String[] args){
		long val1 = 10l;
		long val2 = 100l;
		new DriveFieldUtils().testSafeMultiply(val1,val2);
	}
}
