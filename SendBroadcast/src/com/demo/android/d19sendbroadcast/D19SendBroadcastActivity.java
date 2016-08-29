package com.demo.android.d19sendbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class D19SendBroadcastActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        Button button = new Button(this);
        button.setText("Press Button\nto send Broadcast:\ncom.demo.action.HELLO");
        button.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("KEY", "This is a string value");
				//intent.getStringExtra("KEY");
				intent.setAction("com.demo.action.HELLO");
				sendBroadcast(intent);
			}
		});
        setContentView(button);
    }
}