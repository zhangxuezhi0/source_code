package zxz.plans.growth.study.test;

import java.util.Date;
import java.util.Locale;

/**
 * string格式化方法测试
 *
 * @author zhangxz
 * @date 2019-11-21 11:48
 */

public class StringFormatTest {

    public static void main(String[] args) {
        test5();
    }

    static void test5() {
        Date date = new Date();

        System.out.println(String.format("%tc", date));
        System.out.println(String.format(Locale.CHINA, "%tc", date));
        System.out.println(String.format(Locale.CHINESE, "%tc", date));
        System.out.println(String.format(Locale.SIMPLIFIED_CHINESE, "%tc", date));
        System.out.println(String.format(Locale.TRADITIONAL_CHINESE, "%tc", date));
        System.out.println(String.format(Locale.TRADITIONAL_CHINESE, "%s", "卧虎藏龙"));
        System.out.println(String.format(Locale.TAIWAN, "%tc", date));


        System.out.println(String.format(Locale.US, "%tc", date));
        System.out.println(String.format(Locale.UK, "%tc", date));
        System.out.println(String.format(Locale.CANADA, "%tc", date));
        System.out.println(String.format(Locale.JAPAN, "%tc", date));
        System.out.println(String.format(Locale.JAPANESE, "%tc", date));
        System.out.println(String.format(Locale.ENGLISH, "%tc", date));
        System.out.println(String.format(Locale.FRANCE, "%tc", date));
        System.out.println(String.format(Locale.GERMAN, "%tc", date));

    }

    static void test4() {
        System.out.println("test4");
        Date date = new Date();

        //基本格式为：%tx，x可变为c，F等

        System.out.println(date);
        //%tc，显示全部
        System.out.printf("%tc%n", date);
        //%tF，yyyy-MM-dd
        System.out.printf("%tF%n", date);
        //%tD,MM/dd/yy
        System.out.printf("%tD%n", date);
        //%tr, 12hh:mm:ss pm/am
        System.out.printf("%tr%n", date);
        //%tT, 24hh:mm:ss
        System.out.printf("%tT%n", date);
        //%tR,24hh:mm
        System.out.printf("%tR%n", date);
    }

    static void test3() {
        System.out.println("test3");
        //组合输出测试
        System.out.printf("%,+.6f, %<f%n", 12345.45);
        System.out.printf("%#08x, %<x%n", 12345);
        System.out.printf("%08x, %<x%n", 12345);
    }

    static void test2() {
        //%+，显示符号
        System.out.printf("0：%+d %n", 0);
        System.out.printf("19：%+d %n", 19);
        System.out.printf("-19：%+d %n", -19);
        System.out.printf("0xffffffff：%+d %n", 0xffffffff);
        System.out.printf("0xfffffffe：%+d %n", 0xfffffffe);

        //%-，左对齐，感觉不出来作用
        System.out.printf("%-6d %n", 12345678);
        System.out.printf("%-6d %n", 1234567);

        //%0，数字前面补0，如果数值位数比指定的长度大，则无效。
        System.out.printf("%06d %n", 12345);
        System.out.printf("%06d %n", 12345678);
        System.out.printf("%06o %n", 12);

        //% ，数字前面补空格，至少会补充一个空格
        System.out.printf("% 6d%n", 1234567890);
        System.out.printf("% 6d%n", 12);
        System.out.printf("% 3f%n", 12.12);

        //%, ，用逗号对数字分组显示
        System.out.printf("%,d%n", 123);
        System.out.printf("%,d%n", 1234567890);
        System.out.printf("%,f%n", 1234567890.1);
        System.out.printf("%,f%n", 1234567890.1234567);

        //%(，使用括号包含负数
        System.out.printf("%(d%n", -12345);
        System.out.printf("%(d%n", 12345);

        //%#，如果是浮点数则包含小数点，如果是十六进制则包含0x，如果是八进制则包含0
        System.out.printf("%#f%n", 123.1);
        System.out.printf("%#x%n", 123);
        System.out.printf("%#o%n", 123);

        //%<格式化前一个转换符所描述的参数
        System.out.printf("%#o, %<o%n", 123);
        System.out.printf("%+d, %<o%n", 123);
        System.out.printf("%+d, %<d%n", 123);
        System.out.printf("%,d, %<d%n", 1234567);
        System.out.printf("%(d, %<d%n", -123);
        System.out.printf("% 6d, %<d%n", 123);
        System.out.printf("%06d, %<d%n", 123);
        System.out.printf("%#o, %<o%n", 123);
        System.out.printf("%#x, %<x%n", 123);
        System.out.printf("%#f, %<f%n", 123.12);

        //%n$,参数顺序引用
        System.out.printf("%2$d, %1$d%n", 123, 321);
        System.out.printf("%2$d, %1$s%n", "abc", 321);
        System.out.printf("%3$d, %1$#o, %2$#x%n", 1, 2, 3);

        //%.n，小数点后面保留的个数，四舍五入
        System.out.printf("%.3f%n", 12345.54381);
        System.out.printf("%.8f%n", 12345.54321);


    }

