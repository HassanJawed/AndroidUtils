package com.hassan.androidutils;

import android.widget.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hassan Jawed on 9/7/2015.
 */
public class InputValidator {

	public static boolean emailValid (TextView view) {
		if (view == null) throw new NullPointerException( "view is null" );

		if (TextUtils.isEmpty( view.getText() )) {
			return false;
		}
		Pattern pattern = Pattern.compile( "[a-zA-Z0-9_\\-\\.@]+" );
		Matcher matcher = pattern.matcher( view.getText() );
		return matcher.matches();
	}

	public static boolean emailValid (TextView view, String emptyError, String invalidError) {
		if (view == null) throw new NullPointerException( "view is null" );

		CharSequence text = view.getText();
		if (TextUtils.isEmpty( text )) {
			view.setError( emptyError );
			return false;
		}
		Pattern pattern = Pattern.compile( "[a-zA-Z0-9_\\-\\.@]+" );
		Matcher matcher = pattern.matcher( text );
		if (!matcher.matches()) {
			view.setError( invalidError );
			return false;
		}
		return true;
	}
}
