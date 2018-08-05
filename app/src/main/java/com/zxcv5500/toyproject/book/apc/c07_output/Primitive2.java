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

public class Primitive2 extends Activity {
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
			Paint pnt = new Paint();
			pnt.setColor(Color.LTGRAY);
			canvas.drawPaint(pnt);

			// 빨간 모서리 둥근 사각형
			RectF r = new RectF(10, 10, 100, 100);
			pnt.setColor(Color.RED);
			canvas.drawRoundRect(r, 10, 10, pnt);
			// 타원
			r.set(110, 10, 150, 100);
			canvas.drawOval(r, pnt);
			// 분홍색 반달
			pnt.setColor(Color.MAGENTA);
			r.set(10, 110, 100, 200);
			canvas.drawArc(r, 0, 180, false, pnt);
			// 분홍색 파이
			r.set(110, 110, 200, 200);
			canvas.drawArc(r, 0, 150, true, pnt);
			// 파란색 다각선
			pnt.setColor(Color.BLUE);
			float[] pts = {10, 210, 50, 250, 50, 250, 110, 220};
			canvas.drawLines(pts, pnt);

			// 검은색 점 3개
			pnt.setColor(Color.BLACK);
			float[] pts2 = {20, 210, 50, 240, 100, 220};
			canvas.drawPoints(pts2, pnt);


		}
	}
}
