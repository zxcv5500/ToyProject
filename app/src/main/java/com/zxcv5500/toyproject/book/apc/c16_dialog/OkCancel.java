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

public class OkCancel extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
	    new AlertDialog.Builder(this)
			    .setTitle("질문")
			    .setMessage("김상형군에게 100만원을 기부하시겠습니까?")
			    .setIcon(R.drawable.androboy)
			    .setNegativeButton("확인", null)
			    .setPositiveButton("취소", null)
			    .show();
	}
}
