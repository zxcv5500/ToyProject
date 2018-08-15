package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-15.
 */

public class TouchOutside extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
		AlertDialog dialog = new AlertDialog.Builder(this)
				.setTitle("알림")
				.setMessage("대화상자 바깥을 누르면 닫힙니다.")
				.setIcon(R.drawable.androboy)
				.setNegativeButton("닫기", null)
				.create();

		dialog.setCanceledOnTouchOutside(true);
//		dialog.setCancelable(false);        // 이거 추가하면 터치 아웃사이드 안먹히네?
		dialog.show();
	}
}
