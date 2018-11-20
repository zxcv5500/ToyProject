package com.zxcv5500.toyproject.book.adltb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;
import com.zxcv5500.toyproject.book.adltb.ch05.DataBindingSampleActivity;

import java.util.ArrayList;

public class AdltbExam extends Activity {

    static final int SETTING_ACTIVITY = 1;
    // 예제가 있는 시작 챕터. 스피너의 첨자에 이 값을 더해야 장 번호가 된다.
    static final int START_CHAPTER = 1;

    class AdltbExample {
        AdltbExample(Class<?> acls, String aDesc) {
            cls = acls;
            Name = cls.getSimpleName();
            Desc = aDesc;
        }
        Class<?> cls;
        String Name;
        String Desc;
    }

    ArrayList<AdltbExample> arAdltbExample = new ArrayList<AdltbExample>();

    // 요청한 장의 예제들을 배열에 채운다.
    void fillExample(int chapter) {
        arAdltbExample.clear();      // 채우기 전에 arrayList를 깨끗하게 청소한다.

        switch (chapter) {
            case 1:     // 안드로이드 스튜디오 기능

                break;
            case 2:     // 컴포넌트 복습 ①: 액티비티와 프래그먼트 기초

                break;
            case 3:     // Content Provider / Broadcastcast Receiver / Service

                break;
            case 4:     // 지원라이브러리 / RecyclerView

                break;
            case 5:     // mvp / mvvm
                arAdltbExample.add(new AdltbExample(DataBindingSampleActivity.class, "데이터바인딩 샘플"));
                break;
            case 6:     // gradle

                break;
            case 7:     // 테스트

                break;
            case 8:     // UI 테스트
                break;
            case 9:     // CI
                break;
            case 10:    // 디자인
                break;
            case 11:    // 머터리얼 디자인 이해
                break;
            case 12:    // 머터리얼 디자인 구현
                break;
            case 13:    // 안드로이드 보안 모델
                break;
            case 14:    // 병목 개선
                break;
            case 15:    // 모네타이즈 실현(광고) 인앱결제
                break;
            case 16:    // 지문 인증

                break;
            case 17:    // 앱의 장점을 전하자. 앱 공개
                break;
            case 18:    // 공개한 앱을 성장 시킨다. 그로스 핵
                break;
            case 19:    // 푸시 알림gcm
                break;
        }
    }

    // 예제는 2장부터 제공된다. 2(START_CHAPTER)장이 첨자 0번이다.
    String[] arAdltbChapter = {
            "1장 안드로이드 스튜디오 기능",
            "2장 컴포넌트 복습 ①: 액티비티와 프래그먼트 기초",
            "3장 Content Provider / Broadcastcast Receiver / Service",
            "4장 지원라이브러리 / RecyclerView",
            "5장 mvp / mvvm",
            "6장 gradle",
            "7장 테스트",
            "8장 UI 테스트",
            "9장 디자인",
            "10장 머터리얼 디자인 이해",
            "11장 머터리얼 디자인 구현",
            "12장 안드로이드 보안 모델",
            "13장 병목 개선",
            "14장 모네타이즈 실현(광고) 인앱결제",
            "15장 지문 인증",
            "16장 앱의 장점을 전하자. 앱 공개",
            "17장 공개한 앱을 성장 시킨다. 그로스 핵",
            "18장 푸시 알림gcm",
    };

