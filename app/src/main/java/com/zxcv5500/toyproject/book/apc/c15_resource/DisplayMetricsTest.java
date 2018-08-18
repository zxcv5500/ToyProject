package com.zxcv5500.toyproject.book.apc.c15_resource;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;

public class DisplayMetricsTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displaymetricstest);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);

		String str = "widthPixels=" + dm.widthPixels +
				"\nheightPixels=" + dm.heightPixels +
				"\ndensityDpi=" + dm.densityDpi +
				"\ndensity=" + dm.density +
				"\nscaledDensity=" + dm.scaledDensity +
				"\nxdpi=" + dm.xdpi +
				"\nydpi=" + dm.ydpi;

		TextView info = (TextView)findViewById(R.id.result);
		info.setText(str);
	}
}
