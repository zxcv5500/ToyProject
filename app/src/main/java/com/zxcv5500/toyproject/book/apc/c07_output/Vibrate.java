package com.zxcv5500.toyproject.book.apc.c07_output;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import com.zxcv5500.toyproject.R;

public class Vibrate extends Activity {
	Vibrator mVib;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vibrate);

		mVib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mVib.cancel();
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
			case R.id.btnvibrate1:
				mVib.vibrate(500);
				break;
			case R.id.btnvibrate2:
				mVib.vibrate(new long[] {100, 50, 200, 50}, 0);
				break;
			case R.id.btnvibratestop:
				mVib.cancel();
				break;
		}
	}
}
