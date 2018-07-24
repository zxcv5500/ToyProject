package com.zxcv5500.toyproject.book.apc.c33_multimedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.zxcv5500.toyproject.R;

import java.io.File;

public class AttachImage extends Activity {
    static final int CALL_CAMERA = 0;
    static final int CALL_CAMERA2 = 1;
    static final int CALL_GALLERY = 2;
    ImageView mImage;
    String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attachimage);

        mImage = findViewById(R.id.attachimage);
        mPath = Environment.getExternalStorageDirectory().getAbsolutePath();        // 저장소 경로를 얻는다.

    }

    public void mOnClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btncamera:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CALL_CAMERA);
                break;

            case R.id.btncamera2:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(mPath)));
                startActivityForResult(intent, CALL_CAMERA2);
                break;

            case R.id.btngallery:
                intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, CALL_GALLERY);
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (resultCode) {
                case CALL_CAMERA:
                    mImage.setImageBitmap((Bitmap) data.getExtras().get("data"));
                    break;
                case CALL_CAMERA2:
                    mImage.setImageBitmap(BitmapFactory.decodeFile(mPath));
                    break;
                case  CALL_GALLERY:
                    try {
                        mImage.setImageBitmap(MediaStore.Images.Media.getBitmap(
                                getContentResolver(), data.getData()));
                    } catch (Exception e) { ; }
                    break;
            }
        }
    }
}
