package org.joda.time.chrono;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.ReadablePartial;
import org.joda.time.chrono.ZonedChronology.ZonedDurationField;
import org.joda.time.field.PreciseDurationField;

public class DriveZonedChronology {
	
	private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
		
	private void testLocalToUTC(int chronoKind, long localInstant) {
		BaseChronology chrono = getChrono(chronoKind);
		if (chrono == null) return;

		System.out.println("[*] chrono: " + chrono.getClass());
		System.out.println("[*] localInstant: " + localInstant);
		ZonedChronology zc = ZonedChronology.getInstance(chrono, PARIS);
		zc.localToUTC(localInstant);
	}
	
	private void testGetDateTimeMillis(int chronoKind, int year,
            int monthOfYear,
            int dayOfMonth,
            int hourOfDay,
            int minuteOfHour,
            int secondOfMinute,
            int millisOfSecond) {
		BaseChronology chrono = getChrono(chronoKind);
		ZonedChronology zc = ZonedChronology.getInstance(chrono, PARIS);
		zc.getDateTimeMillis(year, monthOfYear, dayOfMonth, hourOfDay, 
				minuteOfHour, secondOfMinute, millisOfSecond);
	}
	
	private void testDateTime(int year,
            int monthOfYear,
            int dayOfMonth,
            int hourOfDay,
            int minuteOfHour,
            int secondOfMinute,
            int millisOfSecond) {
		new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, 
				minuteOfHour, secondOfMinute, millisOfSecond);
	}

	private BaseChronology getChrono(int chrnoKind) {
		switch (chrnoKind) {
//		case 0: return CopticChronology.getInstance(PARIS);
//		case 1: return EthiopicChronology.getInstance(PARIS);
		case 2: return GregorianChronology.getInstance(PARIS);
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
		new DriveZonedChronology().testLocalToUTC(0, 0); // Work!
//		new DriveZonedChronology().testDateTime(0, 0, 0, 0, 0, 0, 0);
//		new DriveZonedChronology().testGetDateTimeMillis(0, 2000, 6, 30, 0, 0, 0, 0);		
	}
}