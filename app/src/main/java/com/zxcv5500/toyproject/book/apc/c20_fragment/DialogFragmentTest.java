package com.zxcv5500.toyproject.book.apc.c20_fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxcv5500.toyproject.R;

/**
 * Created by zxcv5500 on 2018-08-16.
 */

public class DialogFragmentTest extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogfragmenttest);
	}

	public void mOnClick(View v) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tr = fm.beginTransaction();
		Fragment prev = fm.findFragmentByTag("dialog");
		if (prev != null) {
			tr.remove(prev);
		}
		NameGenderFragment dialog = new NameGenderFragment();
		dialog.show(tr, "dialog");
	}

	public static class NameGenderFragment extends DialogFragment {
		//* 레이아웃 전개해서 리턴

		@Nullable
		@Override
		public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
			View root = inflater.inflate(R.layout.namegenderfragment, container, false);
			return root;

		}

		/* Dialog 객체 생성해서 리턴
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			Dialog dialog = new Dialog(getActivity());
			dialog.setContentView(R.layout.namegenderfragment);

			return dialog;
		}
		//*/
	}
}
