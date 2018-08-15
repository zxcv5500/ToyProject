package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-15.
 */

public class DialogButton extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}
	
	public void mOnClick(View v) {
	    //*//
		new AlertDialog.Builder(this)
			    .setTitle("알립니다.")
			    .setMessage("대화상자를 열었습니다.")
			    .setIcon(R.drawable.androboy)
				.setNegativeButton("부정적", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {

					}
				})
			    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialogInterface, int i) {

				    }
			    })
			    .show();
		//*/

	    /*//
	    new AlertDialog.Builder(this)
			    .setTitle("알립니다.")
			    .setMessage("대화상자를 열었습니다.")
			    .setIcon(R.drawable.androboy)
			    .setNegativeButton("닫기", new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialogInterface, int i) {

				    }
			    })
			    .show();
	    //*/

		/* null 리스너 작성
		new AlertDialog.Builder(this)
				.setTitle("알립니다.")
				.setMessage("대화상자를 열었습니다.")
				.setIcon(R.drawable.androboy)
				.setPositiveButton("닫기", null)
				.show();
		//*/
	}
}
