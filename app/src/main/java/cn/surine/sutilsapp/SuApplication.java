package cn.surine.sutilsapp;

import android.app.Application;

import cn.surine.sutils.UtilsManager;

/**
 * Created by Surine on 2019/2/3.
 */

public class SuApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilsManager.initContext(getBaseContext());
    }
}
