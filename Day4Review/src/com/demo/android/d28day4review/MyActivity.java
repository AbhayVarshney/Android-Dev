package com.demo.android.d28day4review;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (KeyEvent.KEYCODE_BACK == keyCode) {
			Toast.makeText(this, "KEYCODE_BACK", Toast.LENGTH_LONG).show();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		int group = 0;
		int id = 1234;
		int order = 0;
		menu.add(group, id, order, "Menu 1");
		menu.add(group, ++id, order, "Menu 2");
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1234:
			Toast.makeText(this, "TODO: Menu 1", Toast.LENGTH_LONG).show();
			break;
		case 1235:
			Toast.makeText(this, "TODO: Menu 2", Toast.LENGTH_LONG).show();
			break;
		}
		return true;
	}

}
