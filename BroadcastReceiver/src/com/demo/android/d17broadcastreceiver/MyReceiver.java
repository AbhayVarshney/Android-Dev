package com.demo.android.d17broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// Max of 5 seconds to respond!
		String action = intent.getAction();
		String msg = "MyReceiver.onReceive\n" + action;
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

}
