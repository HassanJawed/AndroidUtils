package com.hassan.androidutils;

import android.app.Activity;
import android.support.v4.app.*;

/**
 * FragmentUtils
 *
 * @author Hassan Jawed
 * @since 9/11/13
 */
public class FragmentUtils {


	public static FragmentBuilder createBuilder (FragmentActivity activity) {
		return new FragmentBuilder( activity );
	}

	public static <T> T castActivity (Activity activity, Class<?> clas) {
		if (clas.isInstance( activity )) {
			return (T) activity;
		} else {
			throw new IllegalStateException(
					activity.getLocalClassName() + " must implement " + clas.getCanonicalName() );
		}
	}

	public static class FragmentBuilder {

		private final FragmentActivity activity;
		private       int              containerId;
		private boolean shouldAddToBackStack = true;
		private String  backStackTag         = null;
		private int     enterAnimation       = 0;
		private int     exitAnimation        = 0;
		private int     popEnterAnimation    = 0;
		private int     popExitAnimation     = 0;

		public FragmentBuilder (FragmentActivity activity) {
			this.activity = activity;
		}

		public FragmentBuilder containerId (int containerId) {
			this.containerId = containerId;
			return this;
		}

		public FragmentBuilder addToBackStack (boolean shouldAddToBackStack) {
			this.shouldAddToBackStack = shouldAddToBackStack;
			return this;
		}

		public FragmentBuilder addToBackStack (boolean shouldAddToBackStack, String backStackTag) {
			this.shouldAddToBackStack = shouldAddToBackStack;
			this.backStackTag = backStackTag;
			return this;
		}

		public FragmentBuilder setAnimations (int enter, int exit, int popEnter, int popExit) {
			this.enterAnimation = enter;
			this.exitAnimation = exit;
			this.popEnterAnimation = popEnter;
			this.popExitAnimation = popExit;
			return this;
		}

		public void add (Fragment fragment, String tag) {
			FragmentTransaction ft = activity.getSupportFragmentManager()
											 .beginTransaction()
											 .setCustomAnimations( enterAnimation, exitAnimation, popEnterAnimation,
													 popExitAnimation );
			ft.add( containerId, fragment, tag );
			if (shouldAddToBackStack) ft.addToBackStack( backStackTag );
			ft.commit();
		}

		public void replace (Fragment fragment, String tag) {
			FragmentTransaction ft =
					activity.getSupportFragmentManager().beginTransaction()
							.setCustomAnimations( enterAnimation, exitAnimation, popEnterAnimation,
									popExitAnimation );
			ft.replace( containerId, fragment, tag );
			if (shouldAddToBackStack) ft.addToBackStack( backStackTag );
			ft.commit();
		}
	}
}
