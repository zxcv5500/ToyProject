package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-14.
 */

public class AlertDialogTest extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
		AlertDialog.Builder bld = new AlertDialog.Builder(this);
		bld.setTitle("알립니다.");
		bld.setMessage("대화상자를 열었습니다.");
		bld.setIcon(R.drawable.androboy);
		bld.show();
	}
}
