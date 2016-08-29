package com.demo.android.d10externalfileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

public class D10ExternalFileIoActivity extends Activity {

	TextView textView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.textView1);
        
        StringBuilder sb = new StringBuilder("External Storage Results\n");
        
        String state = Environment.getExternalStorageState();
        sb.append("state: " + state + "\n"); // NOTE: At first it said "removed"
        
        if (Environment.MEDIA_MOUNTED.equals(state)) {
        	//TODO Access external media in read/write mode
        	sb.append("MEDIA_MOUNTED\n");
        	// Simple write to file on external storage
        	File fileDir = Environment.getExternalStorageDirectory();
        	File file = new File(fileDir, "demofile");

        	sb.append("fileDir: " + fileDir.getAbsolutePath() + "\n");
        	sb.append("file: " + file.getAbsolutePath() + "\n");
        	
        	try {
				FileOutputStream fos = new FileOutputStream(file);
				fos.write("Hello World".getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				//Toast.makeText(this, "FileNoteFoundException:\n" + e.getMessage(), Toast.LENGTH_LONG).show();
				new AlertDialog.Builder(this).setTitle("FileNotFoundException")
				.setMessage(e.getMessage()).setPositiveButton("OK", null).show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				Toast.makeText(this, "IOException:\n" + e.getMessage(), Toast.LENGTH_LONG).show();
			}
        	
        }
        else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
        	sb.append("MEDIA_MOUNTED_READ_ONLY\n");
        }
        else if (Environment.MEDIA_UNMOUNTED.equals(state)) {
        	sb.append("MEDIA_UNMOUNTED\n");
        }
        
        textView.setText(sb);
    }
}