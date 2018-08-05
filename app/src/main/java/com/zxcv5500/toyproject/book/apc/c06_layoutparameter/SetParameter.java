package com.zxcv5500.toyproject.book.apc.c06_layoutparameter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zxcv5500.toyproject.R;

public class SetParameter extends Activity {
	Button mLeft;
	Button mRight;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setparameter);

		mLeft = (Button) findViewById(R.id.btnleft);
		mRight = (Button) findViewById(R.id.btnright);

		mLeft.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				setParam(3, 1);
			}
		});

		mRight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				setParam(1, 3);
			}
		});
	}

	public void setParam(int left, int right) {
		LinearLayout.LayoutParams lparam =
				(LinearLayout.LayoutParams) mLeft.getLayoutParams();
		lparam.weight = left;
		mLeft.setLayoutParams(lparam);

		LinearLayout.LayoutParams rparam = (LinearLayout.LayoutParams) mRight.getLayoutParams();
		rparam.weight = right;
		mRight.setLayoutParams(rparam);
	}
}
