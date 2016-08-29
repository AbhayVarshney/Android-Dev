package com.demo.android.d06preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final String KEY_COUNT = "KeyCount";
	int count;
	Button button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        button = new Button(this);
        updateButton();
        button.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				count++;
				updateButton();
			}
		});
        setContentView(button);
    }

	private void updateButton() {
		button.setText("Count = " + count);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences sp = getPreferences(0);
		SharedPreferences.Editor editor = sp.edit();
		editor.putInt(KEY_COUNT, count);
		editor.commit();
	}
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences sp = getPreferences(0);
		count = sp.getInt(KEY_COUNT, 0);
		updateButton();
	}
	
	
}