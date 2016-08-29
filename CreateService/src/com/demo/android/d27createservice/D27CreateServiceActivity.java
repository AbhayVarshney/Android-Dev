package com.demo.android.d27createservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class D27CreateServiceActivity extends Activity {
    
	public void doCheckBox(View view) {
		CheckBox cb = (CheckBox) view;
		Intent service = new Intent(this, MyService.class);
		if (cb.isChecked()) {
			startService(service);
		} else {
			stopService(service);
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}