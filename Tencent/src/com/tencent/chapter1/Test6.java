package com.tencent.chapter1;

import java.util.*;

/**
 * @author wangsen
 * @create 2018-09-14 12:20
 * title 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class Test6 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        if (lists != null) {
            for (List<Integer> list : lists) {
                System.out.println(Arrays.toString(list.toArray()));
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 ) {
                break;
            }
            // 对第一层元素进行去重
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // j 从后往前的进行下标递减
            int j = nums.length - 1;
            int k = i + 1;
            while (k < j) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> item = Arrays.asList(nums[i], nums[j], nums[k]);
                    resultList.add(item);
                    // 对第二层和第三层元素进行去重
                    while (k < j && nums[k] == nums[k+1]) {
                        k++;
                    }
                    while(k < j && nums[j] == nums[j-1]) {
                        j--;
                    }
                    k++;
                    j--;
                } else if(nums[k] + nums[j] + nums[i] < 0) {
                    k++;
                } else {
                    j--;
                }
            }
        }

        return resultList;
    }

}
