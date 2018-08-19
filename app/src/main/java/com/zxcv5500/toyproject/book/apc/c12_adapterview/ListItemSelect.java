package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-18.
 */
public class ListItemSelect extends Activity {
	String[] arGeneral = {"김유신", "이순신", "강감찬", "을지문덕"};
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);

		ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arGeneral);

		ListView listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(mItemClickListener);
	}

	AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
			String mes;
			mes = "Select Item = " + arGeneral[position];
			Toast.makeText(ListItemSelect.this, mes, Toast.LENGTH_SHORT).show();
		}
	};
}
