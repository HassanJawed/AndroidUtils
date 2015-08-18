package com.hassan.androidutils;

import android.app.Activity;

/**
 * Created by Trikster on 7/23/2015.
 */
public class ErrorUtils {


	public static IllegalStateException activityCastException (Activity activity, Class implementedClass) {
		return new IllegalStateException(
				activity.getLocalClassName() + " must implement " + implementedClass.getCanonicalName() );
	}
}
