package com.zxcv5500.toyproject.book.apc.c07_output;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zxcv5500.toyproject.R;

public class DrawBitmap extends Activity {
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

			//* 원론적인 방법
			Resources res = getResources();
			BitmapDrawable bd = (BitmapDrawable)res.getDrawable(R.drawable.harubang);
			Bitmap bit = bd.getBitmap();
			//*/

			// 간단한 방법
			//Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.harubang);

			canvas.drawBitmap(bit, 10, 10, null);
			canvas.drawBitmap(bit, null, new Rect(120, 10, 170, 85), null);
			canvas.drawBitmap(bit, new Rect(30,30,70,80),
					new Rect(180,10,180+80,10+100), null);

		}
	}
}
