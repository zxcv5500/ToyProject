package com.zxcv5500.toyproject.book.apc.c06_layoutparameter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zxcv5500.toyproject.R;

public class Inflation5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inflation5);

		Button btn = (Button) findViewById(R.id.btnnewmessage);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				RelativeLayout rel = (RelativeLayout) View.inflate(Inflation5.this, R.layout.newmessage, null);

				LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
				if (linear.getChildCount() % 2 == 0) {
					rel.setBackgroundColor(Color.GRAY);
				} else {
					rel.setBackgroundColor(Color.RED);
				}
				linear.addView(rel);
			}
		});
	}
}
