package com.zxcv5500.toyproject.book.ka;

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

import java.util.ArrayList;

public class KaExam extends Activity {

    static final int SETTING_ACTIVITY = 1;
    // 예제가 있는 시작 챕터. 스피너의 첨자에 이 값을 더해야 장 번호가 된다.
    static final int START_CHAPTER = 2;

    class KaExample {
        KaExample(Class<?> acls, String aDesc) {
            cls = acls;
            Name = cls.getSimpleName();
            Desc = aDesc;
        }
        Class<?> cls;
        String Name;
        String Desc;
    }

    ArrayList<KaExample> arKaExample = new ArrayList<KaExample>();

    // 요청한 장의 예제들을 배열에 채운다.
    void fillExample(int chapter) {
        arKaExample.clear();      // 채우기 전에 arrayList를 깨끗하게 청소한다.

        switch (chapter) {
            case 2: // 안드로이드 프로젝트 이해

                break;
            case 3: // 사용자 인터페이스

                break;
            case 4: // 레이아웃을 활용한 다양한 뷰 배치

                break;
            case 5: // 다양한 사용자 알림 효과
                break;
            case 6: // 사용자 이벤트 처리

                break;
            case 7: // 리소스 활용 및 스마트폰 크기 호환성

                break;
            case 8: // DBMS을 이용한 데이터 영속화
                break;
            case 9: // 파일 및 SharedPreferences을 이용한 데이터 영속화
                break;
            case 10: // AdapterView 활용
                break;
            case 11: // 다양한 뷰 활용
                break;
            case 12: // ActionBar와 메뉴

                break;
            case 13: // 커스텀 뷰 개발
                break;
            case 14: // 인텐트와 구글 기본 앱 연동
                break;
            case 15: // 액티비티 생명주기 및 다양한 제어
                break;
            case 16: // 스레드와 핸들러

                break;
            case 17: // Support 라이브러리 활용
                break;
            case 18: // 머티리얼 디자인
                break;
            case 19: // 브로드캐스트 리시버와 알림
                break;
            case 20: // 서비스 컴포넌트
                break;
            case 21: // 콘텐츠 프로바이더
                break;
            case 22: // 위치 정보 획득
                break;
            case 23: // 지도 출력
                break;
            case 24: // 네트워크 정보 활용
                break;
            case 25: // HTTP 통신
                break;
            case 26: // 실시간 서버 푸시
                break;
            case 27: // 스마트폰 기능 활용
                break;
            case 28: // 카메라 활용
                break;
            case 29: // 앱 위젯 개발
                break;
            case 30: // 멀티미디어 활용
                break;
            case 31: // 안드로이드 스튜디오에서 코틀린으로 개발하기
                break;
            case 32: // 코틀린 기초 작성법
                break;
            case 33: // 코틀린 OOP 프로그램

                break;
            case 34: // 코틀린으로 만드는 안드로이드 앱
                break;
        }
    }

    // 예제는 2장부터 제공된다. 2(START_CHAPTER)장이 첨자 0번이다.
    String[] arKaChapter = {
            "2장 안드로이드 프로젝트 이해",
            "3장 사용자 인터페이스이스",
            "4장 레이아웃을 활용한 다양한 뷰 배치",
            "5장 다양한 사용자 알림 효과",
            "6장 사용자 이벤트 처리",
            "7장 리소스 활용 및 스마트폰 크기 호환성",
            "8장 DBMS을 이용한 데이터 영속화",
            "9장 파일 및 SharedPreferences을 이용한 데이터 영속화",
            "10장 AdapterView 활용",
            "11장 다양한 뷰 활용",
            "12장 ActionBar와 메뉴",
            "13장 커스텀 뷰 개발",
            "14장 인텐트와 구글 기본 앱 연동",
            "15장 액티비티 생명주기 및 다양한 제어",
            "16장 스레드와 핸들러",
            "17장 Support 라이브러리 활용",
            "18장 머티리얼 디자인",
            "19장 브로드캐스트 리시버와 알림",
            "20장 서비스 컴포넌트",
            "21장 콘텐츠 프로바이더",
            "22장 위치 정보 획득",
            "23장 지도 출력",
            "24장 네트워크 정보 활용",
            "25장 HTTP 통신",
            "26장 실시간 서버 푸시",
            "27장 스마트폰 기능 활용",
            "28장 카메라 활용",
            "29장 앱 위젯 개발",
            "30장 멀티미디어 활용",
            "31장 안드로이드 스튜디오에서 코틀린으로 개발하기",
            "32장 코틀린 기초 작성법",
            "33장 코틀린 OOP 프로그램",
            "34장 코틀린으로 만드는 안드로이드 앱",
    };

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

        mExamList = (ListView)findViewById(R.id.examlist);
        mSpinner = (Spinner)findViewById(R.id.spinnerchapter);
        mSpinner.setPrompt("장을 선택하세요.");

        mAdapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, arKaChapter);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 최초 전개시에도 Selected가 호출되는데 이때는 프레퍼런스에서 최후 장을 찾아 로드한다.
                // 이후부터는 사용자가 선택한 장을 로드한다.
                if (mInitSelection) {
                    mInitSelection = false;
                    SharedPreferences pref = getSharedPreferences("KaExam", 0);
                    int lastchapter = pref.getInt("LastChapter", START_CHAPTER);
                    mSpinner.setSelection(lastchapter - START_CHAPTER);
                    changeChapter(lastchapter);
                } else {
                    // 장을 변경할 때마다 프레퍼런스에 기록한다.
                    int chapter = position + START_CHAPTER;
                    changeChapter(chapter);
                    SharedPreferences pref = getSharedPreferences("KaExam", 0);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putInt("LastChapter", chapter);
                    edit.commit();
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        readOption();

    }

    public void readOption() {
        SharedPreferences pref = getSharedPreferences("KaExam", 0);
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
                SharedPreferences pref = getSharedPreferences("KaExam", 0);
                SharedPreferences.Editor edit = pref.edit();
                edit.putInt("LastPosition", position);
                edit.commit();
                Intent intent = new Intent(ctx, arKaExample.get(position).cls);
                startActivity(intent);
            }
        });
    }

    public void mOnClick(View v) {
        SharedPreferences pref = getSharedPreferences("KaExam", 0);
        int lastchapter = pref.getInt("LastChapter", START_CHAPTER);
        switch (v.getId()) {
            case R.id.btnprev:
                if (lastchapter !=  START_CHAPTER) {
                    lastchapter--;
                    mSpinner.setSelection(lastchapter - START_CHAPTER);
                }
                break;
            case R.id.btnnext:
                if (lastchapter != arKaChapter.length - 1 + START_CHAPTER) {
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
            return arKaExample.size();
        }

        public String getItem(int position) {
            return arKaExample.get(position).Name;
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

            txt1.setText(arKaExample.get(position).Name);
            txt2.setText(arKaExample.get(position).Desc);

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
                        .setMessage("깡샘의 안드로이드(책)의 예제 모음 프로그램입니다.\n" +
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
                SharedPreferences pref = getSharedPreferences("KaExam", 0);
                int lastchapter = pref.getInt("LastChapter", START_CHAPTER);
                changeChapter(lastchapter);
                break;
        }
    }
}
