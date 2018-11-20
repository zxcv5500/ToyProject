package com.zxcv5500.toyproject.book.adltb.ch05.databindingsample;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

public class User {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableInt age = new ObservableInt();
    public ObservableInt likes = new ObservableInt();

    public User(String nameString, int ageInt) {
        name.set(nameString);
        age.set(ageInt);
        likes.set(0);
    }

    public void onClickLike(View view) {
        likes.set(likes.get() + 1);
    }
}
