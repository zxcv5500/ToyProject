package com.zxcv5500.toyproject.book.apc.c21_actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;

public class ActionBarTest extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		TextView text = new TextView(this);
		text.setText("액션바를 테스트합니다.");
		setContentView(text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actionbarmenu, menu);

		return true;
	}
}
