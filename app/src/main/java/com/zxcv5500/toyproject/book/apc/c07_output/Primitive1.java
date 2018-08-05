package com.zxcv5500.toyproject.book.apc.c07_output;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class Primitive1 extends Activity {
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
			Paint Pnt = new Paint();
			// 검은색 점
			canvas.drawPoint(10, 10, Pnt);
			// 파란색 선
			Pnt.setColor(Color.BLUE);
			canvas.drawLine(20, 10, 200, 50, Pnt);
			// 빨간색 원
			Pnt.setColor(Color.RED);
			canvas.drawCircle(100, 90, 50, Pnt);
			// 반투명한 파란색 사각형
			Pnt.setColor(0x800000ff);
			canvas.drawRect(10, 100, 200, 170, Pnt);
			// 검은색 문자열
			Pnt.setColor(Color.BLACK);
			canvas.drawText("Canvas Text Out", 10, 200, Pnt);
		}
	}
}
