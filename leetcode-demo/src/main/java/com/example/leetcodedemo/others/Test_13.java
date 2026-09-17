package com.example.leetcodedemo.others;

import java.util.*;

/**
 * 给定一个大小为 n 的整数数组 nums，找出其中所有出现次数超过 ⌊n / 3⌋ 次的元素。
 */
public class Test_13 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 2, 1, 1};

        List<Integer> result = majorityElement(nums);

        System.out.println(result);
    }

    public static List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0;
        int count2 = 0;

        // 第一遍：寻找两个候选人
        for (int num : nums) {

            if (count1 > 0 && num == candidate1) {
                count1++;

            } else if (count2 > 0 && num == candidate2) {
                count2++;

            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;

            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;

            } else {
                count1--;
                count2--;
            }
        }

        // 第二遍：验证候选人的真实出现次数
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}
