package cn.surine.sutils;

import android.content.Context;

import static cn.surine.sutils.SutilsConstant.CONTEXT_IS_NULL;
import static cn.surine.sutils.SutilsConstant.SUTILS_ERROR;

/**
 * Created by Surine on 2019/2/1.
 * 工具集合管理
 */

public class UtilsManager {

    /*toast工具类*/
    public static final int TOASTS = 1;
    /*存储工具类*/
    public static final int SHAREDPRES = 2;
    /*Log工具类*/
    public static final int LOGS = 3;
    /*网络工具类*/
    public static final int NETWORKS = 4;
    /*时间工具类*/
    public static final int TIMES = 5;
    /*状态栏工具类*/
    public static final int STATUSBARS = 6;
    /*震动工具类*/
    public static final int VIBRATES = 7;


    /**
     * 加载上下文
     * @param context 上下文
     * */
    public static void initContext(Context context) {
        SharedPres.setContext(context);
        Toasts.setContext(context);
        NetWorks.setContext(context);
        Vibrates.setContext(context);
    }


    /**
     * 是否打开日志
     * @param isOpen 开发环境可以不设置，生产环境设置为false
     * */
    public static void initLogUtil(boolean isOpen){
         Logs.setOpen(isOpen);
    }


    /**
     * 参数检查
     * @param context 上下文
     * */
    public static void check(Context context) {
        if(context == null){
            throw new IllegalArgumentException(SUTILS_ERROR+CONTEXT_IS_NULL);
        }
    }
}
