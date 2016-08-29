package com.demo.android.d20menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class D20MenuActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater mi = getMenuInflater();
    	mi.inflate(R.menu.hello, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.aboutMenu:
    		Toast.makeText(this, "TODO: Handle about", Toast.LENGTH_LONG).show();
    		return true;
    	case R.id.settingMenu:
    		Toast.makeText(this, "TODO: Handle settings", Toast.LENGTH_LONG).show();
    		return true;
    	}
    	return false;
    }
}