package com.zxcv5500.toyproject.book.apc.c06_layoutparameter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutParameter3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setGravity(Gravity.CENTER);
		linear.setBackgroundColor(Color.LTGRAY);

		TextView text = new TextView(this);
		text.setText("TextView");
		text.setTextColor(Color.RED);
		text.setTextSize(20);
		text.setBackgroundColor(Color.GREEN);

		LinearLayout.LayoutParams paramtext = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT
		);

		linear.addView(text, paramtext);

		setContentView(linear);
	}
}
