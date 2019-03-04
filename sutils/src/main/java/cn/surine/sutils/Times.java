package cn.surine.sutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static cn.surine.sutils.SutilsConstant.MONTH_OUT_OF_BOUNDS;
import static cn.surine.sutils.SutilsConstant.PARSE_ERROR;
import static cn.surine.sutils.SutilsConstant.PRECISE_ERROR;
import static cn.surine.sutils.SutilsConstant.SUTILS_ERROR;

/**
 * Created by Surine on 2019/2/3.
 * 时间工具类
 * v1.0.0 新建版本
 *        Add. 获取当前时间
 *        Add. 获取年月日/时分秒
 *        Add. 时间戳转时间
 *        Add. 时间转时间戳
 *        Add. 时间比较
 *        Add. 获取一个时间的前几天或者后几天
 *        Add. 获取月份或日期中文
 * v1.0.1 更新
 *        BUG. 修复获取时间前后几天会出现时间异常的问题，更新了相应方法
 *        ADD. 新增获取某一个时间的某个部分
 *        UP.  部分方法的异常返回值修改为传入值
 */

public class Times {

    //一天的时间戳
    public static final long dayTimeMillis = 1000 * 60 * 60 *24;
    //一个小时的时间戳
    public static final long hourTimeMillis = dayTimeMillis / 24;
    //一分钟的时间戳
    public static final long minTimeMillis = hourTimeMillis / 60 ;

     //几种常用格式
     public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
     public static final String yyyyMMdd = "yyyy-MM-dd";
     public static final String HHmmss = "HH:mm:ss";
     public static final String E = "E";
     public static final String yyyy = "yyyy";
     public static final String MM = "MM";
     public static final String dd = "dd";
     public static final String HH = "HH";
     public static final String mm = "mm";
     public static final String ss = "ss";

    //月份中文
    public static final String []monthChinese={"一月","二月","三月","四月","五月","六月"
            ,"七月","八月","九月","十月","十一月","十二月"};
    //日中文
    private static String[] dayChinese = {
            "一日", "二日", "三日", "四日", "五日", "六日", "七日", "八日", "九日", "十日",
            "十一日","十二日", "十三日","十四日", "十五日","十六日", "十七日","十八日", "十九日","二十日",
            "二十一","二十二", "二十三","二十四", "二十五","二十六", "二十七","二十八", "二十九", "三十日", "三十一",
    };

     /**
      * 获取当前时间
      * @return yyyy-MM-dd HH:mm:ss格式时间
      * */
     public static String getCurrentTime(){
         return getCurrentTime(yyyyMMddHHmmss);
     }


    /**
     * 获取当前时间
     * @param format 时间格式化 如："yyyy-MM-dd HH:mm:ss"
     * */
    public static String getCurrentTime(String format){
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat(format, Locale.getDefault());
        return sd.format(date);
    }

    /**
     * 获取当前年，int格式
     * */
    public static int getYearInt(){
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取当前月，int格式
     * */
    public static int getMothInt(){
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 获取当前天，int格式
     * */
    public static int getDayInt(){
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前小时，string 格式
     * */
    public static String getHour(){
        return getCurrentTime(HH);
    }

    /**
     * 获取当前分钟，string格式
     * */
    public static String getMinute(){
        return getCurrentTime(mm);
    }

    /**
     * 获取当前秒
     * */
    public static String getSecond(){
        return getCurrentTime(ss);
    }


    /**
     * unix时间戳 to 时间
     * @param millisecond 时间戳
     * @param format 格式
     * @param locale locate
     * */
    public static String unix2LocateTime(long millisecond,String format,Locale locale){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, locale);
        return simpleDateFormat.format(millisecond);
    }


    /**
     * unix时间戳 to 当地时间
     * @param millisecond 时间戳
     * @param format 格式
     * */
    public static String unix2LocateTime(long millisecond,String format){
        return unix2LocateTime(millisecond,format,Locale.getDefault());
    }


    /**
     * 当地时间 to 时间戳
     * @param time 当地时间
     * @param format 格式
     * @param locale Locate
     * */
    public static long locateTime2unix(String time,String format,Locale locale){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, locale);
        long unixTimestamp = 0;
        try {
            Date date = simpleDateFormat.parse(time);
            unixTimestamp = date.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixTimestamp;
    }



    /**
     * 当地时间 to 时间戳
     * @param time 当地时间
     * @param format 格式
     * */
    public static long locateTime2unix(String time,String format){
        return locateTime2unix(time,format,Locale.getDefault());
    }

    /**
     * 时间字符串比较大小
     * @param s1 时间1
     * @param s2 时间2
     * @param format 格式
     * @return 1:s1大于s2 -1:s1小于s2
     */
    public static int compareDate(String s1,String s2,String format){
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long sTime1,sTime2;
        try {
            sTime1 = sd.parse(s1).getTime();
            sTime2 = sd.parse(s2).getTime();

            if(sTime1 < sTime2){
                return -1;
            }

            if(sTime1 == sTime2){
                return 0;
            }

            if(sTime1 > sTime2){
                return 1;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 获取某月中文
     * @param i 月份数字 1-12
     * @return 月份中文
     * */
    public static String getMonthChinese(int i){
        if(i < 1 || i > 12){
            throw new IllegalArgumentException(SUTILS_ERROR+MONTH_OUT_OF_BOUNDS);
        }else{
            return monthChinese[i - 1];
        }
    }

    /**
     * 获取某天中文
     * @param i 天数字
     * @return 天中文
     * */
    public static String getDayChinese(int i){
        if(i < 1 || i > 31){
            throw new IllegalArgumentException(SUTILS_ERROR+MONTH_OUT_OF_BOUNDS);
        }else{
            return dayChinese[i - 1];
        }
    }


    /**
     * 获取一个时间的前几天或者后几天
     * @param dateString 时间字符串
     * @param format 格式
     * @param number 几天？
     * @param isAfter 前几天还是后几天 true 为后，false为前
     * @return 处理后时间字符串
     * */
    public static String getDateBeforeOrAfter(String dateString,String format,int number,boolean isAfter){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        Date date1 = null;
        try {
            date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            // 正数表示该日期后n天，负数表示该日期的前n天
            calendar.add(Calendar.DATE, isAfter ? number :( -1 * number));
            date1 = calendar.getTime();
            return sdf.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return dateString;
    }


    /**
     * 通过时间字符串解析时间值
     * @param dateString 时间字符串
     * @param pattern1 时间字符串所满足的格式
     * @param pattern2 要获取的部分的格式
     * 使用时注意精度损失
     * */
    public static String getStringByTimeString(String dateString,String pattern1,String pattern2){
        SimpleDateFormat format = new SimpleDateFormat(pattern1);
        SimpleDateFormat formatResult = new SimpleDateFormat(pattern2);//设置日期格式
        Date date;
        try {
            date = format.parse(dateString);
            return formatResult.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateString;
    }
}
