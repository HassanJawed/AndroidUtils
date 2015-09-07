package com.hassan.androidutils;

import android.widget.*;

/**
 * TextUtils
 *
 * @author Hassan Jawed
 * @since 9/13/13
 */
public class TextUtils {

	public static final String EMPTY = "";

	public static CharSequence emptyIfNull (CharSequence text) {
		return text == null ? EMPTY : text;
	}

	public static boolean isEmpty (String string) {
		return string == null || string.length() == 0;
	}

	public static boolean isEmpty (CharSequence string) {
		return string == null || string.length() == 0;
	}

	public static String getText (TextView textView) {
		return textView == null ? EMPTY : emptyIfNull( textView.getText() ).toString();
	}
}
