package com.ddt365.ddt_new;

import com.ddt365.ddt_new.util.AndroidUtils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;

public class DdtNewApplication extends Application {
	public static String LOGSTR = "ddt-new::";
	public static boolean CANLOG = true;
	public static boolean CANLOGIN = true;
	private static DdtNewApplication _instance;
	public static String imei;
	public static String VER;

	private static final String PREF_NAME = "com.ddt365.ddt_new";
	private SharedPreferences pref;
		
	public static DdtNewApplication instance() {
		return _instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		imei = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE))
				.getDeviceId();
		if (null == imei) {
			imei = Secure.getString(this.getContentResolver(),
					Secure.ANDROID_ID);
		}
		VER = AndroidUtils.getPackageInfo(this).versionName;
		if (CANLOG) {
			Log.d(LOGSTR, "ver==" + VER);
		}

		pref = getShare(this);
		pref.registerOnSharedPreferenceChangeListener(new DDTSharedPreferenceChangeListener());
		
	}

	public static SharedPreferences getShare(Context context) {
		return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
	}

	protected class DDTSharedPreferenceChangeListener implements
			SharedPreferences.OnSharedPreferenceChangeListener {

		@Override
		public void onSharedPreferenceChanged(
				SharedPreferences sharedPreferences, String s) {

		}
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();

	}

}
