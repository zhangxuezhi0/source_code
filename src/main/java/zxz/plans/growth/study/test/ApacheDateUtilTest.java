package zxz.plans.growth.study.test;

import first.zxz.tools.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * apache日期工具类测试
 * 问题：是否线程安全？以替换SimpleDateFormat
 *
 * @author zhangxz
 * @date 2019-11-23 12:23
 */

public class ApacheDateUtilTest {

    public static void main(String[] args) {
        test3();
    }

    static void test3(){
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd, HH:mm:ss.SSS"));
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd, hh:mm:ss.SSS"));
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd, HH:mm:ss"));


    }

    static void test2() {
        Date date = new Date();
        System.out.println(date);

        System.out.println(DateUtils.truncate(date, Calendar.YEAR));
        System.out.println(DateUtils.truncate(date, Calendar.MONTH));
        System.out.println(DateUtils.truncate(date, Calendar.DATE));
        System.out.println(DateUtils.truncate(date, Calendar.HOUR));
        System.out.println(DateUtils.truncate(date, Calendar.HOUR_OF_DAY));

        //这个小时过去了多少分钟/秒/毫秒
        System.out.println(DateUtils.getFragmentInMinutes(date, Calendar.HOUR_OF_DAY));
        System.out.println(DateUtils.getFragmentInSeconds(date, Calendar.HOUR_OF_DAY));
        System.out.println(DateUtils.getFragmentInMilliseconds(date, Calendar.HOUR_OF_DAY));
        //今天过去了多少分钟/小时/
        System.out.println(DateUtils.getFragmentInMinutes(date, Calendar.DATE));
        System.out.println(DateUtils.getFragmentInHours(date, Calendar.DATE));
        ////这个月过去了多少分钟/小时/天
        System.out.println(DateUtils.getFragmentInMinutes(date, Calendar.MONTH));
        System.out.println(DateUtils.getFragmentInHours(date, Calendar.MONTH));
        System.out.println(DateUtils.getFragmentInDays(date, Calendar.MONTH));

    }

    static void test1() {
        Date date = new Date();
        System.out.println(date);

        Date date1 = DateUtils.addDays(date, 1);
        System.out.println(date);
        System.out.println(date1);

        System.out.println(DateUtils.isSameDay(date, date1));
        System.out.println(DateUtils.isSameDay(date, DateUtils.addHours(date, 1)));

        System.out.println(DateUtils.setDays(date, 19));

        System.out.println(DateUtils.ceiling(date, Calendar.YEAR));
        System.out.println(DateUtils.ceiling(date, Calendar.MONTH));
        System.out.println(DateUtils.ceiling(date, Calendar.DATE));

        System.out.println(DateUtils.ceiling(date, Calendar.HOUR));
        System.out.println(DateUtils.ceiling(date, Calendar.HOUR_OF_DAY));
        System.out.println(DateUtils.ceiling(date, Calendar.MINUTE));
        System.out.println(DateUtils.ceiling(date, Calendar.SECOND));
        System.out.println(DateUtils.ceiling(date, Calendar.MILLISECOND));
        System.out.println(DateUtils.ceiling(date, Calendar.ERA));
        System.out.println(DateUtils.ceiling(date, Calendar.AM_PM));
        System.out.println(DateUtils.ceiling(DateUtils.setHours(date, 11), Calendar.AM_PM));
        System.out.println(DateUtils.ceiling(DateUtils.setHours(date, 12), Calendar.AM_PM));


        System.out.println(date);

    }

}
