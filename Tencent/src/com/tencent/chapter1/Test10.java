package com.tencent.chapter1;

/**
 * @author wangsen
 * @create 2018-09-16 13:06
 * title 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点
 * 分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class Test10 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height) {
        if( height.length  < 0) {
            return 0;
        }
        int width = height.length - 1;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(width > 0 && left != right) {
            // 两端值取较小的值
            int minNum = height[left] > height[right] ? height[right] : height[left];
            int newArea = minNum * width;
            // 记录每移动一步的 Area 值，将较大的存储下来
            maxArea = maxArea < newArea ?  newArea : maxArea;
            // 哪边值小，则哪边移动
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            width--;
        }

        return maxArea;
    }
}
