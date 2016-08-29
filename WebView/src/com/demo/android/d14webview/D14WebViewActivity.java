package com.demo.android.d14webview;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class D14WebViewActivity extends ListActivity {

	WebView webView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        webView = (WebView) findViewById(R.id.webView1);
        
        String[] rowNames = { "WebView - loadData()", "WebView - File", "WebView - loadUrl", "WebView - Intent" };
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, rowNames);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, rowNames);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rowNames);
        setListAdapter(adapter);
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	switch (position) {
		case 0:
			String html = "<h1>Hello WebView</h1><p>This is fun</p>";
			webView.loadData(html, "text/html", "utf-8");
			break;
		case 1:
			webView.loadUrl("file:///android_asset/demo.html");
			break;
		case 2:
			webView.loadUrl("http://www.google.com");
			webView.requestFocus(View.FOCUS_DOWN);
			//webView.setFocusable(true);
			//webView.loadUrl("http://developer.android.com");
			break;
		case 3:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com")));
			break;
		}
    }
}