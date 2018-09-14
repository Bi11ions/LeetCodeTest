package com.tencent.chapter1;

import java.util.Arrays;

/**
 * @author wangsen
 * @create 2018-09-14 13:43
 * title  最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class Test7 {

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int sum = threeSumClosest(nums, 1);
        System.out.println(sum);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int minDistance = Integer.MAX_VALUE;
        Arrays.sort(nums);

        // 到最后三个，使用 i 为右边坐标，j 为左边坐标，k 为中间游动的坐标
        for (int i = 0; i < nums.length - 2; i++) {
            int j = nums.length - 1;
            int k = i + 1;
            while (k < j) {
                int temp_sum = nums[i] + nums[j] + nums[k];
                int temp_distance = Math.abs(temp_sum - target);
                if (temp_distance < minDistance) { // 若小于最小距离，则替换原数据
                    sum = temp_sum;
                    minDistance = temp_distance;
                }

                if (temp_sum < target) { // 若和小于目标值，则移动中间坐标向右移动
                    k++;
                } else if (temp_sum > target) { // 若大于目标值，则移动右边坐标向左边移动
                    j-- ;
                } else {
                    return nums[i] + nums[j] + nums[k]; // 若与目标值相等，则因为最小距离值，直接返回
                }
            }
        }
        return sum;
    }

}
