package com.zxcv5500.toyproject.book.apc.c07_output;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class CustomFont extends Activity {
	Typeface mFont;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView vm = new MyView(this);
		setContentView(vm);

		mFont = Typeface.createFromAsset(getAssets(), "balloons.ttf");
	}

	class MyView extends View {

		public MyView(Context context) {
			super(context);
		}

		@SuppressLint("DrawAllocation")
		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);
			Paint Pnt = new Paint();
			String str = "Custom Font Test";

			Pnt.setAntiAlias(true);
			Pnt.setTypeface(mFont);
			Pnt.setTextSize(30);
			canvas.drawText(str, 10, 40, Pnt);
		}
	}
}
