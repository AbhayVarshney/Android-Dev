package com.demo.android.d30notificationservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		// Demo sending a notification
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification n = new Notification(R.drawable.ic_launcher, "Ticker Text", System.currentTimeMillis());
		Intent intent = new Intent(this, HelloActivity.class);
		PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
		n.setLatestEventInfo(this, "title goes here", "content goes here", pi);
		nm.notify(1, n);	
	}

}
