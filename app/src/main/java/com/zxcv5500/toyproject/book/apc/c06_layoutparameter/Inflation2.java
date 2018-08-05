package com.zxcv5500.toyproject.book.apc.c06_layoutparameter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Inflation2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setBackgroundColor(Color.LTGRAY);


		TextView text = new TextView(this);
		text.setText("TextView");
		text.setGravity(Gravity.CENTER);
		text.setTextColor(Color.RED);
		text.setTextSize(20);

		linear.addView(text);
		setContentView(linear);
	}
}
