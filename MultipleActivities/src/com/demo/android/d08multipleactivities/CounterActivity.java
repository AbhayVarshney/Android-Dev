package com.demo.android.d08multipleactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class CounterActivity extends Activity {

	public static final String KEY_COUNT = "KeyCount";
	
	int count;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    Intent intent = getIntent();
	    count = intent.getIntExtra(KEY_COUNT, 0);
	    
	    String msg = "This is CounterActivity\n" + "Count = " + count + "\n" + "Touch screen to increment count and finish()";
	    TextView textView = new TextView(this);
	    textView.setText(msg);
	    setContentView(textView);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			count++;
			Intent intent = new Intent();
			intent.putExtra(KEY_COUNT, count);
			setResult(RESULT_OK, intent);
			finish();
		}
		return super.onTouchEvent(event);
	}

}
