package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zxcv5500.toyproject.R;

import java.util.List;

/**
 * Created by zxcv5500 on 2018-08-18.
 */

public class ListAttr extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);

		ArrayAdapter<CharSequence> adapter;
		adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_list_item_1);

		ListView listView = findViewById(R.id.list);
		listView.setAdapter(adapter);

		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setDivider(new ColorDrawable(Color.YELLOW));
		listView.setDividerHeight(5);

	}
}
