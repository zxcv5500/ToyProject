package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zxcv5500.toyproject.R;

import java.util.Calendar;

public class ShowDialog extends Activity {

	static final int SampleDialog = 0;
	static final int QuestionDialog = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showdialog);

		Button btn = (Button) findViewById(R.id.call);
		btn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				showDialog(SampleDialog);
			}
		});
		Button btn2 = (Button) findViewById(R.id.call2);
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showDialog(QuestionDialog);
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
			case SampleDialog:
				return new AlertDialog.Builder(ShowDialog.this)
						.setTitle("알립니다.")
						.setMessage("대화상자를 열었습니다.")
						.setIcon(R.drawable.androboy)
						.setPositiveButton("닫기", null)
						.create();
			case QuestionDialog:
				return new AlertDialog.Builder(ShowDialog.this)
						.setTitle("질문")
						.setMessage("밥 먹었어요?")
						.setPositiveButton("먹었다", null)
						.setNegativeButton("굶었다", null)
						.create();
		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
			case SampleDialog:
				break;
			case QuestionDialog:
				Calendar calendar = Calendar.getInstance();
				String stime = String.format("%d %d분 %d초",
						calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
				dialog.setTitle(stime);
				break;
		}
	}
}
