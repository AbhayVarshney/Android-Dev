package com.demo.android.d12emailandsms;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class D12EmailAndSmsActivity extends Activity implements OnItemClickListener  {

	GridView gridView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridView1);
        
        String[] items = { "Send Mail", "Send Text Messages" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
        						android.R.layout.simple_list_item_1, items);
        
        gridView.setNumColumns(2);
        gridView.setOnItemClickListener(this);
        gridView.setAdapter(adapter);
    }

	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		//Toast.makeText(this, "position: " + position, Toast.LENGTH_LONG).show();
		Intent intent;
		switch (position) {
		case 0:
			intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "norman.mcentire@servin.com" } );
			intent.putExtra(Intent.EXTRA_SUBJECT, "This is a test email from Android");
			intent.putExtra(Intent.EXTRA_TEXT, "This is the text of the email");
			startActivity(intent);
			break;
		case 1:
			intent = new Intent();
			intent.setAction(Intent.ACTION_SENDTO);
			intent.setData(Uri.parse("sms:1-234-567-8901"));
			intent.putExtra("sms_body", "This is a demo of text messaging");
			startActivity(intent);
			break;
		}
		
	}


}