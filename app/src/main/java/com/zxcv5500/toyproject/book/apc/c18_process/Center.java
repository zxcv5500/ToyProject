package com.zxcv5500.toyproject.book.apc.c18_process;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;

import com.zxcv5500.toyproject.R;

/**
 * Created by skchoi on 2018-08-27.
 */
public class Center extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Window win = getWindow();
		win.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		win.setGravity(Gravity.CENTER);

		setContentView(R.layout.center);

	}
}
