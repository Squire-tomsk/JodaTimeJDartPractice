package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.DecoratedDateTimeField;
import org.joda.time.field.FieldUtils;

class DriveISOYearOfEraDateTimeFieldv1{
	public static void main(String[] args){
		long var1 = 1l;
		long var2 = 2l;
		ISOYearOfEraDateTimeField.INSTANCE.getDifference(var1, var2);
	}
}
