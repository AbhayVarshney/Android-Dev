package com.demo.android.d02activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    private static final String TAG = "Demo";
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if (event.getAction() == MotionEvent.ACTION_DOWN) {
    		finish();
    		return true;
    	}
    		
    	return super.onTouchEvent(event);
    }

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.d(TAG, "debug");
        Log.e(TAG, "error");
        Log.i(TAG, "information");
        Log.v(TAG, "vebose");
        Log.w(TAG, "warning");
        
        Log.i(TAG, "onCreate"); 
    }
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause");
	}
	
}