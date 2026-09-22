package com.example.leetcodedemo.JianZhiOffer.JZ53;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/20
 */

public class Demo_02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param k int整型
     * @return int整型
     */
    public int GetNumberOfK (int[] nums, int k) {
        // write code here
        int res = 0;
        for (int num : nums) {
            if(num==k){
                res++;
            }
            // 如果大就直接返回
            if(num>k){
                return res;
            }
        }
        return res;
    }
}
