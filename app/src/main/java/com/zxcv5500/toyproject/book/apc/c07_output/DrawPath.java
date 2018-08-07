package com.zxcv5500.toyproject.book.apc.c07_output;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class DrawPath extends Activity {
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
			Path path = new Path();

			Paint Pnt = new Paint();
			Pnt.setStrokeWidth(5);
			Pnt.setColor(Color.RED);
			Pnt.setStyle(Paint.Style.STROKE);

			// 원, 사각형을 패스로 정의한 후 출력
			path.addCircle(50, 50, 40, Path.Direction.CW);
			path.addRect(100,10,150,90,Path.Direction.CW);
			canvas.drawPath(path, Pnt);

			// 직선 곡선을 패스로 정의한 후 출력
			path.reset();
			path.moveTo(10, 110);
			path.lineTo(50, 150);
			path.rLineTo(50, -30);
			path.quadTo(120, 170, 200, 110);
			Pnt.setStrokeWidth(3);
			Pnt.setColor(Color.BLUE);
			canvas.drawPath(path, Pnt);

			// 곡선 패스 출력
			path.reset();
			path.moveTo(10, 220);
			path.cubicTo(80, 150, 150, 220, 220, 180);
			Pnt.setStrokeWidth(2);
			Pnt.setColor(Color.BLACK);
			canvas.drawPath(path, Pnt);

			// 곡선 패스 위에 텍스트 출력
			Pnt.setTextSize(20);
			Pnt.setStyle(Paint.Style.FILL);
			Pnt.setAntiAlias(true);
			canvas.drawTextOnPath("Curved Text on Path.", path, 0, 0, Pnt);

		}
	}
}
