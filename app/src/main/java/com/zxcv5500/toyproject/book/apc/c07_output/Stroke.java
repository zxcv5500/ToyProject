package com.zxcv5500.toyproject.book.apc.c07_output;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class Stroke extends Activity {
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

			// 캡 모양 테스트
			pnt.setColor(Color.BLUE);
			pnt.setStrokeWidth(16);
			canvas.drawLine(50,30,240,30,pnt);
			pnt.setStrokeCap(Paint.Cap.ROUND);
			canvas.drawLine(50,60,240,60,pnt);
			pnt.setStrokeCap(Paint.Cap.SQUARE);
			canvas.drawLine(50,90,240,90,pnt);

			// 조인 모양 테스트
			pnt.setColor(Color.BLACK);
			pnt.setStrokeWidth(20);
			pnt.setStyle(Paint.Style.STROKE);
			pnt.setStrokeJoin(Paint.Join.MITER);
			canvas.drawRect(50,150,90,200,pnt);
			pnt.setStrokeJoin(Paint.Join.BEVEL);
			canvas.drawRect(120,150,160,200,pnt);
			pnt.setStrokeJoin(Paint.Join.ROUND);
			canvas.drawRect(190,150,230,200,pnt);
		}
	}
}
