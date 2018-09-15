package com.tencent.chapter1;

import java.util.Stack;

/**
 * @author wangsen
 * @create 2018-09-15 8:42
 * title 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *      '(' - 40, ')' - 41, '[' - 91, ']' - 93, '{' - 123, '}' - 125
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Test8 {

    public static void main(String[] args) {
        String s = "[])";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        if(s == null) {
            return false;
        }
        if("".equals(s)) {
            return true;
        }

        stack.push(s.charAt(0));
        // 做入栈操作
        for (int i = 1; i < s.length(); i++) {
            char searchTemp = s.charAt(i);
            switch (s.charAt(i)) {
                // 左括号先入栈
                case '(': stack.push(s.charAt(i)); continue;
                case '{': stack.push(s.charAt(i)); continue;
                case '[': stack.push(s.charAt(i)); continue;
                // 右括号转换为左括号，在判断栈中是否有该左括号
                case ')': searchTemp='('; break;
                case '}': searchTemp='{'; break;
                case ']': searchTemp='['; break;
            }
            if(!stack.empty() && stack.peek() == searchTemp) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

}
