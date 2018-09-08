package com.tencent.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangsen
 * @create 2018-09-08 9:02
 *
 * title : 两数之和
 *      给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *      你可以假设每想个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 第一天提交
 */
public class Test1 {

    public static void main(String[] args) {

        // Given an array of integers
        int[] nums = new int[]{3, 2, 4};

        int[] result = twoSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 保存已经使用过的节点的 index
        List<Integer> flagList = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (flagList.contains(i)) {
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    if (flagList.contains(j)) {
                        continue;
                    }
                    int[] result = new int[]{i,j};
                    return result;
                }
            }
        }

        return null;
    }

}

