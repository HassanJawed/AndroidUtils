package com.hassan.androidutils;

import android.util.Log;

/**
 * LogUtils
 *
 * @author Hassan Jawed
 * @since 9/11/13
 */
public class LogUtils {

	public static void logD (String tag, String text) {
//        if ( !BuildConfig.DEBUG ) return;
		Log.d( tag, text );
	}

	public static String createTag (Class<?> cls) {
		return cls.getName();
	}

	public static void logW (String tag, String text) {
		Log.w( tag, text );
	}

	public static void logE (String tag, String log, Exception exception) {
		Log.e( tag, log, exception );
	}
}
