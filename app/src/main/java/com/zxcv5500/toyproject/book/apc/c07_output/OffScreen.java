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

public class OffScreen extends Activity {
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
			Paint pnt = new Paint();

			Bitmap backBit = Bitmap.createBitmap(300, 200, Bitmap.Config.ARGB_8888);
			Canvas offScreen = new Canvas(backBit);
			offScreen.drawColor(Color.GREEN);
			pnt.setColor(Color.RED);
			for (int x = 0; x < 300; x+=10) {
				offScreen.drawLine(x, 0, 300 - x, 200, pnt);
			}

			canvas.drawBitmap(backBit, 10, 10, null);
		}
	}
}
