package com.demo.android.d28day4review;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	boolean running;
	Runnable myServiceThread = new Runnable() {	
		public void run() {
			while (running) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	};
	
	@Override
	public void onCreate() {
		super.onCreate();
		running = true;
		new Thread(myServiceThread).start();
	}	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}	
	@Override
	public void onDestroy() {
		super.onDestroy();
		running = false;
	}

}
