package cn.surine.sutils;

import android.content.Context;
import android.content.SharedPreferences;

import static cn.surine.sutils.UtilsManager.check;

/**
 * Created by Surine on 2019/2/1.
 * 数据储存工具类
 * v 1.0.0 ：新建简单版本
 *          Add. 设置上下文
 *          Add. 存/取数据
 *          Add. 是否包含某键
 *          Add. 清除全部数据
 *          Add. 清除某键值对
 * v 1.0.1 : 更新
 *          Mod. 修改默认文件名为私有
 */

public class SharedPres {
    /*默认文件名*/
    private static final String NORMAL_NAME = "data";
    /*上下文*/
    private static Context mContext;

    /**
     * 储存数据
     * @param context 上下文
     * @param key 键
     * @param value 值
     * */
    public static void setData(Context context,String key,Object value){

        check(context);

        SharedPreferences sharedPreferences = context.getSharedPreferences(NORMAL_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(value instanceof Integer){
            //int类型
            editor.putInt(key, (Integer) value);
        }else if(value instanceof String){
            //string类型
            editor.putString(key, (String) value);
        }else if(value instanceof Boolean){
            //bool类型
            editor.putBoolean(key, (Boolean) value);
        }else if (value instanceof Float){
            //float类型
            editor.putFloat(key, (Float) value);
        }else if(value instanceof Long){
            //long类型
            editor.putLong(key, (Long) value);
        }else{
            editor.putString(key,value.toString());
        }
        editor.apply();
    }



    /**
     * 储存数据
     * @param key 键
     * @param value 值
     * */
    public static void setData(String key,Object value){
        setData(mContext,key,value);
    }

    /**
     * 获取数据
     * @param context 上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 数据
    * */
    public static Object getData(Context context,String key,Object defaultValue){

        check(context);

        SharedPreferences sharedPreferences = context.getSharedPreferences(NORMAL_NAME,Context.MODE_PRIVATE);
        if(defaultValue instanceof Integer){
            //int类型
            return sharedPreferences.getInt(key, (Integer)defaultValue);
        }else if(defaultValue instanceof String){
            //string类型
            return sharedPreferences.getString(key, (String) defaultValue);
        }else if(defaultValue instanceof Boolean){
            //bool类型
            return sharedPreferences.getBoolean(key, (Boolean) defaultValue);
        }else if (defaultValue instanceof Float){
            //float类型
            return sharedPreferences.getFloat(key, (Float) defaultValue);
        }else if(defaultValue instanceof Long){
            //long类型
            return sharedPreferences.getLong(key, (Long) defaultValue);
        }else{
            return sharedPreferences.getString(key, (String) defaultValue);
        }
    }


    /**
     * 获取数据
     * @param key 键
     * @param defaultValue 默认值
     * @return 数据
     * */
    public static Object getData(String key,Object defaultValue){
       return getData(mContext,key,defaultValue);
    }



    /**
     * 是否包含某键
     * @param context 上下文
     * @param key 待查询键
     * @return true if find the key
     * */
    public static boolean findKey(Context context,String key){
        check(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(NORMAL_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    /**
     * 是否包含某键
     * @param key 待查询键
     * @return true if find the key
     * */
    public static boolean findKey(String key){
       return findKey(mContext,key);
    }


    /**
     * 清除全部数据
     * @param context 上下文
     * */
    public static void clearData(Context context){
        check(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(NORMAL_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 清除全部数据
     * */
    public static void clearData(){
        clearData(mContext);
    }

    /**
     * 清除某键值对
     * @param context 上下文
     * @param key 键
     * */
    public static void remove(Context context,String key){
        check(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(NORMAL_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 清除某键值对
     * @param key 键
     * */
    public static void remove(String key){
        remove(mContext,key);
    }


    /**
     * 设置全局上下文
     * @param context
     * */
    public static void setContext(Context context) {
        mContext = context;
    }


}
