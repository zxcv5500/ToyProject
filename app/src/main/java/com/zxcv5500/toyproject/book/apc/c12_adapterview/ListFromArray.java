package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-18.
 */

public class ListFromArray extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);

		ArrayAdapter<CharSequence> adapter;
		adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_list_item_1);
		ListView list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);

	}
}
