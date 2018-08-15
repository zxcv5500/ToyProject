package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-16.
 */

public class SelectDialog3 extends Activity {
	boolean[] mSelect = { false, false, false, false };
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
	    new AlertDialog.Builder(this)
			    .setTitle("음식을 선택하시오.")
			    .setIcon(R.drawable.androboy)
			    .setMultiChoiceItems(R.array.foods, mSelect,
					    new DialogInterface.OnMultiChoiceClickListener() {
						    @Override
						    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
							    mSelect[which] = isChecked;
						    }
					    })
			    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialogInterface, int whichButton) {
					    String[] foods = getResources().getStringArray(R.array.foods);
					    TextView text = (TextView) findViewById(R.id.text);
					    String result = "선택한 음식 = ";
					    for (int i = 0; i < mSelect.length; i++) {
						    if (mSelect[i]) {
						    	result += foods[i] + " ";
						    }
					    }
					    text.setText(result);
				    }
			    })
			    .setNegativeButton("취소", null)
			    .show();
	}
}
