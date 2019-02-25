package cn.surine.sutils;

import android.content.Context;
import android.widget.Toast;

import static cn.surine.sutils.UtilsManager.check;

/**
 * Created by Surine on 2019/2/1.
 * Toast简单工具
 * v1.0.0 ：新建版本
 *          Add. 设置上下文
 *          Add. 短暂显示/长时间显示对应重载
 */

public class Toasts {
    /*全局上下文*/
    private static Context mContext;

    /**
     * 设置全局上下文
     * @param context
     * */
    public static void setContext(Context context) {
        mContext = context;
    }

    /**
     * 短暂显示
     * @param context 上下文
     * @param msg 内容
     * */
    public static void shortShow(Context context,String msg){
        check(context);
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示
     * @param context 上下文
     * @param msg 内容
     * */
    public static void longShow(Context context,String msg){
        check(context);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 短时间显示
     * @param msg 内容
     * */
    public static void shortShow(String msg){
        shortShow(mContext,msg);
    }

    /**
     * 长时间显示
     * @param msg 内容
     * */
    public static void longShow(String msg){
        longShow(mContext,msg);
    }


}
