package com.demo.android.d08multipleactivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    Button button = new Button(this);
	    String msg = "This is the AboutActivity\n" +
	    			"Touch this button to finish() this activity";
	    button.setText(msg);
	    button.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				finish();
			}
		});
	    setContentView(button);
	
	}

}
