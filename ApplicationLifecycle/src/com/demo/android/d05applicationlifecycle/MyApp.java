package com.demo.android.d05applicationlifecycle;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class MyApp extends Application {
	
	public int count;
	
	private static MyApp myApp;
	
	public static MyApp getInstance() {
		return myApp;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		myApp = this;
		Log.i("Demo", "MyApp.onCreate()");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.i("Demo", newConfig.toString());
	}
}
