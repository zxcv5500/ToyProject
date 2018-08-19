package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.zxcv5500.toyproject.R;

import java.util.ArrayList;

public class ListAddDel extends Activity {
	ArrayList<String> items;
	ArrayAdapter<String> adapter;
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listadddel);

		items = new ArrayList<String>();
		items.add("First");
		items.add("Second");
		items.add("Third");

		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);
		list = findViewById(R.id.list);
		list.setAdapter(adapter);
		list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
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
				int pos;
				pos = list.getCheckedItemPosition();
				if (pos != ListView.INVALID_POSITION) {
					items.remove(pos);
					list.clearChoices();
					adapter.notifyDataSetChanged();
				}
				break;
		}
	}
}
