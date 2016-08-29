package com.demo.android.d08multipleactivities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private static final String TAG = "Demo";
	private static final int OKCANCEL_REQUEST_CODE = 0;
	private static final int COUNTER_REQUEST_CODE = 1;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setContentView(R.layout.main);
        
        String[] rowNames = { "AboutActivity", "finish()", "OKCancelActivity", "CounterActivity" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
        					android.R.layout.simple_list_item_1, rowNames);
        setListAdapter(adapter);
        
        Log.i(TAG, "onCreate");
    }
	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}
    
    @Override
    protected void onListItemClick(ListView l, View view, int position, long id) {
//    	TextView textView = (TextView) view;
//    	String msg = "position: " + position + "\n" + textView.getText();
//    	Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    	
    	Intent intent;
    	switch (position) {
		case 0:
			intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			break;
		case 1:
			finish();
			break;
		case 2:
			intent = new Intent(this, OKCancelActivity.class);
			startActivityForResult(intent, OKCANCEL_REQUEST_CODE);
			break;
		case 3:
			intent = new Intent(this, CounterActivity.class);
			intent.putExtra(CounterActivity.KEY_COUNT, 123);
			startActivityForResult(intent, COUNTER_REQUEST_CODE);
			break;
		}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == OKCANCEL_REQUEST_CODE) {
    		if (resultCode == RESULT_OK) {
    			Toast.makeText(this, "RESULT_OK", Toast.LENGTH_LONG).show();
    			return;
    		}
    		else if (resultCode == RESULT_CANCELED) {
    			Toast.makeText(this, "RESULT_CANCELED", Toast.LENGTH_LONG).show();
    			return;
    		}
    	}
    	if (requestCode == COUNTER_REQUEST_CODE) {
    		if (resultCode == RESULT_OK) {
    			int count = data.getIntExtra(CounterActivity.KEY_COUNT, 0);
    			Toast.makeText(this, "Count = " + count, Toast.LENGTH_LONG).show();
    			return;
    		}
    	}
    	super.onActivityResult(requestCode, resultCode, data);
    }
    
}