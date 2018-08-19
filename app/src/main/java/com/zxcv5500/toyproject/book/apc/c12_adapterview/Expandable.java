package com.zxcv5500.toyproject.book.apc.c12_adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.zxcv5500.toyproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expandable extends Activity {
	ExpandableListView mList;
	String[] arProvince = new String[] {
			"충청도", "경기도", "강원도"
	};
	String[][] arCity = new String[][] {
			{"논산", "당진", "부여"},
			{"수원", "용인"},
			{"춘천","원주","홍천","강릉"},
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expandable);

		mList = (ExpandableListView) findViewById(R.id.list);
		List<Map<String, String>> provinceData = new ArrayList<Map<String, String>>();
		List<List<Map<String, String>>> cityData =
				new ArrayList<List<Map<String, String>>>();
		for (int i = 0; i < arProvince.length; i++) {
			Map<String, String> province = new HashMap<String, String>();
			province.put("prov", arProvince[i]);
			provinceData.add(province);

			List<Map<String, String>> children = new ArrayList<Map<String, String>>();
			for (int j = 0; j < arCity[i].length; j++) {
				Map<String, String> city = new HashMap<String, String>();
				city.put("city", arCity[i][j]);
				children.add(city);
			}

			cityData.add(children);
		}

		ExpandableListAdapter adapter = new SimpleExpandableListAdapter(
				this,
				provinceData,
				android.R.layout.simple_expandable_list_item_1,
				new String[] {"prov"},
				new int[] { android.R.id.text1},
				cityData,
				android.R.layout.simple_expandable_list_item_1,
				new String[] {"city"},
				new int[] {android.R.id.text1
				}
				);
		mList.setAdapter(adapter);
	}
}
