package com.hassan.androidutils;

/**
 * IOUtils
 *
 * @author Hassan Jawed
 * @since 6/8/13
 */
public class IOUtils {

	public static boolean isSDPresent () {
		return android.os.Environment.getExternalStorageState().equals( android.os.Environment.MEDIA_MOUNTED );
	}
}
