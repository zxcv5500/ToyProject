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

public class Question3 extends Activity {
	int a;
	int b;
	int result;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
	    new AlertDialog.Builder(this)
			    .setTitle("질문")
			    .setMessage("좌변을 선택하십시오.")
			    .setPositiveButton("3", mClickLeft)
			    .setNegativeButton("4", mClickLeft)
			    .show();
	}

	DialogInterface.OnClickListener mClickLeft = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialogInterface, int whichButton) {
			if (whichButton == DialogInterface.BUTTON_POSITIVE) {
				a = 3;
			} else {
				b = 4;
			}

			new AlertDialog.Builder(Question3.this)
					.setTitle("질문")
					.setMessage("우변을 선택하십시오.")
					.setPositiveButton("5", mClickRight)
					.setNegativeButton("6", mClickRight)
					.show();
		}
	};

	DialogInterface.OnClickListener mClickRight = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
			if (whichButton == DialogInterface.BUTTON_POSITIVE) {
				b = 5;
			} else {
				b = 6;
			}
			new AlertDialog.Builder(Question3.this)
					.setTitle("질문")
					.setMessage("어떤 연산을 하시겠습니까?")
					.setPositiveButton("덧셈", mClickOperator)
					.setNegativeButton("곱셈", mClickOperator)
					.show();
		}
	};

	DialogInterface.OnClickListener mClickOperator = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
			if (whichButton == DialogInterface.BUTTON_POSITIVE) {
				result = a + b;
			} else {
				result = a * b;
			}
			TextView text = (TextView)findViewById(R.id.text);
			text.setText("연산 결과 = " + result);
			Toast.makeText(Question3.this, "연산을 완료하였습니다.",
					Toast.LENGTH_LONG).show();
		}
	};


}
