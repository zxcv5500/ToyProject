package com.zxcv5500.toyproject.book.apc.c07_output;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zxcv5500.toyproject.R;

public class Beep extends Activity {
	SoundPool mPool;
	int mDdok;
	AudioManager mAm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.beep);

		mPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		mDdok = mPool.load(this, R.raw.ddok, 1);
		mAm = (AudioManager) getSystemService(AUDIO_SERVICE);

		findViewById(R.id.play1).setOnClickListener(mClickListener);
		findViewById(R.id.play2).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {

		@Override
		public void onClick(View view) {
			MediaPlayer player;
			switch (view.getId()) {
				case R.id.play1:
					mPool.play(mDdok, 1, 1, 0, 0, 1);
					break;
				case R.id.play2:
					mAm.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
					break;
			}
		}
	};
}
