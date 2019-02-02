package cn.surine.sutils;

import android.util.Log;

/**
 * Created by Surine on 2019/2/2.
 * 日志工具
 * v1.0.0 ：新建工具
 *          Add. 设置日志开关，设置标识符
 *          Add. Debug/Warn/Info/Error/Verbose对应重载
 */

public class Logs {
    private static String mTag = "测试";
    private static boolean isOpen = true;

    /**
     * 设置日志开关
     * @param a true为开，false为关
     * */
    public static void setOpen(boolean a){
        isOpen = a;
    }

    /**
     * 设置专属tag
     * @param tag tag 默认为mTag默认值，可以不用设置
     * */
    public static void setTag(String tag){
        mTag = tag;
    }


    /**
     * debug
     * @param tag TAG
     * @param msg MSG
     * */
    public static void d(String tag,String msg){
        if(isOpen)
            Log.d(tag,msg);
    }

    /**
     * Debug
     * @param msg 日志信息
     * */
    public static void d(String msg){
        d(mTag,msg);
    }


    /**
     * error
     * @param tag tag
     * @param msg msg
     * */
    public static void e(String tag,String msg){
        if(isOpen)
            Log.e(tag,msg);
    }

    /**
     * error
     * @param msg msg
     * */
    public static void e(String msg){
        e(mTag,msg);
    }

    /**
     * verbose
     * @param tag tag
     * @param msg msg
     * */
    public static void v(String tag,String msg){
        if(isOpen)
            Log.v(tag,msg);
    }

    /**
     * verbose
     * @param msg msg
     * */
    public static void v(String msg){
        v(mTag,msg);
    }


    /**
     * info
     * @param tag tag
     * @param msg msg
     * */
    public static void i(String tag,String msg){
        if(isOpen)
            Log.i(tag,msg);
    }

    /**
     * info
     * @param msg msg
     * */
    public static void i(String msg){
        i(mTag,msg);
    }

    /**
     * warn
     * @param tag tag
     * @param msg msg
     * */
    public static void w(String tag,String msg){
        if(isOpen)
            Log.w(tag,msg);
    }


    /**
     * warn
     * @param msg msg
     * */
    public static void w(String msg){
        w(mTag,msg);
    }


}
