package com.strive.Stack;

import java.util.LinkedList;

public class InfixToSuffix {               //todo:中缀表达式 转 后缀表达式
    public static void test(){
        int a = 10;
        int b = 20;
        int c = a + b;  //todo:中缀
    }

    //todo: 遇到非运算符  直接拼串
    //todo: 遇到+ - * /
    //todo：它的优先级比栈顶运算符高 入栈
    //todo：否则把栈里优先级 >= 它 的都出栈  它再入栈
    //todo：遍历完成 全部依次出栈
    //todo：带()    左括号直接入栈，左括号优先设置为0   右括号就把栈里到左括号为止的所有运算符出栈

    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a*b+c"));
    }

    static int priority(char c){
        return switch (c){
            case '*','/' -> 2;
            case '+','-' -> 1;
            default -> throw new IllegalArgumentException("不合法的运算符:" + c);
        };
    }

    static String infixToSuffix(String exp){
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c){
                case '*','/','+','-' ->{
                    if(stack.isEmpty()){
                        stack.push(c);
                    }else{
                        if(priority(c) > priority(stack.peek())){
                            stack.push(c);
                        }else{
                            while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    sb.append(c);
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        return sb.toString();
    }
}
