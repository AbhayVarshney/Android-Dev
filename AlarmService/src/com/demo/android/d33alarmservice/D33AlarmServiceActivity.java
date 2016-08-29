package com.demo.android.d33alarmservice;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;

public class D33AlarmServiceActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (KeyEvent.KEYCODE_BACK == keyCode) {
			schedule_alarm();
			finish();
			return true;
		}
    	return super.onKeyDown(keyCode, event);
    }

	private void schedule_alarm() {
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		//getSystemService(Context.
		Intent intent = new Intent();
		intent.setClassName("com.demo.android.d01flashlight", "com.demo.android.d01flashlight.MainActivity");
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		am.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + (10 * 1000), pi); //10 seconds
		
	}
}