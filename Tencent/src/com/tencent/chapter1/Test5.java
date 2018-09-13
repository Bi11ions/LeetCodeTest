package com.tencent.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangsen
 * @create 2018-09-13 9:20
 * title 最长公共前缀
 *  编写一个函数来查找字符串数组中的最长公共前缀。
 *  如果不存在公共前缀，返回空字符串 ""。
 */
public class Test5 {

    public static void main(String[] args) {
        String[] strs = {};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length < 1) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        List<String> list = new ArrayList<>(); // 用来保存两两比较后产生的相同字符串
        int minIndex = 0; // 记录最小长度的字符串在 list 中的位置
        for (int i = 0; i < strs.length-1; i++) {
            String temp = "";
            if(strs[i].length() > 0 && strs[i+1].length() > 0 && strs[i].charAt(0) == strs[i+1].charAt(0) ) {
                for (int j = 0; j < (strs[i].length() > strs[i+1].length() ? strs[i+1].length() : strs[i].length()); j++) {
                    if(strs[i].charAt(j) == strs[i+1].charAt(j)) {
                        temp += strs[i].charAt(j);
                    } else {
                        break;
                    }
                }
                list.add(temp);
                if(temp.length() < list.get(minIndex).length()) {
                    minIndex = i;
                }
            } else {
                return "";
            }
        }

        return list.get(minIndex);
    }

}
