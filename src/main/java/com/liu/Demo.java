package com.liu;

import java.util.Random;
import java.util.Scanner;


public class Demo {
    public static void main(String[] args) {
        //java中创建一个随机数
        Random random = new Random();
        int n = random.nextInt();
        System.out.println(n);
        //Math.random();
    }
    public static void main12(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入你的姓名：");
        String name = scan.nextLine();
        System.out.println("姓名：" + name);

        System.out.println("输入你的年龄：");
        int age = scan.nextInt();
        System.out.println("年龄" + age);

        System.out.println("输入你的工资：");
        float money = scan.nextFloat();
        System.out.println("工资" + money);

        scan.close();
    }
    public static void main11(String[] args) {
        System.out.println(10);
        System.out.print("不换行");
        System.out.printf("%s","这是格式化输出!");
    }
    public static void main10(String[] args) {
        for(int i = 1;i <= 100;i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println(" " + i);
                continue;
            }
        }
        int i = 1;
        while(i <= 100){
            if(i % 15 != 0){
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
    public static void main9(String[] args) {
        //continue结束本次循环
        //break结束所有循环
        int a = 10;
        while(a >= 0){
            if(a == 9){
                continue;
            }
            a--;
        }
    }
    public static void main8(String[] args) {
        int a = 1;
        while(a <= 10){
            System.out.println(a);
            a++;
        }
    }
    public static void main7(String[] args) {
        int ret2 = 0;
        int n = 1;
        while(n <= 5) {
            int i = 1;
            int ret = 1;
            while (i <= n) {
                ret *= i;
                i++;
            }
            ret2 += ret;
            n++;
        }
        System.out.println(ret2);
    }
    public static void main6(String[] args) {
        int i = 1;
        int ret = 1;
        while(i <= 5){
            ret *= i;
            i++;
        }
        System.out.println(ret);
    }
    public static void main5(String[] args) {
        //1-100的和
        //1-100奇数的和
        //1-100偶数的和
        int i = 0;
        int sum = 0;
        int sumOdd = 0;
        int sumEve = 0;
        while (i <= 100) {
            if (i % 2 == 0) {
                sumEve += i;
            } else {
                sumOdd += i;
            }
            sum += i;
            i++;
        }
        System.out.println(sum);
        System.out.println(sumOdd);
        System.out.println(sumEve);
    }
    public static void main4(String[] args) {
        int i = 1;
        while(i<=10){
            System.out.println(i);
            i++;//循环的布进
        }
    }
    public static void main3(String[] args) {
        //不能做switch的参数的数据类型是哪些？
        //long double float boolean
        int a = 2;
        switch(a){
            case 1:
                System.out.println("one");
                break;
        }
    }
    public static void main2(String[] args) {
        int a=1;
        switch(a){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("没有匹配！");
                break;
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int year = 2000; year < num; year++) {
            if (year % 100 != 0) {
                if (year % 4 == 0) {
                    System.out.println(year + "is Leap year!");
                } else {
                    if (year % 400 == 0) {
                        System.out.println(year + "is Leap year!");
                    }
                }
            }
        }
    }
   /* public static void main2(String[] args) {
        //Scanner工具  System.in：键盘
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt(); //实际工作中很少使用
        // 所以 java的输入输出 c语言的输入输出 用起来有点别扭
        if(a % 2 == 0) {
            System.out.println("偶数");
        }else {
            System.out.println("奇数");
        }
    }*/
   /* public static void main1(String[] args) {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");

        int a = 1;
        System.out.println(a);
    }*/
}
