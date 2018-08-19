package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zxcv5500.toyproject.R;

import java.util.ArrayList;

/**
 * Created by zxcv5500 on 2018-08-19.
 */
public class ListIconText extends Activity {
	ArrayList<MyItem> arItem;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);

		arItem = new ArrayList<MyItem>();
		MyItem mi;
		mi = new MyItem(R.drawable.ic_launcher, "삼성 노트북"); arItem.add(mi);
		mi = new MyItem(R.drawable.ic_launcher, "LG 세탁기"); arItem.add(mi);
		mi = new MyItem(R.drawable.ic_launcher, "대우 마티즈"); arItem.add(mi);

		MyListAdapter myAdapter = new MyListAdapter(this, R.layout.icontext, arItem);

		ListView myListView;
		myListView = findViewById(R.id.list);
		myListView.setAdapter(myAdapter);



	}
}

// 리스트 뷰에 출력할 항목
class MyItem {
	int icon;
	String name;

	public MyItem(int argIcon, String argName) {
		icon = argIcon;
		name = argName;
	}
}

//어댑터 클래스
class MyListAdapter extends BaseAdapter {
	Context maincon;
	LayoutInflater inflater;
	ArrayList<MyItem> arSrc;
	int layout;

	public MyListAdapter(Context context, int aLayout, ArrayList<MyItem> aArSrc) {
		maincon = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		arSrc = aArSrc;
		layout = aLayout;
	}

	@Override
	public int getCount() {
		return arSrc.size();
	}

	@Override
	public Object getItem(int position) {
		return arSrc.get(position).name;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final int pos = position;
		if (convertView == null) {
			convertView = inflater.inflate(layout, parent, false);
		}

		ImageView img = convertView.findViewById(R.id.img);
		img.setImageResource(arSrc.get(position).icon);

		TextView txt = convertView.findViewById(R.id.text);
		txt.setText(arSrc.get(position).name);

		Button btn = convertView.findViewById(R.id.btn);
		btn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				String str = arSrc.get(pos).name + "를 주문합니다.";
				Toast.makeText(maincon, str, Toast.LENGTH_SHORT).show();
			}
		});


		return convertView;
	}
}
