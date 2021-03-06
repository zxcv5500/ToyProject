package com.zxcv5500.toyproject.book.apc.c07_output;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class PrePaint extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView vm = new MyView(this);
		setContentView(vm);
	}

	class MyView extends View {
		Paint mPnt;
		public MyView(Context context) {
			super(context);

			mPnt = new Paint();
			mPnt.setAntiAlias(true);
			mPnt.setColor(Color.BLUE);
			mPnt.setStrokeWidth(10);
			mPnt.setStyle(Paint.Style.STROKE);
			mPnt.setStrokeJoin(Paint.Join.BEVEL);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);
			canvas.drawLine(50, 30, 240, 30, mPnt);

		}
	}
}
