package com.demo.android.d09internalfileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class D09InternalFileIoActivity extends Activity {
 
	private static final String FILENAME = "myfile.txt";
	
	TextView textView;
	EditText editText;
	
	public void doDeleteFile(View view) {
		deleteFile(FILENAME);
	}
	
	public void doSave(View view) {
		if (editText.getText().toString().length() == 0) {
			new AlertDialog.Builder(this).setTitle("No text entered").setIcon(android.R.drawable.ic_dialog_alert)
			.setPositiveButton(android.R.string.ok, null)
			.show();
			return;
		}
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write(editText.getText().toString().getBytes());
			fos.close();
			editText.setText("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doLoad(View view) {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			String msg = new String(buffer);
			editText.setText(msg);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doFileList(View view) {
		if (fileList().length == 0) {
			textView.setText("No files in list");
		}
		else {
			StringBuilder sb = new StringBuilder("List of files\n");
			for (String s : fileList()) {
				sb.append(s + "\n");
			}
			textView.setText(sb);
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.textView1);
        editText = (EditText) findViewById(R.id.editText1);
        
        // Demo 1 - Read res/raw/readme.txt
        StringBuilder sb = new StringBuilder("Results of reading res/raw/readme\n");
        InputStream is = getResources().openRawResource(R.raw.readme);
        try {
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			String msg = new String(buffer);
			sb.append(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			sb.append("Exception: " + e.getLocalizedMessage());
		}
		
		// Demo 2 - Read assets/anotherfile
		sb.append("\nResults of reading assets/anotherfile\n");
		AssetManager am = getAssets();
		try {
			is = am.open("anotherfile");
			byte[] buffer = new byte[is.available()];
			is.read(buffer);
			is.close();
			String msg = new String(buffer);
			sb.append(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			sb.append("Exception: " + e.getLocalizedMessage());
		}
		
        textView.setText(sb);
        
    }
}