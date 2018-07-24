package com.zxcv5500.toyproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zxcv5500.toyproject.book.apc.AndExam;

public class MainActivity extends AppCompatActivity {


    private TextView tvbookAPC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvbookAPC = findViewById(R.id.bookAPC);
        tvbookAPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AndExam.class));
            }
        });
    }
}
