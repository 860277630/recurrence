package com.example.leetcodedemo.JianZhiOffer.JZ63;

public class Demo_03 {
    public static void main(String[] args) {
        //int[] nums = new int[]{8,9,2,5,4,7,1};
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1};
        int profit  = maxProfit(nums);
        System.out.println(profit);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     *  贪心算法： 一直去找更小的值  一直去更新  最小的值并且在找的过程中  更新最大的差值
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public static int maxProfit (int[] prices) {
        // write code here
        //  单层循环   贪心算法  （永远只找最小值）
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            //  买卖不能在同一天  所以  买入了  取了最小值    就不能  卖出了  去找最大值
            int tempNum = prices[i];
            if(min<tempNum){
                // 买入了
                min = tempNum;
            }else{
                //  没有买入  就可以卖出 了
                max = Math.max(max,prices[i] - min);
            }
        }
        return max;
    }
}
