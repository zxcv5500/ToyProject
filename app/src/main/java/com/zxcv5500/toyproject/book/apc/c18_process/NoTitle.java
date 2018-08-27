package com.zxcv5500.toyproject.book.apc.c18_process;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.zxcv5500.toyproject.R;

public class NoTitle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Window win = getWindow();
		win.requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.notitle);
	}
}
