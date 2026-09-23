package com.example.leetcodedemo.JianZhiOffer.JZ71;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/22
 */

public class Demo_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param target int整型
     * @return int整型
     */
    public int jumpFloorII(int target) {
        int[] dp = new int[target + 1];
        //初始化前面两个
        dp[0] = 1;
        dp[1] = 1;
        //依次乘2
        for(int i = 2; i <= target; i++)
            dp[i] = 2 * dp[i - 1];
        return dp[target];
    }
}
