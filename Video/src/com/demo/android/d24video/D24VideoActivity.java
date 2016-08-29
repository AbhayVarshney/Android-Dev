package com.demo.android.d24video;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class D24VideoActivity extends Activity {

	private static final int MY_VIEO_REQUEST_CODE = 0;
	
	VideoView videoView;
	Uri videoUri;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        videoView = (VideoView) findViewById(R.id.videoView1);
    }
    
    public void doVideoRecord(View view) {
    	Intent intent = new Intent();
    	intent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
    	startActivityForResult(intent, MY_VIEO_REQUEST_CODE);
    }
    
    public void doVideoPlay(View view) {
    	if (videoUri == null) {
			new AlertDialog.Builder(this).setTitle("No video available").setPositiveButton("OK", null).show();
			return;
		}
    	videoView.setVideoURI(videoUri);
    	videoView.start();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == MY_VIEO_REQUEST_CODE) {
			if (resultCode == RESULT_CANCELED)
				return;
			if (data == null)
				return;
			videoUri = data.getData();
			new AlertDialog.Builder(this).setMessage(videoUri.toString()).setPositiveButton("OK", null).show();
			return;
		}
    	super.onActivityResult(requestCode, resultCode, data);
    }
}