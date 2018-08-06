package com.zxcv5500.toyproject.book.apc.c07_output;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class DrawText extends Activity {
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
			canvas.drawColor(Color.LTGRAY);
			Paint Pnt = new Paint();
			String str = "Made in Korea";
			char[] arCh = {'a', 'b', 'c'};

			// 기본 문자열 출력. 안티 알리아싱을 적용했다.
			Pnt.setAntiAlias(true);
			Pnt.setColor(Color.BLACK);
			canvas.drawText(str, 10, 20, Pnt);
			canvas.drawText(str, 2, 11, 10, 40, Pnt);
			canvas.drawText(arCh, 0, 3, 10, 60, Pnt);

			// 수평 정렬
			Pnt.setTextAlign(Paint.Align.LEFT);
			canvas.drawText("Left Align", 100, 90, Pnt);
			Pnt.setTextAlign(Paint.Align.CENTER);
			canvas.drawText("Center Align", 100, 110, Pnt);
			Pnt.setTextAlign(Paint.Align.RIGHT);
			canvas.drawText("Right Align", 100, 130, Pnt);

			// 수직 정렬은 항상 글꼴의 베이스에 맞춰진다.
			Pnt.setTextAlign(Paint.Align.LEFT);
			Pnt.setColor(Color.RED);
			canvas.drawText("Small", 10, 180, Pnt);
			Pnt.setTextSize(20);
			canvas.drawText("Mid", 40, 180, Pnt);
			Pnt.setTextSize(30);
			canvas.drawText("Big", 80, 180, Pnt);
			Pnt.setTextSize(40);
			canvas.drawText("Hy", 125, 180, Pnt);


		}
	}
}
