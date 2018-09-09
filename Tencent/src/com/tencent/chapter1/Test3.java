package com.tencent.chapter1;

/**
 * @author wangsen
 * @create 2018-09-09 13:36
 * Title 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */
public class Test3 {

    public static void main(String[] args) {
        String s = "cbbd";
        String result = manacher(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 0) {
            return "";
        }
        // 将字符串转化为字符数组
        char[] charArray = s.toCharArray();
        // dp[i][j] 表示从 s[i] 到 s[j] 结尾的回文子串的长度, 若该字符串不是子串，则使 dp[i][j] = 0
        int[][] dp = new int[length][length];
        // 最长子串长度
        int maxLen = 1;
        // 子串起始坐标
        int start = 0;

        // 因为 j >= i 所以，只需要添加矩阵的下三角即可，对角线表示 i == j, 此时 dp[i][j] 应该为 1
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else if (i - j == 1) {
                    if (charArray[i] == charArray[j]) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    // 在子串长度不为零的情况下增加长度 -> dp[i - 1][j + 1] != 0
                    if (charArray[i] == charArray[j] && dp[i - 1][j + 1] != 0) {
                        // 在中间子串的长度上再 + 2 因为左右两边向外拓展了一个
                        dp[i][j] = dp[i - 1][j + 1] + 2;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                // 如果最大长度改变，更新最大长度和起始位置
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                    start = j;
                    if (maxLen == length) {
                        return s.substring(start, start + maxLen);
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * manacher 算法
     * @param s
     * @return
     */
    public static String manacher(String s) {
        int length = s.length();
        // 1. 转换字符串
        char[] charArray = s.toCharArray();
        char[] newCharArr = new char[length * 2 + 1];

        int k = 0;
        for (char c : charArray) {
            newCharArr[k++] = '#';
            newCharArr[k++] = c;
        }
        newCharArr[k] = '#';

        /*
         * manacher 算法所需要使用的数据结构
         *      maxR -> 对称子串距离最右侧的距离,
         *      position 对称子串对称轴,
         *      maxLength -> 最大长度
         *      RL[i] 回文半径数组，表示以第 i 个字符为对称轴的回文字符串的回文半径
         */
        double start = 0;
        int maxR = 0;
        int position = 0;
        int maxLength = 0;
        int[] RL = new int[newCharArr.length];

        for (int i = 0; i < newCharArr.length; i++) {
            int j = 2 * position - i;
            if(i < maxR) {
                RL[i] =  maxR - i < RL[j] ? maxR - i : RL[j];
            } else {
                RL[i] = 1;
            }

            while(i + RL[i] <newCharArr.length && i - RL[i] >= 0 && newCharArr[i - RL[i]] == newCharArr[i + RL[i]]) {
                RL[i]++;
            }

            if(RL[i] + i > maxR) { // 更新 position 和 maxR 的值
                maxR = i + RL[i];
                position = i;
            }
            if(RL[i] - 1 > maxLength) {
                start = Math.ceil((i - RL[i]) / 2.0);
                maxLength = RL[i] - 1;
            }
        }

        return s.substring((int)start, (int) start+maxLength);
    }

}
