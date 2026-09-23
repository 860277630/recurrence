package com.example.leetcodedemo.JianZhiOffer.JZ69;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/22
 */

public class Demo_02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param number int整型
     * @return int整型
     */
    public int jumpFloor (int number) {
        // write code here
        // 首先就是
        // 1级台阶  只有一种跳法
        // 2级台阶  有两种跳法
        int[] dp = new int[number];
        dp[0] = 1;
        dp[1] = 2;
        // dp[n] = dp[n-2] * dp[1] + dp[n-1]
        for(int i = 2 ; i < number; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[number-1];
    }
}
