package com.zxcv5500.toyproject.book.apc.c06_layoutparameter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.zxcv5500.toyproject.R;

public class Inflation3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.inflation);      // 대신 아래처럼 사용할수도 있다.

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		LinearLayout linear = (LinearLayout) inflater.inflate(R.layout.inflation, null);
		setContentView(linear);
	}
}