    LinearLayout mLinearLayout;
    ArrayAdapter<CharSequence> mAdapter;
    ListView mExamList;
    Spinner mSpinner;
    boolean mInitSelection = true;
    int mFontSize;
    int mBackType;
    boolean mDescSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andexam);

        mLinearLayout = findViewById(R.id.book);
        mLinearLayout.setBackgroundResource(R.color.colorAccent);
        mExamList = (ListView)findViewById(R.id.examlist);
        mSpinner = (Spinner)findViewById(R.id.spinnerchapter);
        mSpinner.setPrompt("장을 선택하세요.");

        mAdapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, arAdltbChapter);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 최초 전개시에도 Selected가 호출되는데 이때는 프레퍼런스에서 최후 장을 찾아 로드한다.
                // 이후부터는 사용자가 선택한 장을 로드한다.
                if (mInitSelection) {
                    mInitSelection = false;
                    SharedPreferences pref = getSharedPreferences("AdltbExam", 0);
                    int lastchapter = pref.getInt("LastAdltbChapter", START_CHAPTER);
                    mSpinner.setSelection(lastchapter - START_CHAPTER);
                    changeChapter(lastchapter);
                } else {
                    // 장을 변경할 때마다 프레퍼런스에 기록한다.
                    int chapter = position + START_CHAPTER;
                    changeChapter(chapter);
                    SharedPreferences pref = getSharedPreferences("AdltbExam", 0);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putInt("LastAdltbChapter", chapter);
                    edit.commit();
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        readOption();

    }

    public void readOption() {
        SharedPreferences pref = getSharedPreferences("AdltbExam", 0);
        mFontSize = pref.getInt("mFontSize", 1);
        mBackType = pref.getInt("mBackType", 0);
        mDescSide = pref.getBoolean("mDescSide", false);

        if (mBackType != 0) {
            mExamList.setBackgroundColor(0xff101010);
            mExamList.setDivider(new ColorDrawable(0xff606060));
            mExamList.setDividerHeight(1);
        } else {
            mExamList.setBackgroundColor(0xffe0e0e0);
            mExamList.setDivider(new ColorDrawable(0xff404040));
            mExamList.setDividerHeight(1);
        }
    }

    // 장을 변경한다. 인수로 전달되는 chapter는 첨자가 아니라 장 번호이다.
    public void changeChapter(int chapter) {
        fillExample(chapter);
        ExamListAdapter adapter = new ExamListAdapter(this);
        mExamList.setAdapter(adapter);

        final Context ctx = this;
        mExamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences pref = getSharedPreferences("AdltbExam", 0);
                SharedPreferences.Editor edit = pref.edit();
                edit.putInt("LastAdltbPosition", position);
                edit.commit();
                Intent intent = new Intent(ctx, arAdltbExample.get(position).cls);
                startActivity(intent);
            }
        });
    }

    public void mOnClick(View v) {
        SharedPreferences pref = getSharedPreferences("AdltbExam", 0);
        int lastchapter = pref.getInt("LastAdltbChapter", START_CHAPTER);
        switch (v.getId()) {
            case R.id.btnprev:
                if (lastchapter !=  START_CHAPTER) {
                    lastchapter--;
                    mSpinner.setSelection(lastchapter - START_CHAPTER);
                }
                break;
            case R.id.btnnext:
                if (lastchapter != arAdltbChapter.length - 1 + START_CHAPTER) {
                    lastchapter++;
                    mSpinner.setSelection(lastchapter - START_CHAPTER);
                }
                break;
        }
    }


    //어댑터 클래스
    class ExamListAdapter extends BaseAdapter {
        Context maincon;
        LayoutInflater Inflater;

        public ExamListAdapter(Context context) {
            maincon = context;
            Inflater = (LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
            return arAdltbExample.size();
        }

        public String getItem(int position) {
            return arAdltbExample.get(position).Name;
        }

        public long getItemId(int position) {
            return position;
        }

        // 각 항목의 뷰 생성
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = Inflater.inflate(R.layout.andexamlist, parent, false);
            }

            LinearLayout examlayout = (LinearLayout)convertView.findViewById(R.id.examlayout);
            TextView txt1 = (TextView)convertView.findViewById(R.id.text1);
            TextView txt2 = (TextView)convertView.findViewById(R.id.text2);

            if (mDescSide) {
                examlayout.setOrientation(LinearLayout.HORIZONTAL);
            }

            if (mBackType != 0) {
                examlayout.setBackgroundResource(R.drawable.exambackdark);
                txt1.setTextColor(Color.WHITE);
                txt2.setTextColor(Color.LTGRAY);
            }

            switch (mFontSize) {
                case 0:
                    txt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
                    txt2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 9);
                    break;
                case 1:
                    txt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    txt2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
                    break;
                case 2:
                    txt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                    txt2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                    break;
            }

            txt1.setText(arAdltbExample.get(position).Name);
            txt2.setText(arAdltbExample.get(position).Desc);

            return convertView;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0,1,0,"소개");
        menu.add(0,2,0,"옵션");
        menu.add(0,3,0,"종료");

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                new AlertDialog.Builder(this)
                        .setTitle("프로그램 소개")
                        .setMessage("안드로이드 개발 레벨업 교과서(책)의 예제 모음 프로그램입니다.\n" +
                                "상단의 스피너에서 패키지를 선택하고 목록에서 예제를 선택하십시오.")
                        .setIcon(R.drawable.andexam)
                        .setPositiveButton("닫기", null)
                        .show();
                return true;
            case 2:
                //startActivityForResult(new Intent(this, KaExamSetting.class), SETTING_ACTIVITY);
                return true;
            case 3:
                finish();
                System.exit(0);
                return true;
        }
        return false;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SETTING_ACTIVITY:
                if (resultCode != RESULT_OK) return;
                readOption();
                SharedPreferences pref = getSharedPreferences("AdltbExam", 0);
                int lastchapter = pref.getInt("LastAdltbChapter", START_CHAPTER);
                changeChapter(lastchapter);
                break;
        }
    }
}
