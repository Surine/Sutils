package cn.surine.sutilsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.surine.sutils.Times;

import static cn.surine.sutils.Times.E;
import static cn.surine.sutils.Times.HH;
import static cn.surine.sutils.Times.HHmmss;
import static cn.surine.sutils.Times.MM;
import static cn.surine.sutils.Times.compareDate;
import static cn.surine.sutils.Times.dd;
import static cn.surine.sutils.Times.getCurrentTime;
import static cn.surine.sutils.Times.getDateBeforeOrAfter;
import static cn.surine.sutils.Times.getDayChinese;
import static cn.surine.sutils.Times.getDayInt;
import static cn.surine.sutils.Times.getHour;
import static cn.surine.sutils.Times.getMinute;
import static cn.surine.sutils.Times.getMonthChinese;
import static cn.surine.sutils.Times.getMothInt;
import static cn.surine.sutils.Times.getSecond;
import static cn.surine.sutils.Times.getYearInt;
import static cn.surine.sutils.Times.locateTime2unix;
import static cn.surine.sutils.Times.mm;
import static cn.surine.sutils.Times.ss;
import static cn.surine.sutils.Times.unix2LocateTime;
import static cn.surine.sutils.Times.yyyy;
import static cn.surine.sutils.Times.yyyyMMdd;
import static cn.surine.sutils.Times.yyyyMMddHHmmss;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                textView.setText(getCurrentTime(E));
                break;
            case R.id.button2:
                textView.setText(getYearInt()+"/"+ getMothInt()+"/"+ getDayInt());
                break;
            case R.id.button3:
                textView.setText(getHour()+getMinute()+getSecond());
                break;
            case R.id.button4:
                textView.setText(unix2LocateTime(System.currentTimeMillis(),yyyyMMddHHmmss));
                break;
            case R.id.button5:
                textView.setText(locateTime2unix(getCurrentTime(),yyyyMMddHHmmss)+"");
                break;
            case R.id.button6:
                textView.setText(""+compareDate("2019-1-13 23:23:23","2019-1-13 23:23:23",yyyyMMdd));
                break;
            case R.id.button7:
                textView.setText(getMonthChinese(12)+getDayChinese(31));
                break;
            case R.id.button8:
                textView.setText(getDateBeforeOrAfter(getCurrentTime(),yyyyMMdd,2,false));
                break;
        }
    }
}
