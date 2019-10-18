package zxz.plans.growth.study.test;

import java.text.MessageFormat;

/**
 * 操作符测试
 *
 * @author zhangxz
 * 2019/10/15
 */
public class OperatorTest {

    public static void main(String[] args) {
        testNot();
    }

    static void testNot() {
        not(0);
        not(1);
        not(-2);
        not(Integer.MAX_VALUE);
        not(Integer.MAX_VALUE - 1);
        not(Integer.MIN_VALUE);
        not(Integer.MIN_VALUE + 1);


        byte b1 = (byte) 0b11100111;
        byte b2 = (byte) 0b00010001;

        testRightShift(b1);
        testRightShift(b2);

    }

    //测试操作符：~，非操作
    //可以看到，对数值进行非运算后，运算前后的值的和为-1，而-1的补码形式，刚好是所有位（包括符号位）都为1，也就是该操作是对数值的每一个二进制位取反：1变成0,0变成1
    static void not(int param) {
        System.out.println(MessageFormat.format("~{0} = {1}", param, ~param));
    }

    //结论：1. 无符号右移时，会在左边直接补0，而普通右移则在左边补上符号位；
    // 2. byte类型整数进行移位操作时，会自动转成int类型，并且在左边全部补充符号位，包括无符号右移和普通右移
    // 3. 对数值进行移位操作后，不会对原数值有影响
    static void testRightShift(byte b) {

        System.out.println("=== === ");
        System.out.println("移位前：" + b);
        int i = b >> 2;
        //进行移位操作之后，操作数本身的值不变
        System.out.println("移位后：" + b);
        System.out.println();

        //注意，使用无符号右移操作时，如果操作的数值本身范围小于int（比如short，byte），最终结果会自动转换为int，
        //无符号右移：>>>
        System.out.println("===无符号右移===");
        System.out.println(b >>> 2);
        System.out.println(Integer.toBinaryString(b >>> 2));
        System.out.println();

        //普通右移：>>
        System.out.println("===普通右移===");
        System.out.println(b >> 2);
        System.out.println(Integer.toBinaryString(b >> 2));
        System.out.println();

    }

}
