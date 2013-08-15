package com.ddt365.ddt_new.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class AndroidUtils {
	public static PackageInfo getPackageInfo(Context context) {
		try {
			return context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
		} catch (PackageManager.NameNotFoundException e) {
			return null;
		}
	}
}
