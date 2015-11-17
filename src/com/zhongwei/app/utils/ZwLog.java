package com.zhongwei.app.utils;

import android.util.Log;
/**
 * 
 * @author Cheng.xie 打印类
 *
 */
public class ZwLog {

	public static String TAG = "ZW_app_log";
	
	public static void i(String tag, String i) {
		if (tag == null || i == null) {
			return;
		}
		Log.i(tag, i);
	}

	public static void d(String tag, String d) {
		if (tag == null || d == null) {
			return;
		}
		Log.d(tag, d);
	}

	public static void e(String tag, String e) {
		if (tag == null || e == null) {
			return;
		}
		Log.e(tag, e);
	}

	public static void v(String tag, String v) {
		if (tag == null || v == null) {
			return;
		}
		Log.v(tag, v);
	}

	public static void w(String tag, String w) {
		if (tag == null || w == null) {
			return;
		}
		Log.w(tag, w);

	}

	public static void wtf(String tag, String wtf) {
		if (tag == null || wtf == null) {
			return;
		}
		Log.wtf(tag, wtf);
	}
}
