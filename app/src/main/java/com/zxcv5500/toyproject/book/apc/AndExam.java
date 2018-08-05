package com.zxcv5500.toyproject.book.apc;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.zxcv5500.toyproject.R;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.Inflation;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.Inflation2;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.Inflation3;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.Inflation4;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.Inflation5;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.LayoutParameter;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.LayoutParameter2;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.LayoutParameter3;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.MarginParameter;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.MarginParameter2;
import com.zxcv5500.toyproject.book.apc.c06_layoutparameter.SetParameter;
import com.zxcv5500.toyproject.book.apc.c21_actionbar.ActionBarTest;
import com.zxcv5500.toyproject.book.apc.c33_multimedia.AttachImage;
import com.zxcv5500.toyproject.book.apc.c33_multimedia.CameraTest;
import com.zxcv5500.toyproject.book.apc.c33_multimedia.SHCamera;
import com.zxcv5500.toyproject.book.apc.c07_output.CustomView;

import java.util.ArrayList;

public class AndExam extends Activity {

    static final int SETTING_ACTIVITY = 1;
    // 예제가 있는 시작 챕터. 스피너의 첨자에 이 값을 더해야 장 번호가 된다.
    static final int START_CHAPTER = 4;
    class Example {
        Example(Class<?> acls, String aDesc) {
            cls = acls;
            Name = cls.getSimpleName();
            Desc = aDesc;
        }
        Class<?> cls;
        String Name;
        String Desc;
    }

    ArrayList<Example> arExample = new ArrayList<Example>();

    // 요청한 장의 예제들을 배열에 채운다.
    void fillExample(int chapter) {
        arExample.clear();      // 채우기 전에 arrayList를 깨끗하게 청소한다.

        switch (chapter) {
            case 4: // 뷰
                break;
            case 5: // 레이아웃
                break;
            case 6: // 레이아웃 관리
                arExample.add(new Example(Inflation.class, "XML로 레이아웃 전개"));
                arExample.add(new Example(Inflation2.class, "코드로 레이아웃 생성"));
                arExample.add(new Example(Inflation3.class, "XML문서를 전개하여 배치"));
	            arExample.add(new Example(Inflation4.class, "텍스트 뷰만 전개하여 리니어에 추가하기"));
	            arExample.add(new Example(Inflation5.class, "실행중에 차일드 뷰 전개하여 추가하기"));
                arExample.add(new Example(LayoutParameter.class, "레이아웃 전개"));
                arExample.add(new Example(LayoutParameter2.class, "코드로 배치하면서 레이아웃 파라미터 생략"));
                arExample.add(new Example(LayoutParameter3.class, "코드로 배치하면서 레이아웃 파라미터 지정"));
                arExample.add(new Example(MarginParameter.class, "XML로 마진 주기"));
                arExample.add(new Example(MarginParameter2.class, "코드로 마진 주기"));
                arExample.add(new Example(SetParameter.class, "실행중에 레이아웃 파라미터 변경"));
//                arExample.add(new Example(GridHorz.class, "수평 그리드 레이아웃"));
//                arExample.add(new Example(GridVert.class, "수직 그리드 레이아웃"));
//                arExample.add(new Example(GridLinear.class, "일렬 그리드 레이아웃"));
//                arExample.add(new Example(CellSize.class, "셀 크기 지정"));
//                arExample.add(new Example(CellPosition.class, "셀 위치 지정"));
//                arExample.add(new Example(CellSpan.class, "셀 병합"));
//                arExample.add(new Example(TwoLine.class, "2열의 텍스트 뷰 배치"));
//                arExample.add(new Example(InputForm.class, "그리드를 이용한 입력 폼"));
                break;
            case 7: // 출력
                arExample.add(new Example(CustomView.class, "커스텀 뷰에 직접 그리기"));
//                arExample.add(new Example(Primitive1.class, "기본 도형-점,선,원,사각형,문자열"));
//                arExample.add(new Example(Primitive2.class, "기본 도형-둥근 사각형,타원,반원,다각선"));
//                arExample.add(new Example(AntiAlias.class, "안티 알리아싱 옵션"));
//                arExample.add(new Example(Stroke.class, "굵기, 끝장식, 조인 등 선의 속성"));
//                arExample.add(new Example(PaintStyle.class, "채움 및 외곽선 그리기 스타일"));
//                arExample.add(new Example(NewPaint.class, "Paint 객체 매번 생성하기"));
//                arExample.add(new Example(PrePaint.class, "Paint 객체를 미리 생성해 놓기"));
//                arExample.add(new Example(DrawBitmap.class, "비트맵 이미지 출력. 확대 및 일부 영역 출력"));
//                arExample.add(new Example(OffScreen.class, "메모리에서 비트맵 생성하기"));
//                arExample.add(new Example(DrawText.class, "텍스트 출력"));
//                arExample.add(new Example(TypeFace.class, "텍스트의 타입 페이스"));
//                arExample.add(new Example(CustomFont.class, "커스텀 폰트 사용하기"));
//                arExample.add(new Example(DrawPath.class, "패스 출력"));
//                arExample.add(new Example(LinearGrad.class, "직선 그래디언트"));
//                arExample.add(new Example(RadialGrad.class, "원형 그래디언트"));
//                arExample.add(new Example(SweepGrad.class, "원주 그래디언트"));
//                arExample.add(new Example(BitmapSdr.class, "비트맵 셰이더"));
//                arExample.add(new Example(ComposeSdr.class, "조합 셰이더"));
//                arExample.add(new Example(MirrorImage.class, "조합 셰이더를 이용한 반사 이미지"));
//                arExample.add(new Example(Shape.class, "셰이프 드로블 출력"));
//                arExample.add(new Example(ToastTest.class, "토스트 출력"));
//                arExample.add(new Example(Beep.class, "간단한 비프음"));
//                arExample.add(new Example(Vibrate.class, "폰 진동시키기"));
//                arExample.add(new Example(PermModel.class, "퍼미션 모델 테스트 예제. 별도 제공되는 예제 참조"));
                break;
            case 8: // 입력
                break;
            case 9: // 메뉴
                break;
            case 10: // 개발툴
                break;
            case 11: // 기본 위젯
                break;
            case 12: // 어댑터뷰
                break;
            case 13: // 고급 위젯
                break;
            case 14: // 커스텀 위젯
                break;
            case 15: // 리소스 관리
                break;
            case 16: // 대화상자
                break;
            case 17: // 액티비티
                break;
            case 18: // 프로세스
                break;
            case 19: // 쓰레드
                break;
            case 20: // 프래그먼트
                break;
            case 21: // 액션바
                arExample.add(new Example(ActionBarTest.class, "액션 바 테스트"));
                break;
            case 22: // 그리기
                break;
            case 23: // 애니메이션
                break;
            case 24: // 속성 애니메이션
                break;
            case 25: // 파일
                break;
            case 26: // CP
                break;
            case 27: // 클립보드
                break;
            case 28: // 네트워크
                break;
            case 29: // BR
                break;
            case 30: // 서비스
                break;
            case 31: // 제스쳐
                break;
            case 32: // 맵 서비스
                break;
            case 33: // 멀티미디어
                arExample.add(new Example(CameraTest.class, "촬영만 가능한 카메라 예제"));
                arExample.add(new Example(AttachImage.class, "카메라, 갤러리를 호출하여 첨부 이미지 얻기"));
                arExample.add(new Example(SHCamera.class, "카메라 advance 예제"));
                break;
            case 34: // 센서
                break;
            case 35: // 시스템 설정
                break;
            case 36: // 전화
                break;
            case 37: // 앱위젯
                break;

        }
    }


