package com.hassan.androidutils;

/**
 * Created by Hassan Jawed on 9/8/2015.
 */
public class MathUtils {

	public static int getRandomIntBetween (int min, int max) {
		int distance = (int) Math.sqrt( square( max - min ) );

		double v = Math.random() * distance;
		return (int) (v - min);
	}

	public static double square (double num) {
		return num * num;
	}
}
