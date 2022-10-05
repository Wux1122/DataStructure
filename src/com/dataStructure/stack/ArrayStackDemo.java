package com.dataStructure.stack;

import sun.security.mscapi.CPublicKey;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
        String key ="";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加到栈");
            System.out.println("pop:从栈弹出");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch(key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try{
                        int res =arrayStack.pop();
                        System.out.printf("出栈的数据是 %d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;

            }

        }
        System.out.println("程序退出...");

    }
}

class ArrayStack{
    private int maxSize; //栈的大小
    private int[] stack; //数组模拟栈
    private int top = -1; //表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("The stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("The stack is empty");
        }

        int value = stack[top];
        top --;
        return value;

    }

    //遍历 从栈顶开始显示
    public void list(){
        if(isEmpty()){
            System.out.println("The stack is empty");
        }

        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

}