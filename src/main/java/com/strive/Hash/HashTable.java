package com.strive.Hash;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//todo 拉链法 链表的思想
public class HashTable {
    //todo 节点类
    static class Entry{
        int hash; //todo 哈希码
        Object key; //todo 键
        Object value; //todo 值
        Entry next; //todo next指针

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    Entry[] table = new Entry[16];
    int size = 0;//todo 元素个数
    float loadFactor = 0.75f; //todo 超过12时会进行扩容
    int threshold = (int)(loadFactor * table.length); //todo 阈值

    /*
      求模运算替换为位运算
      -前提：数组长度是2的n次方
      -hash % 数组长度 等价于 hash & （数组长度 - 1）*/

    //todo 根据 hash 码获取 value
    Object get(int hash,Object key){
        int idx = hash & (table.length - 1);
        if(table[idx] == null){
            return null;
        }
        Entry p = table[idx];
        while(p != null){
            if(p.key.equals(key)){
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    //todo 向 hash 表存入新 key value，如果 key 重复，则更新 value
    void put(int hash,Object key,Object value){
        int idx = hash & (table.length - 1);
        if(table[idx] == null){
            //todo 1.idx处有空位，直接新增
            table[idx] = new Entry(hash,key,value);
        }else{
            //todo 2.idx处无空位，沿链表进行查找 有重复的key要进行更新，否则新增
            Entry p = table[idx];
            while(true){
                if(p.key.equals(key)){
                    p.value = value;
                    return;
                }
                if(p.next == null){
                    break;
                }
                p = p.next;
            }
            //todo 新增
            p.next = new Entry(hash,key,value);
        }
        size++;
        if(size > threshold){
            resize();
        }
    }
    //todo 扩容
    private void resize() {
        Entry[] newTable = new Entry[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            if(p != null){
                //todo 拆分链表 移动到新数组
                /*
                * 拆分规律
                * 一个链表最多拆成两个
                * hash & table.length == 0 的为一组
                * hash & table.length != 0 的为一组
                * */
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                while(p != null){
                    if((p.hash & table.length) == 0){
                        if(a != null){
                            a.next = p;
                        }else {
                            aHead = p;
                        }
                        a = p;
                    }else {
                        if(b != null){
                            b.next = p;
                        }else {
                            bHead = p;
                        }
                        b = p;
                    }
                    p = p.next;
                }
                //todo 规律：a链表保持索引位置不变，b链表索引位置+table.length
                if(a != null){
                    a.next = null;
                    newTable[i] = aHead;
                }
                if(b != null){
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        table = newTable;
        threshold = (int)(loadFactor * table.length);
    }

    //todo 根据 hash 码删除，返回删除的 value
    Object remove(int hash,Object key){
        int idx = hash & (table.length - 1);
        if(table[idx] == null){
            return null;
        }
        Entry p = table[idx];
        Entry prev = null;
        while(p != null){
            if(p.key.equals(key)){
                //todo 找到了 需要删除
                if(prev == null){
                    table[idx] = p.next;
                }else {
                    prev.next = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;
            p = p.next;
        }
        return null;
    }
    //todo 打印哈希表
    public void print(){
        int[] sums = new int[table.length];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            while(p != null){
                sums[i]++;
                p = p.next;
            }
        }
        //System.out.println(Arrays.toString(sums));
        Map<Integer,Long> collect = Arrays.stream(sums).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting()));
        System.out.println(collect);
    }


    //todo 哈希算法
    //todo Object类对象生成哈希码的方法
    public Object get(Object key){
        int hash = hash(key);
        return get(hash,key);
    }
    public void put(Object key,Object value){
        int hash = hash(key);
        put(hash,key,value);
    }
    public Object remove(Object key){
        int hash = hash(key);
        return remove(hash,key);
    }
    private static int hash(Object key){
        return key.hashCode();
    }

    //todo String类对象生成哈希码的方法
    public static void sString(String[] args) {
        String s1 = "bac";
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        /*
        * 原则：值相同的字符串生成相同的hash码，尽量让值不同的字符串生成不同的hash码
        * 对于abc a * 100 + b * 10 + c
        * 对于bac b * 100 + a * 10 + c
        * */

        int hash = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            System.out.println((int) c);
            hash = (hash << 5) - hash + c;
        }
        System.out.println(hash);
    }

    /*
    * 为什么计算索引位置用式子：hash & (数组长度 - 1)
    *     10进制中除以10，100，1000时，余数就是被除数的后1，2，3位
    *              10^1 10^2 10^3
    *     2进制中除以10，100，1000时，余数就是被除数的后1，2，3位
    *              2^1 2^2 2^3
    *
    * 为什么旧链表会拆分成两条，一条hash & 旧数组长度 == 0 另一条 != 0
    *     旧数组长度换算成二进制后，其中的 1 就是我们要检查的倒数第几位
    *         旧数组长度为8 二进制 => 1000 检查倒数第4位
    *         旧数组长度为16 二进制 => 10000 检查倒数第5位
    *      hash & 旧数组长度 就是用来检查扩容前后索引位置(余数)会不会变
    *
    * 为什么拆分后的两条链表，一个原索引不变，另一个是原索引 + 旧数组长度
    *
    * 他们有一个共同前提 ： 数组长度是2的n次方
    *
    */

    public static void main(String[] args) {
        HashTable table = new HashTable();
        for (int i = 0; i < 10000000; i++) {
            Object obj = new Object();
            table.put(obj,obj);
        }
        table.print();
    }
}
