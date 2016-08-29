package com.demo.android.d05applicationlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textView;
	
	private void doUpdateDisplay() {
		textView.setText("Count = " + MyApp.getInstance().count);
	}
	public void doButton(View view) {
		MyApp.getInstance().count++;
		doUpdateDisplay();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.textView1);
    }
    @Override
    protected void onResume() {
    	super.onResume();
    	doUpdateDisplay();
    }
}