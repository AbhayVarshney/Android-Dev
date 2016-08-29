package com.demo.android.d22audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class D22AudioActivity extends Activity {

	MediaPlayer mediaPlayer;
	
	public void doButton(View view) {
		Button button = (Button) view;
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
			button.setText("Play");
		} else {
			mediaPlayer.start();
			button.setText("Stop");
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if (mediaPlayer.isPlaying())
			mediaPlayer.pause();
	}
	@Override
	protected void onResume() {
		super.onResume();
		///TODO - Better logic - if (mediaPlayer.isPlaying())
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mediaPlayer = MediaPlayer.create(this, R.raw.test_cbr);
    }
}