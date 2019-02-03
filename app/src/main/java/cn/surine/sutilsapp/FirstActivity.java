package cn.surine.sutilsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.surine.sutils.Logs;
import cn.surine.sutils.NetWorks;
import cn.surine.sutils.SharedPres;
import cn.surine.sutils.StatusBars;
import cn.surine.sutils.Toasts;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.button10)
    Button button10;
    @BindView(R.id.button11)
    Button button11;
    @BindView(R.id.button12)
    Button button12;
    @BindView(R.id.button13)
    Button button13;
    @BindView(R.id.button14)
    Button button14;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        mContext = this;
    }

    @OnClick({R.id.button9, R.id.button10,
            R.id.button11, R.id.button12,
            R.id.button13,R.id.button14})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button9:
                Toasts.shortShow("短暂显示");
                break;
            case R.id.button10:
                SharedPres.setData("test", "测试数据");
                Toasts.shortShow(String.valueOf(SharedPres.getData("test", "没有数据")));
                break;
            case R.id.button11:
                Logs.d("日志消息");
                Toasts.shortShow("请查看控制台");
                break;
            case R.id.button12:
                boolean a = NetWorks.isWifiConnected();
                Toasts.shortShow(String.valueOf(a));
                break;
            case R.id.button13:
                startActivity(new Intent(mContext, MainActivity.class));
                break;
            case R.id.button14:
                StatusBars.setStatusBarUI(FirstActivity.this,true);
                break;
        }
    }
}
