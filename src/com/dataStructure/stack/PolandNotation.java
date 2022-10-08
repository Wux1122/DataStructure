package com.dataStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 - ";

        List<String> list = getListString(suffixExpression);

        int res = calculate(list);

        System.out.println(res);
    }

    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do {
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else{
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 || (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }
    
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();

        for (String item : list) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }

                stack.push(res+"");
            }

        }

        return Integer.parseInt(stack.pop());

    }

}
