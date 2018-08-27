package com.zxcv5500.toyproject.book.apc.c18_process;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;

public class WindowManagerTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.windowmanagertest);

		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display dis = wm.getDefaultDisplay();
		TextView result = findViewById(R.id.result);
		Point pt = new Point();
		dis.getSize(pt);
		result.setText("width = " + pt.x + "\nheight = " + pt.y + "\nrotate = " + dis.getRotation()/*dis.getOrientation()*/);
		ImageView img = new ImageView(this);
		img.setImageResource(R.drawable.clover);
		WindowManager.LayoutParams param = new WindowManager.LayoutParams();
		param.gravity = Gravity.LEFT | Gravity.TOP;
		param.x = 100;
		param.y = 20;
		param.width = WindowManager.LayoutParams.WRAP_CONTENT;
		param.height = WindowManager.LayoutParams.WRAP_CONTENT;
		param.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		param.format = PixelFormat.TRANSLUCENT;

		wm.addView(img, param);
	}
}
