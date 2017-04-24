package com.insurance.bluescheme.insure.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreference {
	
	SharedPreferences preferences;
	Editor editor;
	
	private static final String PREFS_NAME = "insurance";
	
	public static final String LOG_IN_STATUS = "login";
	public static final String USER_ID = "user_id";
	public static final String USER_EMAIL = "user_email";
	public static final String CURRENT_TIME	= "current_time";
	public static final String IMAGE_URL = "image_url";
	public static final String SEARCH_DATA = "search_data";
	public static final String API_TOKEN = "api_token";
	public static final String SplashCheck = "splash";
	public static final String INTRO_DATA= "intro_data";




	public SharedPreference() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static boolean getBooleanValue(final Context context, String key){
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
				.getBoolean(key, false);
	}
	
	
	public static void setBooleanValue(final Context context, String key,
			Boolean status) {
		final SharedPreferences prefs = context.getSharedPreferences(
				PREFS_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();

		editor.putBoolean(key, status);
		editor.commit();
	}
	

	
	public static String getStringValue(final Context context, String key) {
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
				.getString(key, "");
	}

	public static void setStringValue(final Context context, String key,
			String value) {
		final SharedPreferences prefs = context.getSharedPreferences(
				PREFS_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();

		editor.putString(key, value);
		editor.commit();
	}
	
	public static int getIntValue(final Context context, String key) {
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
				.getInt(key, 0);
	}

	public static void setIntValue(final Context context, String key,
			int value) {
		final SharedPreferences prefs = context.getSharedPreferences(
				PREFS_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();

		editor.putInt(key, value);
		editor.commit();
	}
	
	public static long getLongValue(final Context context, String key){
		return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getLong(key, 0);
	}
	
	public static void setLongValue(final Context context, String key,
			long value){
		final SharedPreferences prefs = context.getSharedPreferences(
				PREFS_NAME, Context.MODE_PRIVATE);
		final Editor editor = prefs.edit();
		editor.putLong(key, value);
		editor.commit() ;
	}



}
