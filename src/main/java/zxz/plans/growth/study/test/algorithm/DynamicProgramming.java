package zxz.plans.growth.study.test.algorithm;

/**
 * 动态规划算法练习
 *
 * @author zhangxz
 * @date 2019-12-02 11:42
 */

public class DynamicProgramming {

    public static void main(String[] args) {



        System.out.println(test2(7));
        System.out.println(test2(8));
    }

    //n个台阶，一次走1步或者2步，求解总共有多少种走法
    //递归解法
    static int test1(int n){
        //边界条件
        if(n<=2){
            return n;
        }
        return test1(n-1) + test1(n-2);
    }

    //n个台阶，一次走1步或者2步，求解总共有多少种走法
    //受到递归的启发，可以使用迭代来完成
    static int test2(int n){
        if(n<=2){
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = step1 + step2;
            step1 = step2;
            step2 = sum;
        }
        return sum;
    }

}
