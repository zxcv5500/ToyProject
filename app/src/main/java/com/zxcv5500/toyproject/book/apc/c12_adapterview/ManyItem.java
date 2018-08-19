package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zxcv5500.toyproject.R;

import java.util.zip.Inflater;

/**
 * Created by zxcv5500 on 2018-08-19.
 */
public class ManyItem extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);

		((ListView) findViewById(R.id.list)).setAdapter(new ManyAdapter(this));
	}
}

class ManyAdapter extends BaseAdapter {
	Context maincon;
	LayoutInflater inflater;
	Toast mToast;

	public ManyAdapter(Context context) {
		this.maincon = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return 1000;
	}

	@Override
	public Object getItem(int position) {
		return "" + position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 각 항목의 뷰 생성
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String log = "position = " + position + ", ";
		if (convertView == null) {
			convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
			log += "convertView is null";
		} else {
			log += "convertView is not null";
		}
		Log.d("ManyItem", log);

		if (mToast == null) {
			mToast = Toast.makeText(maincon, log, 0);
		} else {
			mToast.setText(log);
		}
		mToast.show();

		TextView txt = (TextView) convertView.findViewById(android.R.id.text1);
		txt.setText("ManyItem ListView : " + position);
		return convertView;
	}
}
