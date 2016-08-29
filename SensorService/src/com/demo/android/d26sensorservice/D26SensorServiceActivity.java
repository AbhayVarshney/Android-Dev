package com.demo.android.d26sensorservice;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class D26SensorServiceActivity extends Activity {

	TextView textView;
	
	static SensorManager sm;
	
	SensorEventListener myListener = new SensorEventListener() {
		
		public void onSensorChanged(SensorEvent event) {
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				String msg = "x: " + event.values[0] + "\n" +
							"y: " + event.values[1] + "\n" +
							"z: " + event.values[2];
				textView.setText(msg);
			}
		}
		
		public void onAccuracyChanged(Sensor sensor, int accuracy) {			
		}
	};
	
	public void doCheckBox(View view) {
		CheckBox cb = (CheckBox) view;
		if (cb.isChecked()) {
			sm = (SensorManager) getSystemService(SENSOR_SERVICE);
			Sensor  accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			sm.registerListener(myListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
			textView.setText("Waiting for sensor manager");
		} else {
			textView.setText("");
			sm.unregisterListener(myListener);
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.textView1);
    }
}