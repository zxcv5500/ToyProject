package com.zxcv5500.toyproject.book.adltb.ch05.databindingsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;

import com.zxcv5500.toyproject.R;
import com.zxcv5500.toyproject.databinding.ActivityDataBindingSampleBinding;

import java.util.Calendar;


public class DataBindingSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Binding 오브젝트를 얻는다
        ActivityDataBindingSampleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_sample);
        // Binding 오브젝트에 User를 설정한다
        binding.setUser(new User("csk", 38));

        String date = (String) DateFormat.format("yyyy/MM/dd kk:mm:ss", Calendar.getInstance());
        binding.textTime.setText(date);
    }
}
