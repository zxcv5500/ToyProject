package com.zxcv5500.toyproject.book.apc.c06_layoutparameter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;

public class Inflation4 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inflation);

		LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setBackgroundColor(Color.LTGRAY);

		TextView text = (TextView) View.inflate(this, R.layout.mytext, null);

		linear.addView(text);
		setContentView(linear);
	}
}
