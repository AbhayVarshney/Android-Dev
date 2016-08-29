package com.demo.android.d30notificationservice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    TextView textView = new TextView(this);
	    textView.setText("This is the HelloActivity\nPress BACK Key to end");
	    setContentView(textView);
	}

}
