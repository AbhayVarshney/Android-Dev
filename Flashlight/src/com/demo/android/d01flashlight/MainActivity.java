package com.demo.android.d01flashlight;

//import android.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	
	View view;
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			view.setBackgroundColor(Color.BLACK);
// what is this true doing?
			return true;
		}
		else if (event.getAction() == MotionEvent.ACTION_UP) {
			view.setBackgroundColor(Color.WHITE);
			return true;
		}
// what does this mean?
		return super.onTouchEvent(event);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
// what does super. do?
        super.onCreate(savedInstanceState);
        
        // Demo 3- Use both Java and XML Layout
        
// does this declare that the xml file (main) is the ui?
        setContentView(R.layout.main);
        view = findViewById(R.id.myview);
        
//        // Demo 2 - Use XML Layout
//        setContentView(R.layout.main);
        
//        // Demo 1 - Use 100% Java
//        View view = new View(this);
//        view.setBackgroundColor(Color.WHITE);
//        setContentView(view);
        
    }
}