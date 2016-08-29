package com.demo.android.d23camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class D23CameraActivity extends Activity {
  
	private static final int MY_CAMERA_REQUEST_CODE = 0;
	
	ImageView imageView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageView = (ImageView) findViewById(R.id.imageView1);
    }
    
    public void doButton(View view) {
    	Intent intent = new Intent();
    	intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
    	startActivityForResult(intent, MY_CAMERA_REQUEST_CODE);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == MY_CAMERA_REQUEST_CODE) {
    		if (resultCode == RESULT_CANCELED)
    			return;
    		if (data == null)
    			return;
    		Bitmap bitmap = data.getParcelableExtra("data");
    		imageView.setImageBitmap(bitmap);
    	}
    	super.onActivityResult(requestCode, resultCode, data);
    }
}