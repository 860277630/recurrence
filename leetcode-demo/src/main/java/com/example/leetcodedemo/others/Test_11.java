package com.example.leetcodedemo.others;

import java.util.*;

/**
 * 下一个更大元素
 *
 * 题目描述
 *
 * 给定一个循环数组 nums(nums[nums.length-1] 的下一个元素是 nums[0])，返回nums中每个元素的下一个更大元素。
 *
 * 数字x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出﹣1。
 *
 * 示例1
 *
 * 输入：nums=[1.2.1]
 *
 * 输出：[2,-1.2)
 *
 * 解释： 第一个1的下一个更大的数是2:
 *
 * 数字2找不到下一个更大的数：
 *
 * 第二个1的下一个最大的数需要循环搜索，结果也是2
 *
 * 示例2:
 *
 * ]
 *
 * 输入：nums=[1.2.3.4,3]
 *
 * 输出：[2,3.4,-1.4]
 *
 * 示例3:
 *
 * #: nums = [7, 5,9. 8, 3, 10. 7. 7]
 *
 * 输出：[9,9,10,10,10,-1.9,9]
 */
public class Test_11 {
    public static void main(String[] args) {

        int[] nums = {7, 5, 9, 8, 3, 10, 7, 7};

        int[] result = nextGreaterElements(nums);

        System.out.println(Arrays.toString(result));
    }

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        // 栈里面保存下标
        Stack<Integer> stack = new Stack<>();

        // 循环数组，所以遍历两遍
        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            // 当前数字比栈顶数字大
            // 说明找到了栈顶元素的“下一个更大元素”
            while (!stack.isEmpty()
                    && nums[index] > nums[stack.peek()]) {

                int oldIndex = stack.pop();
                result[oldIndex] = nums[index];
            }

            // 第二遍不再入栈
            if (i < n) {
                stack.push(index);
            }
        }

        return result;
    }
}
