package com.tencent.chapter1;

/**
 * @author wangsen
 * @create 2018-09-20 9:06
 * title 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Test13 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode    contest";
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        char[] chars = s.toCharArray();

        boolean flag = false; // 用于判断一个完整单词
        int startIndex = 0; // 用于单词的起始索引
        int endIndex = 0; // 用于单词的结束索引
        for (int i = 0; i < chars.length; i++) {
            // 如果该字符不为空格，且是字符串的首字符，或者前一个字符为空格，则记录该点为单词起始点，并且直接进入下一层循环
            if(chars[i] != ' ' && (i == 0 || chars[i-1] == ' ')) {
                startIndex = i;
                flag = true;
                continue;
            }
            // 如果该字符不为空格，并且该字符位置为字符串结尾或者下一个字符为空格，则记录该字符为单词结束点
            if(chars[i] != ' ' && (i+1 == chars.length|| chars[i+1] == ' ')) {
                endIndex = i;
                // 如果存在单词起始点，且起始点小于结束点，开始交换
                while(flag && endIndex > startIndex) {
                    //  交换
                    char temp = chars[startIndex];
                    chars[startIndex] = chars[endIndex];
                    chars[endIndex] = temp;

                    startIndex++;
                    endIndex--;
                }
                // 记录结束点后，需要把 flag 置为 false
                flag = false;
            }
        }

        return String.copyValueOf(chars);
    }

}
