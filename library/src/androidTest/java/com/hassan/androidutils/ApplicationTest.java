package com.hassan.androidutils;

import android.app.Application;
import android.test.ApplicationTestCase;
import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

	public ApplicationTest () {
		super( Application.class );
	}

	public void testFormatTime () {
		int h = 2, m = 21;
		String s = DateTimeUtils.format24HourTime( h, m );
		Assert.assertTrue( "02:21".equals( s ) );

		String time2 = DateTimeUtils.formatTime( 12, 0 );
		Assert.assertTrue( "12:00 pm".equals( time2 ) );
	}
}
