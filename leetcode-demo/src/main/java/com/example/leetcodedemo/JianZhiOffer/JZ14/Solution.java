package com.example.leetcodedemo.JianZhiOffer.JZ14;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(cutRope(5));
    }

    public static int cutRope(int target) {
        //不超过3直接计算
        if (target <= 3)
            return target - 1;
        //dp[i]表示长度为i的绳子可以被剪出来的最大乘积
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        //遍历后续每一个长度
        for (int i = 5; i <= target; i++)
            //可以被分成两份
            for (int j = 1; j < i; j++)
            //取最大值
            {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
                System.out.println(dp[i]);
            }
        return dp[target];
    }
}
