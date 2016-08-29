package com.demo.android.d11phone;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class D11PhoneActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        String[] rowNames = { "Display Phone Dialer", "Display Phone Number in Dialer", "Make Phone Call" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rowNames);
        setListAdapter(adapter);
        
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	Intent intent;
    	switch (position) {
		case 0:
			intent = new Intent();
			intent.setAction(Intent.ACTION_DIAL);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent();
			intent.setAction(Intent.ACTION_DIAL);
			Uri data = Uri.parse("tel:1-800-123-4567");
			intent.setData(data);
			startActivity(intent);
			break;
		case 2:
			intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1-800-123-4567"));
			startActivity(intent);
			break;
		}
    }
}