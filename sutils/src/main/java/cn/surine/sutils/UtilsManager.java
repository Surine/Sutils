package cn.surine.sutils;

import android.content.Context;

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


    /**
     * 加载上下文
     * @param context 上下文
     * */
    public static void initContext(Context context) {
        SharedPres.setContext(context);
        Toasts.setContext(context);
        NetWorks.setContext(context);
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
            throw new IllegalArgumentException("Sutils : context is null,you should init this util in your application");
        }
    }
}
