package com.demo.android.d08multipleactivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class OKCancelActivity extends Activity {

	public void doButton(View view) {
		switch (view.getId()) {
		case R.id.button1:
			setResult(RESULT_OK);
			break;
		case R.id.button2:
			setResult(RESULT_CANCELED);
			break;
		}
		finish();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.okcancel);
	}

}
