package com.tencent.chapter1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangsen
 * @create 2018-09-10 14:29
 *
 * title  字符串转整数 (atoi)
 *  实现 atoi，将字符串转为整数。
 *
 *  在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的
 *  数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *  字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *  当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 *  若函数不能执行有效的转换，返回 0。
 *
 * 说明：
 *      假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，
 *      则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class Test4 {

    public static void main(String[] args) {
        String str ="    +11191657170";
        int result = myAtoi(str);
        System.out.println(result);
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        while (str.charAt(0) == '0') {
            str = str.substring(1);
            if(str.length() < 1 ||str.charAt(0) < '0' || str.charAt(0) > '9' ) {
                return 0;
            }
        }

        int lastIndex = 0;
        // 首字母如果为 - 或 +，则为负数，先把 - 提取出来
        String resultStr = "";
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            resultStr = str.charAt(0) + "";
            str = str.substring(1);
            if (str.length() < 1) {
                return 0;
            }
            // 再去符号后的与在第一个有效数字之前的 0
            while (str.charAt(0) == '0') {
                str = str.substring(1);
                if(str.length() < 1) {
                    return 0;
                }
            }

        }
        if (str.charAt(0) > '0' && str.charAt(0) <= '9') {
            lastIndex++;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    lastIndex++;
                } else {
                    break;
                }
            }
        } else {
            return 0;
        }


        int maxValue = (int) (Math.pow(2,31) - 1);
        int minValue = (int) -Math.pow(2,31);
        if(str.substring(0, lastIndex).length() > String.valueOf(maxValue).length()) {
            if("-".equals(resultStr)) {
                return minValue;
            } else {
                return maxValue;
            }
        }

        Long resultLong = Long.parseLong(resultStr + str.substring(0, lastIndex));

        if(minValue > resultLong) {
            return minValue;
        } else if(maxValue < resultLong) {
            return maxValue;
        } else {
            return resultLong.intValue();
        }
    }

}
