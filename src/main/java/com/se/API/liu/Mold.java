package com.se.API.liu;

import java.util.Random;
import java.util.Scanner;

public class Mold {
    public static void main(String[] args) {
        int a = 24;
        int b = 18;
        int c = a % b;
        while(c != 0){
            a = b;
            b = c;
            c = a % b;
        }
        System.out.println(b);
    }
    //判断数字是否为素数
    public static void main10(String[] args) {
        int n = 11;
        int i = 2;
        for( ; i < n/2;i++){
            if(n % i == 0){
                System.out.println("不是素数！");
                break;
            }
        }
        if( i == n){
            System.out.println("是素数！");
        }
    }
    //判断二进制数的位数
    public static void main9(String[] args) {
        int n = 7;
        for(int i =31;i >= 1 ;i -= 2){
            System.out.print(((n >> i) & 1)+ " ");
        }//偶数
        System.out.println();
        for(int i =30;i >= 0 ;i -= 2){
            System.out.print(((n >> i) & 1)+ " ");
        }
    }
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while(count != 0){
            System.out.println("请输入您的密码，共有"+count+"次机会");
            String pass = scanner.nextLine();
            if(pass.equals("123")){
                System.out.println("登陆成功！");
                break;
            }else{
                System.out.println("登陆失败！");
            }
            count--;
        }
    }
    //9x9乘法表
    public static void main7(String[] args) {
        for(int i = 1;i <= 9;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(i+"*"+j +"="+ i*j+" ");
            }
            System.out.println();
        }
    }
    //牛客网 打印X型图案的题
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int n = scan.nextInt();
            for(int i = 0;i < n; i++){
                for(int j = 0;j < n; j++){
                    if((i == j) || (i + j == n-1)){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
    //求7位以内的水仙花数
    public static void main5(String[] args) {
        for (int i = 0; i < 9999999; i++) {
            int count = 0;
            int tmp = i;
            int sum = 0;
            while(tmp != 0){
                tmp /= 10;
                count++;
            }
            //count里面就存储了当前数字i是几位数
            tmp = i;
            while(tmp != 0){
                sum += Math.pow(tmp%10, count);
                tmp /= 10;
            }
            //sum存储了和
            if(sum == i){
                System.out.println(i);
            }
        }
    }
    public static void main4(String[] args) {
        double sum = 1.0;
        int flg = 1;
        for (int i = 1; i < 100; i++) {
            sum = sum + 1.0/i * flg;
            flg = -flg;
        }
        System.out.println(sum);
    }
    //第二种写法
    public static void main3(String[] args) {
        int n = 10;
        int count = 0;
        while(n != 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }
    //第一种写法
    public static void main2(String[] args) {
        int n = 10;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if(((n >> i) & 1) != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main1(String[] args) {
        //java中创建一个随机数
        Random random = new Random();
        int n = random.nextInt(100);
        System.out.println("随机数"+n);
        Scanner scan = new Scanner(System.in);
        //Math.random();
        while(true){
            System.out.println("输入你要猜的数字：");
            int num = scan.nextInt();
            if(num < n){
                System.out.println("猜小了！");
            }else if(num < n){
                System.out.println("猜大了！");
            }else{
                System.out.println("猜对了！");
                break;
            }
        }
    }
}
