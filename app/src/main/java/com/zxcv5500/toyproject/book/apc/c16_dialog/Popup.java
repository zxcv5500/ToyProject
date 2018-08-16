package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-16.
 */

public class Popup extends Activity {
	PopupWindow popupWindow;
	View popupview;
	LinearLayout linear;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup);

		linear = findViewById(R.id.linear);
		popupview = View.inflate(this, R.layout.popupview, null);
		popupWindow = new PopupWindow(popupview, 400, 300, true);

		final Button btnshow = findViewById(R.id.btnshow);
		btnshow.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				// 지정한 좌표에 놓기
				//popupWindow.showAtLocation(linear, Gravity.NO_GRAVITY, 100, 150);
				// 가운데 놓기
				//popupWindow.showAtLocation(linear, Gravity.CENTER, 0, 0);
				// 가운데 + 50, 80에 놓기
				//popupWindow.showAtLocation(linear,Gravity.CENTER,50,80);
				// 화면 벗어나기
				//popupWindow.showAtLocation(linear,Gravity.NO_GRAVITY,800,1200);
				// 수평 중앙, 수직 바닥
				//popupWindow.showAtLocation(linear,Gravity.CENTER_HORIZONTAL| Gravity.BOTTOM,0,0);
				// 수평 중앙, 수직 바닥 + (50,50)
				//popupWindow.showAtLocation(linear,Gravity.CENTER_HORIZONTAL|
				//		Gravity.BOTTOM,50,50);
				// 버튼 아래에 놓기
				popupWindow.setAnimationStyle(-1);
				popupWindow.showAsDropDown(btnshow);

			}
		});

		Button btnclose = (Button) popupview.findViewById(R.id.btnclose);
		btnclose.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				popupWindow.dismiss();
			}
		});
	}


}
