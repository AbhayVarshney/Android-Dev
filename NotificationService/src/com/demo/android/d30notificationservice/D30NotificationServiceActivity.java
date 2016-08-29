package com.demo.android.d30notificationservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class D30NotificationServiceActivity extends Activity {

	static boolean serviceRunning;
	
	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "onResumse", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        Button button = new Button(this);
        button.setText("Touch to start service\nAnd send notification");
        button.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View view) {
				Button button = (Button) view;
				if (serviceRunning) {
					stopService(new Intent(getApplicationContext(), MyService.class));
					button.setText("Touch to start service\nAnd send notification");
				} else {
					startService(new Intent(getApplicationContext(), MyService.class));
					button.setText("Touch to STOP service");
				}
				serviceRunning = !serviceRunning;
			}
		});
        setContentView(button);
    }
}