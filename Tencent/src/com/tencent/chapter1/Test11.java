package com.tencent.chapter1;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

/**
 * @author wangsen
 * @create 2018-09-16 13:54
 * title 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Test11 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String result = multiply(num1, num2);
        System.out.println(result);
    }


    public static String multiply(String num1, String num2) {
        // 先把string翻转
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        // 构建数组存放乘积, 存放每一次的乘积
        int[] d = new int[n1.length()+n2.length()];
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');		// 在正确位置累加乘积
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < d.length; i++){
            int digit = d[i]%10;		// 当前位
            int carry = d[i]/10;		// 进位
            if(i+1 < d.length){
                d[i+1] += carry;
            }
            sb.insert(0, digit);		// prepend
        }

        // 移除前导零
        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        return sb.length()==0? "0" :sb.toString();

    }



}
