package com.zxcv5500.toyproject.book.apc.c16_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-16.
 */

public class OrderDialog extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
	    final LinearLayout linear = (LinearLayout) View.inflate(this, R.layout.order, null);

	    new AlertDialog.Builder(this)
			    .setTitle("주문 정보를 입력하시오.")
			    .setIcon(R.drawable.androboy)
			    .setView(linear)
			    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialogInterface, int whichButton) {
					    EditText product = linear.findViewById(R.id.product);
					    EditText number = linear.findViewById(R.id.number);
					    CheckBox paymethod = linear.findViewById(R.id.paymethod);
					    TextView text = findViewById(R.id.text);
					    text.setText("주문 정보 " + product.getText() + " 상품 " +
					    number.getText() + "개." + (paymethod.isChecked() ? "착불결제" : ""));
				    }
			    })
			    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialogInterface, int i) {
					    TextView text = findViewById(R.id.text);
					    text.setText("주문을 취소했습니다.");
				    }
			    })
			    .show();
	}
}