    // 예제는 4장부터 제공된다. 4(START_CHAPTER)장이 첨자 0번이다.
    String[] arChapter = {
            "4장 뷰",
            "5장 레이아웃",
            "6장 레이아웃 관리",
            "7장 출력",
            "8장 입력",
            "9장 메뉴",
            "10장 개발툴",
            "11장 기본 위젯",
            "12장 어댑터 뷰",
            "13장 고급 위젯",
            "14장 커스텀 위젯",
            "15장 리소스 관리",
            "16장 대화상자",
            "17장 액티비티",
            "18장 프로세스",
            "19장 스레드",
            "20장 프래그먼트",
            "21장 액션바",
            "22장 그리기",
            "23장 애니메이션",
            "24장 속성 애니메이션",
            "25장 파일",
            "26장 CP",
            "27장 클립보드",
            "28장 네트워크",
            "29장 BR",
            "30장 서비스",
            "31장 제스처",
            "32장 맵 서비스",
            "33장 멀티미디어",
            "34장 센서",
            "35장 시스템 설정",
            "36장 전화",
            "37장 앱위젯",
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
                android.R.layout.simple_spinner_item, arChapter);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 최초 전개시에도 Selected가 호출되는데 이때는 프레퍼런스에서 최후 장을 찾아 로드한다.
                // 이후부터는 사용자가 선택한 장을 로드한다.
                if (mInitSelection) {
                    mInitSelection = false;
                    SharedPreferences pref = getSharedPreferences("AndExam", 0);
                    int lastchapter = pref.getInt("LastChapter", START_CHAPTER);
                    mSpinner.setSelection(lastchapter - START_CHAPTER);
                    changeChapter(lastchapter);
                } else {
                    // 장을 변경할 때마다 프레퍼런스에 기록한다.
                    int chapter = position + START_CHAPTER;
                    changeChapter(chapter);
                    SharedPreferences pref = getSharedPreferences("AndExam", 0);
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
        SharedPreferences pref = getSharedPreferences("AndExam", 0);
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
        mExamList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences pref = getSharedPreferences("AndExam", 0);
                SharedPreferences.Editor edit = pref.edit();
                edit.putInt("LastPosition", position);
                edit.commit();
                Intent intent = new Intent(ctx, arExample.get(position).cls);
                startActivity(intent);
            }
        });
    }

    public void mOnClick(View v) {
        SharedPreferences pref = getSharedPreferences("AndExam", 0);
        int lastchapter = pref.getInt("LastChapter", START_CHAPTER);
        switch (v.getId()) {
            case R.id.btnprev:
                if (lastchapter !=  START_CHAPTER) {
                    lastchapter--;
                    mSpinner.setSelection(lastchapter - START_CHAPTER);
                }
                break;
            case R.id.btnnext:
                if (lastchapter != arChapter.length - 1 + START_CHAPTER) {
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
            return arExample.size();
        }

        public String getItem(int position) {
            return arExample.get(position).Name;
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

            txt1.setText(arExample.get(position).Name);
            txt2.setText(arExample.get(position).Desc);

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
                        .setMessage("안드로이드 프로그래밍 정복(한빛미디어)의 예제 모음 프로그램입니다.\n" +
                                "상단의 스피너에서 패키지를 선택하고 목록에서 예제를 선택하십시오.")
                        .setIcon(R.drawable.andexam)
                        .setPositiveButton("닫기", null)
                        .show();
                return true;
            case 2:
                startActivityForResult(new Intent(this, AndExamSetting.class), SETTING_ACTIVITY);
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
                SharedPreferences pref = getSharedPreferences("AndExam", 0);
                int lastchapter = pref.getInt("LastChapter", START_CHAPTER);
                changeChapter(lastchapter);
                break;
        }
    }
}
