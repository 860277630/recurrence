package com.example.leetcodedemo.others;

/**
 * · /**
 *
 * ·  * 求最大的工作量。
 *
 * ·  * 某人定制了自已代码编写计划如下数据组a, 每天会完成对应每个元素的工作量。
 *
 * ·  * 如a=[10，11，12，13，14，15，16],但他不能每天都能参与代码的编写，
 *
 * ·  * 可能有几天需要做别的事情，所以有可能有时是没有写代码的，
 *
 * ·  * 如下是他的每天的计划b[1， 0， 1， 0， 1，0，1]（1表示工作，0表示休息），
 *
 * ·  * 但由于工期的问题，允许他可以有一次在n天内是可以连续工作的，这n天内原计划休息的也可以进行工作，
 *
 * ·  * 求他的这段时间内（a.size）最大可能的工作总量，如n=3时
 *
 * ·  * 集中生产设为3天，当第[3, 4, 5] 天进行连续生产时产量可达最大化，10 + 12 + 13 + 14 + 15 + 16 = 80
 *
 * ·  * private static int getMaxQuantity(int[] a, int[] b, int n) {
 *
 * ·  *
 *
 * ·  * }
 *
 * ·  * [10，11，12，13，14，15，16] 52
 *
 * ·  * [1，  0， 1， 0， 1，0，1]
 *
 * ·  
 */
public class Test_08 {
    public static void main(String[] args) {

        int[] a = {10, 11, 12, 13, 14, 15, 16};
        int[] b = {1,  0,  1,  0,  1,  0,  1};

        System.out.println(getMaxQuantity(a, b, 3));
    }
    private static int getMaxQuantity(int[] a, int[] b, int n) {

        int base = 0;

        // 1. 原计划能够完成的工作量
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 1) {
                base += a[i];
            }
        }

        // 2. 计算第一个长度为 n 的窗口
        int extra = 0;

        for (int i = 0; i < n; i++) {
            if (b[i] == 0) {
                extra += a[i];
            }
        }

        int maxExtra = extra;

        // 3. 滑动窗口
        for (int right = n; right < a.length; right++) {

            // 右边元素进入窗口
            if (b[right] == 0) {
                extra += a[right];
            }

            // 左边元素离开窗口
            int left = right - n;

            if (b[left] == 0) {
                extra -= a[left];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        return base + maxExtra;
    }
}
