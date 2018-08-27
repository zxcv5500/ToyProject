package com.zxcv5500.toyproject.book.apc.c18_process;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.zxcv5500.toyproject.R;

public class DragReorder extends Activity {
	// 로그용 태그
	final static String TAG = "DragReorder";
	ReorderScrollView mScroll;
	LinearLayout mList;
	WindowManager mWindowManager;
	WindowManager.LayoutParams mParamBar;
	WindowManager.LayoutParams mParamImage;
	int mStartDragIdx;
	int mStartDragY;
	boolean mDragging;
	ImageView mDragBar;
	ImageView mDragImage;
	int mDragImageOffset;
	int mSlop;

	// 아래 위 변에서 이 범위안에 들어오면 스크롤한다.
	final static int SCRRANGE = 50;
	// 벗어난 정도에서 이 값을 나눈만큼 스크롤하여 속도를 느리게 한다.
	final static int SCRSPEEDDIV = 5;
	// 드래그 바의 폭
	final static int DRAGBARTHICK = 6;
	// 최대 스크롤 거리
	final static int MAXSCROLL = 20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dragreorder);
	}

	// 스크롤 뷰가 터치를 가로채서 전달한다.
	// 전달된 좌표는 스크롤 뷰 좌상단 기준 좌표이며 스크롤 상태와는 무관하다.
	public boolean onInterceptTouchEvent(ReorderScrollView scrview, MotionEvent event) {
		return true;
	}

}

class ReorderScrollView extends ScrollView {
	DragReorder mParent;

	public ReorderScrollView(Context context) {
		super(context);
	}

	public ReorderScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ReorderScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	// 좌표는 리스트뷰 좌상단 기준 좌표이며 스크롤 상태는 고려 안됨.
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (mParent.onInterceptTouchEvent(this, ev) == false) {
			return false;
		}
		boolean result = super.onInterceptTouchEvent(ev);
		Log.d(DragReorder.TAG, "onInterceptTouchEvent return " + result);
		return result;
	}
}
