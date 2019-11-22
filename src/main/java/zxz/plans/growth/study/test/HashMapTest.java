package zxz.plans.growth.study.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;

/**
 * hash表相关测试
 *
 * @author zhangxz
 * @date 2019-11-22 10:47
 */

public class HashMapTest {

    public static void main(String[] args) {
        test3();
    }

    static void test3(){
        Key key1 = new Key(1, "a1");
        Key key2 = new Key(1, "a2");

        HashSet<Key> hashSet = new HashSet<>();
        hashSet.add(key1);
        hashSet.add(key2);
        System.out.println(hashSet);

        key2.name = "a1";
        System.out.println(hashSet);

        hashSet.remove(key1);
        System.out.println(hashSet);

        hashSet.remove(key2);
        System.out.println(hashSet);

        hashSet.clear();
        System.out.println(hashSet);


    }

    //不可变对象作为hash map的key时，会引发各种奇怪的问题
    static void test2(){
        Key key1 = new Key(1, "a1");
        Key key2 = new Key(1, "a2");

        HashMap<Key, Integer> hashMap = new HashMap<>();
        hashMap.put(key1,1);
        hashMap.put(key2,2);
        System.out.println(hashMap);

        System.out.println(hashMap.get(key2));

        key2.name = "a1";
        System.out.println(hashMap);

        System.out.println(hashMap.get(key1));
        System.out.println(hashMap.get(key2));

        System.out.println(key1==key2);
        System.out.println(key1.equals(key2));

        hashMap.remove(key1);
        System.out.println(hashMap);

        hashMap.remove(key2);
        System.out.println(hashMap);

        System.out.println(hashMap.get(key1));
        System.out.println(hashMap.get(key2));

        hashMap.clear();
        System.out.println(hashMap);

    }

    @ToString
    @EqualsAndHashCode
    static class Key{
        int code;
        String name;
        public Key(int code, String name){
            this.code = code;
            this.name = name;
        }

    }

    //当可变对象作为hash map的key时，就有这样的风险：不同的key值被改成相同的，这样就产生了重复的key值
    static void test1(){
        HashMap<StringBuilder, Integer> hashMap = new HashMap<>();

        StringBuilder stringBuilder1 = new StringBuilder("a1");
        StringBuilder stringBuilder2 = new StringBuilder("a1a2");

        hashMap.put(stringBuilder1,1);
        hashMap.put(stringBuilder2,2);
        System.out.println(hashMap);

        stringBuilder1.append("a2");
        System.out.println(hashMap);

        System.out.println(hashMap.get(stringBuilder1));
        System.out.println(hashMap.get(stringBuilder2));
        System.out.println(hashMap.get(new StringBuilder("a1")));

    }

}
