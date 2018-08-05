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

public class AntiAlias extends Activity {
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
			// TODO: 2018. 8. 5. 아래 주석처리된 세줄도 회색으로 색상 지정하는 코드다
//			canvas.drawARGB(255, 204, 204, 204);
//			canvas.drawRGB(204, 204, 204);
//			canvas.drawColor(0xffcccccc);
			canvas.drawColor(Color.LTGRAY);
			Paint pnt = new Paint();
			pnt.setColor(Color.BLACK);
			pnt.setTextSize(60);

			// 기본 출력
			canvas.drawOval(new RectF(10, 10, 200, 120), pnt);
			canvas.drawText("Text", 210, 70, pnt);

			// 안티 알리아스 적용
			pnt.setAntiAlias(true);
			canvas.drawOval(new RectF(10, 130, 200, 240), pnt);
			canvas.drawText("Text", 210, 190, pnt);
		}
	}
}
