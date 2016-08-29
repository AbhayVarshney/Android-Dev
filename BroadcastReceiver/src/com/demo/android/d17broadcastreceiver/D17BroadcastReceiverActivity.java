package com.demo.android.d17broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class D17BroadcastReceiverActivity extends Activity {
	
	MyReceiver receiver;
 
	public void doCheckBox(View view) {
		CheckBox cb = (CheckBox) view;
		if (cb.isChecked()) {
			IntentFilter filter = new IntentFilter();
			filter.addAction(Intent.ACTION_TIME_TICK);
			receiver = new MyReceiver();
			registerReceiver(receiver, filter);
		} 
		else {
			unregisterReceiver(receiver);
			receiver = null;
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (receiver != null) {
			unregisterReceiver(receiver);
			receiver = null;
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}