package com.example.leetcodedemo.others;

/**
 * n个数，向左或者向右取，每次只能取一个，直到取出的数之和是目标值target，求最小取出次数
 */
public class Test_12 {
    public static void main(String[] args) {

        int[] nums = {1, 1, 4, 2, 3};
        int target = 5;

        System.out.println(minOperations(nums, target));
    }

    public static int minOperations(int[] nums, int target) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // 中间需要留下的和
        int remain = total - target;

        if (remain < 0) {
            return -1;
        }

        // target == total，全部取走
        if (remain == 0) {
            return nums.length;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        // 寻找和为 remain 的最长连续子数组
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > remain && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == remain) {
                maxLength = Math.max(
                        maxLength,
                        right - left + 1
                );
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return nums.length - maxLength;
    }
}
