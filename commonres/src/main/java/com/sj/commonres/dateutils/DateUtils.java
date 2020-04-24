package com.sj.commonres.dateutils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by SJ on 2020/3/30.
 */
public class DateUtils {

    /**
     * 解析日期，获取星期几
     */
    public static String getStringDayOfWeek(Date date) {
        String dayOfWeek = "";
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(date);//设置当前日期
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        /*星期日:Calendar.SUNDAY=1
         *星期一:Calendar.MONDAY=2
         *星期二:Calendar.TUESDAY=3
         *星期三:Calendar.WEDNESDAY=4
         *星期四:Calendar.THURSDAY=5
         *星期五:Calendar.FRIDAY=6
         *星期六:Calendar.SATURDAY=7 */
        switch (week) {
            case 1:
                dayOfWeek = "星期日";
                break;
            case 2:
                dayOfWeek = "星期一";
                break;
            case 3:
                dayOfWeek = "星期二";
                break;
            case 4:
                dayOfWeek = "星期三";
                break;
            case 5:
                dayOfWeek = "星期四";
                break;
            case 6:
                dayOfWeek = "星期五";
                break;
            case 7:
                dayOfWeek = "星期六";
                break;
            default:
                break;
        }
        return dayOfWeek;
    }
}
