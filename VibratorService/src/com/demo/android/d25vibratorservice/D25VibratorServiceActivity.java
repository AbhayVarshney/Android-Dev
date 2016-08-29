package com.demo.android.d25vibratorservice;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;

public class D25VibratorServiceActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Vibrator vibrator;
			vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
			vibrator.vibrate(250); //milliseconds
			return true;
		}
    	return super.onTouchEvent(event);
    }
}