package com.hassan.androidutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.pm.*;
import android.net.*;
import android.util.Base64;
import android.util.Log;
import android.widget.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * AndroidUtils.
 *
 * @author Hassan Jawed
 * @date 12/19/2014
 */
public class AndroidUtils {

	public static void startActivityForUrl (Context context, String url) {
		Intent i = new Intent( Intent.ACTION_VIEW );
		i.setData( Uri.parse( url ) );
		context.startActivity( i );
	}

	public static boolean isDebug (Context context) {
		return (0 != (context.getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE));
	}

	public static void printFBKeyHash (Activity activity) {
		try {
			PackageInfo info = activity.getPackageManager().getPackageInfo(
					activity.getPackageName(), PackageManager.GET_SIGNATURES );
			for (Signature signature : info.signatures) {
				MessageDigest md = MessageDigest.getInstance( "SHA" );
				md.update( signature.toByteArray() );
				Log.e( "MY KEY HASH:", Base64.encodeToString( md.digest(), Base64.DEFAULT ) );
			}
		}
		catch (PackageManager.NameNotFoundException e) {

		}
		catch (NoSuchAlgorithmException e) {

		}
	}

	public static Context getDialogContext (Activity activity) {
		Context ctx;
		if (activity.getParent() != null) { ctx = activity.getParent(); } else ctx = activity;
		return ctx;
	}

	public static void displayAlertDialog (Context context, int titleId, int messageId, int positiveText,
										   int negativeText) {
		AlertDialog.Builder builder = new AlertDialog.Builder( context );
		builder.setTitle( titleId );
		builder.setMessage( messageId );
		builder.setCancelable( true );
		builder.setPositiveButton( positiveText, new DialogInterface.OnClickListener() {
			public void onClick (DialogInterface dialog, int id) {
				dialog.cancel();
			}
		} );
		builder.setPositiveButton( negativeText, new DialogInterface.OnClickListener() {
			public void onClick (DialogInterface dialog, int id) {
				dialog.cancel();
			}
		} );
		AlertDialog alertDialog = builder.create();
		alertDialog.show();
	}

	public static boolean isNetworkConnected (Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
		NetworkInfo ni = cm.getActiveNetworkInfo();
		return ni != null;
	}

	public static void showShortToast (Context context, String text) {
		Toast.makeText( context, text, Toast.LENGTH_SHORT ).show();
	}

	public static void showShortToast (Context context, int text) {
		Toast.makeText( context, text, Toast.LENGTH_SHORT ).show();
	}
}
