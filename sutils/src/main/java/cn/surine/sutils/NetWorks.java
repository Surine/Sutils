package cn.surine.sutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static cn.surine.sutils.UtilsManager.check;

/**
 * Created by Surine on 2019/2/2.
 * 网络工具类
 * v1.0.0 ：新建版本
 *          Add. 设置上下文
 *          Add. 检查是否有网络连接
 *          Add. 是否wifi连接
 *          Add. 检查连接方式 两种
 */

public class NetWorks {

    private static Context mContext;

    //3种网络状态（wifi为1，数据流量为2，断网为3，其他为4）
    private static final int NETWORK_WIFI_CONNECTION = 1;
    private static final int NETWORK_MOBILE_CONNECTION = 2;
    private static final int NETWORK_DISCONNECTION = 3;
    private static final int NETWORK_OTHER_CONNECTION = 4;
    /**
     * 设置上下文
     * @param context 上下文
     * */
    public static void setContext(Context context){
        mContext = context;
    }

    /**
     * 网络是否连接
     * @param context 上下文
     * @return true if isconnected
     * */
    public static boolean isConnected(Context context){

        check(context);

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm != null){
            @SuppressLint("MissingPermission")
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if(networkInfo != null){
                return true;
            }
        }
        return false;
    }

    public static boolean isConnected(){
       return isConnected(mContext);
    }


    /**
     * 是否wifi连接
     * @param context 上下文
     * @return true if iswificonnected
     * */
    public static boolean isWifiConnected(Context context){

        check(context);

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null
                    && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWifiConnected(){
        return isWifiConnected(mContext);
    }


    /**
     * 检查连接状态
     * @param context 上下文
     * @return int {1:wifi 2: mobile,3:no connect,4:other}
     * */
    public static int getNetWorkStatus(Context context){

        check(context);

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            @SuppressLint("MissingPermission")
            NetworkInfo networkInfo = cm
                    .getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    return NETWORK_WIFI_CONNECTION;
                }else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    return NETWORK_MOBILE_CONNECTION;
                }else{
                    return NETWORK_OTHER_CONNECTION;
                }

            }
        }
        return NETWORK_DISCONNECTION;
    }

    public static int getNetWorkStatus(){
       return getNetWorkStatus(mContext);
    }


    /**
     * 检查连接方式
     * @param context 上下文
     * @return 网络状态，具体常量值请参考 ConnectivityManager 类 ，无网络的时候
     * 取值 ConnectivityManager.TYPE_NONE
     * */
    public static int getNetWorkStatusByAndroid(Context context){

        check(context);

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            @SuppressLint("MissingPermission")
            NetworkInfo networkInfo = cm
                    .getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return networkInfo.getType();
            }
        }
        return -1;
    }
    public static int getNetWorkStatusByAndroid(){
       return getNetWorkStatusByAndroid(mContext);
    }

}
