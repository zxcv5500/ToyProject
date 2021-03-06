package com.zxcv5500.toyproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zxcv5500.toyproject.book.adltb.AdltbExam;
import com.zxcv5500.toyproject.book.apc.ApcExam;
import com.zxcv5500.toyproject.book.ka.KaExam;

public class MainActivity extends Activity {


    private TextView tvbookAPC;
    private TextView tvKA;
    private TextView tvAdltb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvbookAPC = findViewById(R.id.bookAPC);
        tvKA = findViewById(R.id.bookKA);
        tvAdltb = findViewById(R.id.bookAdltb);

        tvbookAPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ApcExam.class));
            }
        });
        tvKA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KaExam.class));
            }
        });
        tvAdltb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdltbExam.class));
            }
        });

//        tvKA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Lab28_2Activity.class));
//            }
//        });
    }
}
