package com.demo.android.d03counter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private static final String TAG = "Demo";

	private static final String KEY_COUNT = "KeyCount";
	
	// Option 1 - static int count;
	// Option 2 - Use Bundle to save state
	int count;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        if (savedInstanceState != null) {
        	count = savedInstanceState.getInt(KEY_COUNT);
        }
        
        // Demo 1 - Create a Button using Java
        Button button = new Button(this);
        button.setText("Count = " + count);
        button.setOnClickListener(this);
        setContentView(button);
        Log.i(TAG, "onCreate");
    }
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.i(TAG, "onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	outState.putInt(KEY_COUNT, count);
    	Log.i(TAG, "onSaveInstanceState");
    }

	public void onClick(View view) {
		count++;
		Button button = (Button) view;
		button.setText("Count = " + count);
		
	}
}