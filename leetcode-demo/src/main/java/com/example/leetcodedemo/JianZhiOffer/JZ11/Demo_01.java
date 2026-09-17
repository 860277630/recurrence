package com.example.leetcodedemo.JianZhiOffer.JZ11;

public class Demo_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberInRotateArray (int[] nums) {
        // write code here
        int res = nums[0];
        //  然后顺着找  找到 突然变小的那个就是  没找到就是第一个
        for(int i = 0; i< nums.length-1;i++){
            if(nums[i+1]<nums[i]){
                return nums[i+1];
            }
        }
        return res;
    }
}
