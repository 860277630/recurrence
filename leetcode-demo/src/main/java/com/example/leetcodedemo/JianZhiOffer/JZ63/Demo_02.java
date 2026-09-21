package com.example.leetcodedemo.JianZhiOffer.JZ63;

public class Demo_02 {
    public static void main(String[] args) {
        int[] nums = new int[]{8,9,2,5,4,7,1};
        //int[] nums = new int[]{9,8,7,6,5,4,3,2,1};
        int profit  = maxProfit(nums);
        System.out.println(profit);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public static int maxProfit (int[] prices) {
        // write code here
        //  单层循环   动态规划解法  从第一天开始蔓延  向后推  dp  数组表示当前的收益
        //  0表示 手中不持有的收益    1表示手中持有的收益
        int[][] dp = new int[prices.length][2];

        // 确定初始状态
        dp[0][0] = 0;
        dp[0][1] = -1* prices[0];

        //  然后  遍历  prices 数组  并记录  每个节点的 收益
        for (int i = 1; i < prices.length; i++) {
            //  第 i 天 手中不持有  ： 要么是昨天不持有  今天继续不持有  要么是昨天持有  今天卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //  第 i 天 手中持有：  要么是 今天什么都没做，昨天持有  要么是今天持有的 昨天未持有
            // 注意是只买一次  不是买卖很多次
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }
        //  返回最后一天未持有
        return dp[prices.length-1][0];
    }
}
