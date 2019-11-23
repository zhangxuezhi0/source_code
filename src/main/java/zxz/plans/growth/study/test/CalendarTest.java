package zxz.plans.growth.study.test;

import java.util.Calendar;

/**
 * calendar类测试
 *
 * @author zhangxz
 * @date 2019-11-23 15:04
 */

public class CalendarTest {

    public static void main(String[] args) {
        test2();
    }

    final static Calendar calendar;

    static {
        calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
    }

    static void test2() {
        int type = 0;

//        calendar.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Paris")));
//        calendar.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/London")));
        //0, 1：AD公元(Anno Domini)　或者 0：BC公元前(Before Christ), Julian Calendar公历
        System.out.println(calendar.get(Calendar.ERA));

        System.out.println("1~5 =======");
        //1
        System.out.println(calendar.get(Calendar.YEAR));
        //2
        System.out.println(calendar.get(Calendar.MONTH));
        //3
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        //4
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
        //5
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DATE));

        System.out.println("6~10==========");
        //6
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //7
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        //8
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        //9, am:0, pm:1
        System.out.println(calendar.get(Calendar.AM_PM));
        //10
        System.out.println(calendar.get(Calendar.HOUR));

        System.out.println("11~end===========");
        //11
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        //12
        System.out.println(calendar.get(Calendar.MINUTE));
        //13
        System.out.println(calendar.get(Calendar.SECOND));
        //14
        System.out.println(calendar.get(Calendar.MILLISECOND));
        //15，与GMT时区差的毫秒数，中国的：8*3600*1000 = 28800000
        System.out.println(calendar.get(Calendar.ZONE_OFFSET));
        //16，daylight saving 夏时令
        System.out.println(calendar.get(Calendar.DST_OFFSET));

    }

    static void test1() {
        //Gregorion calendar 格里高利历，即公历
//        calendar.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Paris")));
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getCalendarType());
        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println(calendar.getTime());
        System.out.println(calendar.getMinimalDaysInFirstWeek());
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.getWeeksInWeekYear());
        System.out.println(calendar.getWeekYear());
    }

}
