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

public class TypeFace extends Activity {
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

		@SuppressLint("DrawAllocation")
		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);     // 회색 배경
			Paint Pnt = new Paint();
			int y = 1;
			Pnt.setAntiAlias(true);
			Pnt.setTextSize(30);
			Pnt.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
			canvas.drawText("Font:Default 0l", 10, y++ * 40, Pnt);
			Pnt.setTypeface(Typeface.create(Typeface.DEFAULT_BOLD, Typeface.NORMAL));
			canvas.drawText("Font:Default Bold 0l", 10, y++ * 40, Pnt);
			Pnt.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL));
			canvas.drawText("Font:Monospace 0l", 10, y++ * 40, Pnt);
			Pnt.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));
			canvas.drawText("Font:Sans Serif 0l", 10, y++ * 40, Pnt);
			Pnt.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL));
			canvas.drawText("Font:Serif 0l", 10, y++ * 40, Pnt);


		}
	}
}
