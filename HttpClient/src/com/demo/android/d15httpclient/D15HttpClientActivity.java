package com.demo.android.d15httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class D15HttpClientActivity extends ListActivity {

	TextView textView;
	Thread thread;
	String textViewText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Demo 1 - Answer questions about ids
        int listViewId = android.R.id.list; // Java Syntax
        // XML Syntax  @android:id/list 
        int emptyTextViewId = android.R.id.empty; // Java Syntax
        // XML Syntax @android:id/empty
        
        // Demo 2 - HttpClient
        textView = (TextView) findViewById(R.id.textView1);
        
        
       // textView.setText("Http Transfer in progress...");
        // Start the thread to do the HTTP access
        // This thread runs separate and independent of the main GUI thread
      //  thread = new Thread(doHttpThread);
      //  thread.start();
    }
    
    public void doButton(View view) {
    	// TODO Read from editText...
    	textView.setText("Http Transfer in progress...");
    	thread = new Thread(doHttpThread);
    	thread.start();
    }
    
    // Assign this handler with the queue for the current thread
    // For example, in this case the current thread is the GUI Thread
    Handler handler = new Handler();
    
    Runnable updateGUI = new Runnable() {
    	public void run() {
    		textView.setText(textViewText);
    	}
    };
    
    Runnable doHttpThread = new Runnable() {
    	
    	public void run() {
        
    		HttpClient client = new DefaultHttpClient();
    		// GET /ConvertTemperature.asmx/ConvertTemp?Temperature=string&FromUnit=string&ToUnit=string HTTP/1.1
    		// Host: www.webservicex.net
    		String urlString = "http://" + "www.webservicex.net" + "/ConvertTemperature.asmx/ConvertTemp?" +
        					"Temperature=100" + "&FromUnit=degreeFahrenheit" + "&ToUnit=degreeCelsius";
    		HttpGet get = new HttpGet(urlString);
        
    		try {
    			// NOTE: This is a blocking call. Do not do this on a GUI thread
    			HttpResponse response = client.execute(get); // This causes network activity
    			int statusCode = response.getStatusLine().getStatusCode();
    			if (statusCode == 200) {
    				HttpEntity entity = response.getEntity();
    				String xml = EntityUtils.toString(entity);
    				// Broken Version: textView.setText(xml);
    				// Correct Version shown below:
    				textViewText = xml;
    				handler.post(updateGUI);
    			}
    			else {
    				// Brokenr Version: textView.setText("Http Tranfer failed: statusCode: " + statusCode);
    				textViewText = "Http Tranfer failed: statusCode: " + statusCode;
    				handler.post(updateGUI);
    			}
			
    		} catch (ClientProtocolException e) {
    			// TODO Auto-generated catch block
    			//e.printStackTrace();
    			//textView.setText("ClientProtocolException: " + e.getMessage());
				textViewText = "ClientProtocolException: " + e.getMessage();
				handler.post(updateGUI);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			//e.printStackTrace();
    			//textView.setText("IOException: " + e.getMessage());
				textViewText = "IOException: " + e.getMessage();
				handler.post(updateGUI);
    		}
    	}
    };
}