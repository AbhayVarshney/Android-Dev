package com.demo.adroid.d29viewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class D29ViewFlipperActivity extends Activity {

	public void doButton(View view) {
		ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
		if (view.getId() == R.id.button1) {
			viewFlipper.showPrevious();
		}
		else {
			viewFlipper.showNext();
		}
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}