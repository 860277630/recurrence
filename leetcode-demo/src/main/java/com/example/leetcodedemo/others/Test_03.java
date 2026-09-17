package com.example.leetcodedemo.others;

import java.util.*;

/**
 * 给两个数组 A 和 B，分别取一个数，找到 两数之差的绝对值最小，即 |A[i] - B[j]| 最小
 */
public class Test_03 {
    public static void main(String[] args) {
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};

        System.out.println(minDifference(a, b));
    }
    public static int minDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {
            int diff = Math.abs(a[i] - b[j]);
            min = Math.min(min, diff);

            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                return 0; // 已经是最小可能值
            }
        }

        return min;
    }
}
