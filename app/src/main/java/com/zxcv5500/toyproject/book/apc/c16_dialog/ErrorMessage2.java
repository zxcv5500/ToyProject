package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-15.
 */

public class ErrorMessage2 extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
	    // 어떤 작업을 수행한다.
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { ; }

		// 작업 중에 에러 발생했다고 가정
		boolean ErrorOccur = true;
		if (ErrorOccur) {
			new AlertDialog.Builder(this)
					.setTitle("에러 발생")
					.setMessage("어쩌고 저쩌고 이유로 작업을 계속할 수 없어 종료합니다.")
					.setPositiveButton("종료", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							finish();
						}
					})
					.show();
		} else {
			Toast.makeText(this, "작업이 무사히 끝났습니다.", Toast.LENGTH_SHORT).show();
		}
	}
}
