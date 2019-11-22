package zxz.plans.growth.study.test;

/**
 * string测试类
 *
 * @author zhangxz
 * @date 2019-11-20 22:28
 */

public class StringTest {

    public static void main(String[] args) {
        test6();

    }

    static void test6() {
        String string = "string";
        StringBuilder stringBuilder = new StringBuilder("string builder");
        test4(string);
        test5(stringBuilder);
        System.out.println(string);
        System.out.println(stringBuilder.toString());
    }

    static void test5(StringBuilder stringBuilder) {
        stringBuilder.append("test5");
    }

    //不可变对象的安全性，调用string的任何方法都不会对string本身产生影响
    static void test4(String string) {
        string += " test4";
        string.concat(" test4");
        string.substring(2);
        string.substring(2, 5);
        string.replace('s', 't');
        string.toUpperCase();
        string.split("");
//        System.out.println("test4: " + string);
    }

    static void test3() {
        System.out.println("test3");
        StringBuilder stringBuilder = new StringBuilder("start-end");
        stringBuilder.insert(2, "-insert-for test");

        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder.capacity());
        System.out.println(stringBuilder.length());

        System.out.println(stringBuilder.reverse());
        System.out.println(stringBuilder);

    }

    static void test2() {
        System.out.println("test2");
        String string = "aab😁4";
        //code point相关参数
        System.out.println(string.codePointAt(4));
        System.out.println(string.codePointCount(0, 6));
        System.out.println(string.length());
        System.out.println(string.contentEquals("aab😁4"));

        StringBuilder stringBuilder = new StringBuilder("aab😁4");
        System.out.println(stringBuilder.toString() == string);
        System.out.println(stringBuilder.toString().equals(string));


        StringBuffer stringBuffer = new StringBuffer("aab😁4");
        System.out.println(stringBuffer.toString() == stringBuilder.toString());

    }

    static void test1() {
        System.out.println("test1");
        String string = "abc";
        String string1 = new String("abc");
        String string2 = "abc";
        String string3 = new String("abc");
        System.out.println(string == string1);
        System.out.println(string == string2);
        System.out.println(string1 == string3);

        System.out.println("abc" == "a" + "bc");
        String a = "a";
        System.out.println("abc" == a + "bc");
        final String a1 = "a";
        System.out.println("abc" == a1 + "bc");
        //intern方法，如果常量池有对应变量则返回，否则把该变量加入常量池并返回其引用
        System.out.println("abc" == (a + "bc").intern());
    }

}
