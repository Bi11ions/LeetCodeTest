package com.tencent.chapter1;

/**
 * @author wangsen
 * @create 2018-09-20 8:51
 * title 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。
 */
public class Test12 {

    public static void main(String[] args) {
        String s = "";
        String result = reverseString(s);
        System.out.println(result);
    }

    public static String reverseString(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - 1 - i];
            charArray[length - 1 - i] = temp;
        }

        return String.valueOf(charArray);
    }
}
