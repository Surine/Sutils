package cn.surine.sutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import static android.content.Context.VIBRATOR_SERVICE;
import static cn.surine.sutils.UtilsManager.check;

/**
 * Created by Surine on 2019/2/9.
 * 参考 ：https://www.jianshu.com/p/38fde766cc03
 * 参考 ：https://developer.android.google.cn/reference/android/os/VibrationEffect
 * 震动管理类
 * v1.0.0 新建版本
 *        Add. 设置上下文
 *        Add. 开始震动等重载
 *        Add. 判断是否有振动器
 *        Add. 停止震动
 *        Add. 波形震动等重载
 */

public class Vibrates {
      //全局上下文
      private static Context mContext;
      private static Vibrator vibrator;

     /**
      * 设置震动
      * @param context 上下文
      * @param milliseconds 震动时长
      * */
     @SuppressLint("MissingPermission")
     public static void startVibrate(Context context, long milliseconds){
         check(context);
         vibrator = (Vibrator)context.getSystemService(VIBRATOR_SERVICE);
         vibrator.vibrate(milliseconds);
     }

     /**
      * 设置上下文
      * @param context
      * */
     public static void setContext(Context context){
         mContext = context;
     }

     /**
      * 设置震动
      * @param milliseconds 震动时长
      * */
     public static void startVibrate(long milliseconds){
         startVibrate(mContext,milliseconds);
     }

     /**
      * 停止震动
      * */
     @SuppressLint("MissingPermission")
     public static void stopVibrate(){
          if(vibrator != null)
              vibrator.cancel();
     }


     /**
      * 开始震动
      * @param context 上下文
      * @param pattern 震动规则
      *                例如{100,200,300,400}表示震动100ms
      *                等待200ms，震动300ms，等待400ms，循环
      *                规则见repeat参数
      * @param repeat 重复 传入0就是从开头一直重复下去，
      *               传入-1就是不重复震动。
      *               传入其他数字，就是从index下标开始重复
      * */
     @SuppressLint("MissingPermission")
     public static void startVibrate(Context context, long[] pattern, int repeat){
         check(context);
         vibrator = (Vibrator)context.getSystemService(VIBRATOR_SERVICE);
         vibrator.vibrate(pattern,repeat);
     }

     /**
      * 是否有震动器
      * @param context 上下文
      * @return true有 false没有
      * */
     public static boolean hasVibrator(Context context){
         check(context);
         vibrator = (Vibrator)context.getSystemService(VIBRATOR_SERVICE);
         return vibrator.hasVibrator();
     }

     /**
      * 是否有振动器
      * */
     public static boolean hasVibrator(){
         return hasVibrator(mContext);
     }

     /**
      * 开始震动
      * @param pattern 规则
      * @param repeat 重复
      * */
     public static void startVibrate(long[] pattern, int repeat){
         startVibrate(mContext,pattern,repeat);
     }


     /**
      * API26  普通震动
      * @param context 上下文
      * @param milliseconds 震动时长
      * @param amplitude 振动强度,1到255之间的值，或者DEFAULT_AMPLITUDE
      * */
     @SuppressLint("MissingPermission")
     public static void startVibrate(Context context, long milliseconds, int amplitude){
         check(context);
         vibrator = (Vibrator)context.getSystemService(VIBRATOR_SERVICE);
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             vibrator.vibrate(VibrationEffect.createOneShot(milliseconds,amplitude));
         }
     }

     /**
      * API26 普通震动
      * */
     public static void startVibrate(long milliseconds, int amplitude){
         startVibrate(mContext,milliseconds,amplitude);
     }

     /**
      * API26 波形震动
      * @param context 上下文
      * @param timings 交替开关定时的模式，从关闭开始。0的定时值将导致定时/振幅对被忽略。
      * @param amplitudes 振幅值中的振幅值。振幅值必须为0和255之间，或为DEFAULT_AMPLITUDE。振幅值为0意味着断开。
      * @param repeat 振动重复的模式，如果您不想重复，则将索引放入计时数组中重复，或者-1。
      * */
     @SuppressLint("MissingPermission")
     public static void startVibrateWave(Context context, long[] timings, int[] amplitudes, int repeat){
         check(context);
         vibrator = (Vibrator)context.getSystemService(VIBRATOR_SERVICE);
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             vibrator.vibrate(VibrationEffect.createWaveform(timings,amplitudes,repeat));
         }
     }

     /**
      * API26 波形震动
      * */
     public static void startVibrateWave(long[] timings, int[] amplitudes, int repeat){
         startVibrateWave(mContext,timings,amplitudes,repeat);
     }

}
