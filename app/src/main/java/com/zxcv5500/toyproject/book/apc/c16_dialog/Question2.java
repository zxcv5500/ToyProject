package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-15.
 */

public class Question2 extends Activity {
	int a = 3;
	int b = 4;
	int result;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
	    new AlertDialog.Builder(this)
			    .setTitle("질문")
			    .setMessage("어떤 연산을 하시겠습니까?")
			    .setPositiveButton("덧셈", mClick)
			    .setNegativeButton("곱셈", mClick)
			    .show();
	}

	DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialogInterface, int whichButton) {
			if (whichButton == DialogInterface.BUTTON_POSITIVE) {
				result = a + b;
			} else {
				result = a * b;
			}
			TextView text = (TextView) findViewById(R.id.text);
			text.setText("연산 결과 = " + result);
			Toast.makeText(Question2.this, "연산을 완료하였습니다.", Toast.LENGTH_SHORT).show();
		}
	};
}
