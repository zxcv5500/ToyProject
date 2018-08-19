package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.zxcv5500.toyproject.R;

import java.util.ArrayList;

/**
 * Created by zxcv5500 on 2018-08-19.
 */
public class ListAddDelMulti extends Activity {
	ArrayList<String> items;
	ArrayAdapter<String> adapter;
	ListView list;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listadddel);

		items = new ArrayList<String>();
		items.add("First");
		items.add("Second");
		items.add("Third");
		items.add("Fourth");

		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items);
		list = findViewById(R.id.list);
		list.setAdapter(adapter);
		list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}

	public void mOnClick(View v) {
		EditText ed = findViewById(R.id.newitem);
		switch (v.getId()) {
			case R.id.add:
				String text = ed.getText().toString();
				if (text.length() != 0) {
					items.add(text);
					ed.setText("");
					adapter.notifyDataSetChanged();
				}
				break;
			case R.id.delete:
				SparseBooleanArray sb = list.getCheckedItemPositions();
				if (sb.size() != 0) {
					for (int i = list.getCount(); i >= 0 ; i--) {
						if (sb.get(i)) {
							items.remove(i);
						}
					}
					list.clearChoices();
					adapter.notifyDataSetChanged();
				}
				break;
		}
	}
}
