package com.zxcv5500.toyproject.book.apc.c07_output;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class NewPaint extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView vm = new MyView(this);
		setContentView(vm);
	}

	class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);
			Paint pnt = new Paint();
			pnt.setAntiAlias(true);
			pnt.setColor(Color.BLUE);
			pnt.setStrokeWidth(10);
			pnt.setStyle(Paint.Style.STROKE);
			pnt.setStrokeJoin(Paint.Join.BEVEL);
			canvas.drawRect(10, 10, 300, 100, pnt);
		}
	}
}
