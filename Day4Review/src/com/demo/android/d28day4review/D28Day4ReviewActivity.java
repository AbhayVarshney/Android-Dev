package com.demo.android.d28day4review;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class D28Day4ReviewActivity extends Activity {
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (MotionEvent.ACTION_DOWN == event.getAction()) {
			InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			EditText editText = (EditText) findViewById(R.id.editText1);
			imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
		}
		return super.onTouchEvent(event);
	}

	public void doButton(View view) {
		InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		EditText editText = (EditText) findViewById(R.id.editText1);
		imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater mi = getMenuInflater();
    	mi.inflate(R.menu.main, menu);
    	return true;
    }
    
    static boolean serviceRunning;
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.activityMenuItem:
			startActivity(new Intent(this, MyActivity.class));
			break;
		case R.id.receiverMenuItem:
			//todo
			break;
		case R.id.serviceMenuItem:
			if (serviceRunning) {
				stopService(new Intent(this, MyService.class));
				Toast.makeText(this, "Service is now stopped", Toast.LENGTH_LONG).show();
			}
			else {
				startService(new Intent(this, MyService.class));
				Toast.makeText(this, "Service is now RUNNING!", Toast.LENGTH_LONG).show();
			}
			serviceRunning = !serviceRunning;
			break;
		}
    	return true;
    }
}