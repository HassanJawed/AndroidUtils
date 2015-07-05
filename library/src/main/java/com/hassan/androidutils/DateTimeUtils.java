package com.hassan.androidutils;

/**
 * Created by Trikster on 7/5/2015.
 */
public class DateTimeUtils {

	public static String format24HourTime (int hourOfDay, int mins) {
		return String.format( "%02d:%02d", hourOfDay, mins );
	}

	public static String formatTime (int hourOfDay, int mins) {
		String ampm = hourOfDay <= 11 ? "am" : "pm";
		int hour = hourOfDay <= 12 ? hourOfDay : hourOfDay - 12;
		return String.format( "%02d:%02d %s", hour, mins, ampm );
	}
}
