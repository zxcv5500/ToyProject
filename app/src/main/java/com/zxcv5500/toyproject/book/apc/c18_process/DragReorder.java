package com.zxcv5500.toyproject.book.apc.c18_process;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.zxcv5500.toyproject.R;

import java.util.zip.Inflater;

public class DragReorder extends Activity {
	// 로그용 태그
	final static String TAG = "DragReorder";
	ReorderScrollView mScroll;
	LinearLayout mList;
	WindowManager mWindowManager;
	WindowManager.LayoutParams mParamsBar;
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

		String[] arTerm = new String[] {
				"00.입춘", "01.우수", "02.경칩", "03.춘분","04.청명", "05.곡우",
				"06.입하", "07.소만", "08.망종", "09.하지","10.소서", "11.대서",
				"12.입추", "13.처서", "14.백로", "15.추분","16.한로", "17.상강",
				"18.입동", "19.소설", "20.대설", "21.동지","22.소한", "23.대한"};
		mScroll = (ReorderScrollView) findViewById(R.id.scroll);
		mScroll.mParent = this;
		mList = findViewById(R.id.list);

		// 테스트 항목 삽입
		for (int i = 0; i < arTerm.length; i++) {
			LayoutInflater inflater = (LayoutInflater) getSystemService(
					Context.LAYOUT_INFLATER_SERVICE
			);
			LinearLayout item = (LinearLayout) inflater.inflate(R.layout.listitem, null);
			TextView title = (TextView) item.findViewById(R.id.title);
			title.setText(arTerm[i]);
			mList.addView(item);

			// 항목 클릭하면 텍스트만 읽어서 출력
			item.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					TextView title = v.findViewById(R.id.title);
					Toast.makeText(DragReorder.this, title.getText(), Toast.LENGTH_SHORT).show();
				}
			});

			// 클릭은 일단 날라옴. 드래그를 시작했으면 클릭 동작은 하지 않되
			// 이때 띡하는 소리를 어찌할 방법이 없다.
			ImageButton btn = item.findViewById(R.id.btnreorder);
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (mDragging == false) {
						Log.d(TAG, "onClick: ");
						mList.removeViewAt(mStartDragIdx);
					}
				}
			});
		}

		prepareDragReorder();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mWindowManager.removeView(mDragBar);
		mWindowManager.removeView(mDragImage);
	}

	/**
	 * 드래그 처리에 필요한 이미지 및 배치 파라미터 등을 생성해 둠.
	 */
	void prepareDragReorder() {
		mSlop = ViewConfiguration.get(this).getScaledTouchSlop();

		// 배치 파라미터 미리 생성해 둠
		mParamsBar = new WindowManager.LayoutParams();
		mParamsBar.gravity = Gravity.TOP;
		mParamsBar.x = 0;
		mParamsBar.y = 0;
		mParamsBar.height = DRAGBARTHICK;
		mParamsBar.width = WindowManager.LayoutParams.MATCH_PARENT;
		mParamsBar.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
				| WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		mParamsBar.format = PixelFormat.TRANSLUCENT;
		mParamsBar.windowAnimations = 0;

		// 드래그 바 생성해서 배치해 놓고 살짝 숨겨 놓음
		mDragBar = new ImageView(this);
		int backGroundColor = Color.parseColor("red");
		mDragBar.setBackgroundColor(backGroundColor);
		mDragBar.setVisibility(View.GONE);
		mWindowManager = (WindowManager) getSystemService("window");
		mWindowManager.addView(mDragBar, mParamsBar);

		// 드래그 이미지 생성해서 숨겨 둠
		mParamImage = new WindowManager.LayoutParams();
		mParamImage.copyFrom(mParamsBar);
		mParamImage.height = WindowManager.LayoutParams.WRAP_CONTENT;
		mParamImage.alpha = 0.5f;

		mDragImage = new ImageView(this);
		mDragImage.setVisibility(View.GONE);
		mWindowManager.addView(mDragImage, mParamImage);
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
