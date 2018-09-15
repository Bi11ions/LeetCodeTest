package com.tencent.chapter1;

/**
 * @author wangsen
 * @create 2018-09-15 10:06
 * title 删除排序数组中的重复项
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Test9 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,3,3,3,3,3};
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {

        if(nums == null || nums.length < 1) {
            return 0;
        }
        // 标记不同数字的个数
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }

        // 因为从 0 开始判断，则最后应该再 +1, 并且在只输入长度为1的数组时，最后返回数字个数也应该为1，而不是为 0
        number += 1;

        return  number;
    }
}