    static void test1() {
        //%s表示字符串
        System.out.println(String.format("Hello, %s", "张三丰"));
        System.out.println(String.format("Hello, %s, 我是%s，请多指教", "张三丰", "张三"));
        //%c表示字符, %n表示换行
        System.out.println(String.format("字母a的大写形式：%c, %n", 'A'));

        //System.out.printf和String.format一样可以进行格式化输出
        System.out.printf("字母a的大写形式：%c, %n", 'A');

        //%d表示十进制整数
        System.out.printf("1001+2=%d %n", 1001 + 2);
        System.out.printf("-1001+2=%d %n", -1001 + 2);
        System.out.printf("1-20=%d %n", 1 - 20);

        //%x表示十六进制整数
        System.out.printf("17的十六进制表示：%x %n", 17);
        System.out.printf("31的十六进制表示：%x %n", 31);

        //%o表示八进制整数
        System.out.printf("9的八进制表示：%o %n", 9);
        System.out.printf("8的八进制表示：%o %n", 8);
        System.out.printf("7的八进制表示：%o %n", 7);
        System.out.printf("13的八进制表示：%o %n", 13);

        //%b表示布尔数（输出小写），%B则输出大写的布尔数值
        //数值包括0，其布尔输出都是true
        System.out.printf("1的布尔表示：%b %n", 1);
        System.out.printf("3的布尔表示：%B %n", 3);
        System.out.printf("0的布尔表示：%b %n", 0);
        System.out.printf("0.1的布尔表示：%b %n", 0.1);
        System.out.printf("-1的布尔表示：%b %n", -1);
        System.out.printf("5>7：%b %n", 5 > 7);
        System.out.printf("5<=7：%B %n", 5 <= 7);

        //没有二进制的表示方法，只能使用integer类的内置方法
        System.out.println(Integer.toBinaryString(10));

        //%f表示浮点数
        System.out.printf("25 * 8.0=%f %n", 25 * 8.0);
        System.out.printf("10 / 8.0=%f %n", 10 / 8.0);

        //%a表示浮点型十六进制
        System.out.printf("31.1的十六进制值：%a %n", 31.8);

        //%e表示指数类型
        System.out.printf("12345.678901的指数表示：%e %n", 12345.678901);

        //%g通用浮点类型
        System.out.printf("12345.678901的通用浮点表示：%g %n", 12345.678901);

        //%%百分比符号显示
        System.out.printf("85折的百分比表示：%d%% %n", 85);

        //%h表示hash码，单字符时，计算出来的hash码刚好与ascii码相对应
        System.out.printf("a的hash码是：%h %n", "a");
        System.out.printf("b的hash码是：%h %n", "b");
        System.out.printf("ab的hash码是：%h %n", "ab");
        System.out.printf("1的hash码是：%h %n", "1");
        System.out.printf("空格的hash码是：%h %n", " ");
        System.out.printf("null的hash码是：%h %n", "");


    }

}
