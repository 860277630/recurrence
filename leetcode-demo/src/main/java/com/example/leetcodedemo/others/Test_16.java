package com.example.leetcodedemo.others;

import java.util.*;

/**
 * 数字全排列：递归 + 回溯 + 交换
 * 输入：
 * [1, 2, 3]
 *
 * 输出：
 * [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 2, 1]
 * [3, 1, 2]
 */
public class Test_16 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = permute(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result);

        return result;
    }

    private static void backtrack(int[] nums,
                                  int index,
                                  List<List<Integer>> result) {

        // 所有位置都确定了
        if (index == nums.length) {

            List<Integer> list = new ArrayList<>();

            for (int num : nums) {
                list.add(num);
            }

            result.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // 1. 选择
            swap(nums, index, i);

            // 2. 递归确定下一个位置
            backtrack(nums, index + 1, result);

            // 3. 撤销选择
            swap(nums, index, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
