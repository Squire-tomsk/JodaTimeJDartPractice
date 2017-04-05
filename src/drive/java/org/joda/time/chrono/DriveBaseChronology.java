package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadablePartial;

public class DriveBaseChronology {
	
	private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
	
	private void testValidate(int chronoKind, int partialKind, int[] values) {
		BaseChronology chrono = getChrono(chronoKind);
		ReadablePartial partial = getPartial(partialKind);
		
		if (chrono == null || partial == null) return;
		
		System.out.println("[*] chrono: " + chrono.getClass());
		try {
			chrono.validate(partial, values);
		} catch (IllegalFieldValueException e) {}
	}

	private BaseChronology getChrono(int chrnoKind) {
		switch (chrnoKind) {
		case 0: return CopticChronology.getInstance(PARIS);
//		case 1: return EthiopicChronology.getInstance(PARIS);
//		case 2: return GregorianChronology.getInstance(PARIS);
//		case 3: return JulianChronology.getInstance(PARIS);
		}
		return null;
	}

	private ReadablePartial getPartial(int partialKind) {
		switch (partialKind) {
		case 0: return new LocalDate(PARIS);
//		case 1: return new LocalDateTime(PARIS);
//		case 2: return new LocalTime(PARIS);
		}
		return null;
	}

	public static void main(String[] args) {
		int partialKind = 0;
		int[] values = {1, 2, 3, 4};
		new DriveBaseChronology().testValidate(0, partialKind, values);
	}
}