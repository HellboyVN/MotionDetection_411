/**
 * @brief 유틸리티 패키지
 */
package com.hhbgk.webservice.discovery.util;

import android.util.Log;

public class LOG {

	public static void d(String TAG, String Message) {
		Log.d(TAG, "#### " + Message);
	}

	public static void e(String TAG, String Message) {
		Log.e(TAG, "#### " + Message);
	}

	public static void i(String TAG, String Message) {
		Log.i(TAG, "#### " + Message);
	}

	public static void v(String TAG, String Message) {
		Log.v(TAG, "#### " + Message);
	}

}
