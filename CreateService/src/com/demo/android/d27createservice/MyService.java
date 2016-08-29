package com.demo.android.d27createservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(getApplicationContext(), "MyService.onCreate", Toast.LENGTH_LONG).show();
		//NOTE: Most services start up threads!
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "MyService.onStart", Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "MyService.onDestroy", Toast.LENGTH_LONG).show();
	}

}
