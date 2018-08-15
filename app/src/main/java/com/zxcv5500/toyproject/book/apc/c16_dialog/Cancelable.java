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

public class Cancelable extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
	    new AlertDialog.Builder(this)
			    .setTitle("공지 사항")
			    .setMessage("이 메세지는 반드시 읽어야 합니다.")
			    .setIcon(R.drawable.androboy)
			    .setCancelable(false)
			    .setNegativeButton("닫기", null)
			    .show();

	}
}
