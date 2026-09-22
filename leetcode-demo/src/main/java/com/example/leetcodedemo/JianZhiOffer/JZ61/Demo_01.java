package com.example.leetcodedemo.JianZhiOffer.JZ61;

import java.util.*;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/20
 */

public class Demo_01 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,2,6,4};
        System.out.println(IsContinuous(nums));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return bool布尔型
     */
    public static boolean IsContinuous (int[] numbers) {
        // write code here
        int count = 0;
        int lastNum = -1;
        // 先进行排序
        Arrays.sort(numbers);
        // 然后 统计灵活数字（0）的个数
        for(int i = 0; i < numbers.length ; i++){
            int tempNum = numbers[i];
            if(tempNum == 0){
                count ++;
            }
            else if (lastNum == -1){
                // 如果等于 -1
                lastNum = numbers[i];
            }else{
                // 如果即不是0  也不是开头  那么  就进行比较
                int gap = tempNum - lastNum;
                lastNum = tempNum;
                if(gap > 1){
                    //  如果gap大于1  就看  是否能用  0来进行弥补
                    if(count + 1 - gap >=0){
                        count -=gap;
                        //  然后进行下一个
                    }
                    //  如果count 不足以 弥补
                    else{
                        return false;
                    }

                }
            }

        }
        return true;
    }
}
