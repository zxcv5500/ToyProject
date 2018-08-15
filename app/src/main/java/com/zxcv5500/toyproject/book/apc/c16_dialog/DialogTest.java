package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;

public class DialogTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
		Dialog dlg = new Dialog(this);
		TextView text = new TextView(this);
		text.setText("대화상자를 열었습니다.");
		dlg.setContentView(text);
		dlg.setTitle("알립니다.");
		dlg.show();
	}
}
