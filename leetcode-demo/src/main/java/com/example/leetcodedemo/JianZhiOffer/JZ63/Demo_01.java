package com.example.leetcodedemo.JianZhiOffer.JZ63;

public class Demo_01 {

    public static void main(String[] args) {
        int[] nums = new int[]{8,9,2,5,4,7,1};
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
        int maxProfit = 0;
        //  双层暴力 for循环  复杂度  o(n²)
        for (int i = 0; i < prices.length - 1; i++) {
            int tempNum = prices[i] * (-1);
            for(int j  = i+1; j< prices.length ; j++){
                //  找到最大利润
                int profit = tempNum + prices[j];
                maxProfit = Math.max(profit,maxProfit);
            }
        }
        return maxProfit;
    }
}
