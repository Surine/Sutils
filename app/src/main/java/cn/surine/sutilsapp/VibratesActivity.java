package cn.surine.sutilsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.surine.sutils.Toasts;
import cn.surine.sutils.Vibrates;

public class VibratesActivity extends AppCompatActivity {

    @BindView(R.id.button16)
    Button button16;
    @BindView(R.id.button17)
    Button button17;
    @BindView(R.id.button18)
    Button button18;
    @BindView(R.id.button19)
    Button button19;
    @BindView(R.id.button20)
    Button button20;
    @BindView(R.id.button21)
    Button button21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrates);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button16, R.id.button17, R.id.button18, R.id.button19, R.id.button20, R.id.button21})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button16:
                Toasts.shortShow(Vibrates.hasVibrator()+"");
                break;
            case R.id.button17:
                Vibrates.startVibrate(2000);
                break;
            case R.id.button18:
                long[] pattern = {100,200,100,200,100,200};
                Vibrates.startVibrate(pattern,0);
                break;
            case R.id.button19:
                Vibrates.startVibrate(2000,1);
                break;
            case R.id.button20:
                long[] pattern2 = {1,3,1,2,1,2};
                int[] pattern3 = {1,2,2,2,1,0};
                Vibrates.startVibrateWave(pattern2,pattern3,0);
                break;
            case R.id.button21:
                Vibrates.stopVibrate();
                break;
        }
    }
}
