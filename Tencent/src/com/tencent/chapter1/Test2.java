package com.tencent.chapter1;

import sun.applet.Main;
import sun.security.util.Length;

/**
 * @author wangsen
 * @create 2018-09-08 10:44
 *
 * Title 两个排序数组的中位数
 *      给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *      请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *      你可以假设 nums1 和 nums2 不同时为空。
 */
public class Test2 {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2,3};

        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        double length = nums1.length + nums2.length;
        int[] resultArray = new int[(int) length];

        double result = 0;
        if(nums1.length > 0 && nums2.length > 0) {
            while(i < nums1.length && j < nums2.length) {
                if(nums1[i] <= nums2[j]) {
                    resultArray[k++] = nums1[i++];
                    continue;
                }
                resultArray[k++] = nums2[j++];
            }
            if(i < nums1.length) {
                while (i < nums1.length) {
                    resultArray[k++] = nums1[i++];
                }
            }
            if(j < nums2.length) {
                while (j < nums2.length) {
                    resultArray[k++] = nums2[j++];
                }
            }
        } else if(nums1.length > 0) {
            if(i < nums1.length) {
                while (i < nums1.length) {
                    resultArray[k++] = nums1[i++];
                }
            }
        } else if(nums2.length > 0){
            if(j < nums2.length) {
                while (j < nums2.length) {
                    resultArray[k++] = nums2[j++];
                }
            }
        }


        if(resultArray.length % 2 == 0) {
            result = (double) (resultArray[resultArray.length/2 - 1] + resultArray[resultArray.length/2]) / 2;
            return result;
        }

        result = resultArray[(int) Math.floor(length / 2)];
        return result;
    }

}
