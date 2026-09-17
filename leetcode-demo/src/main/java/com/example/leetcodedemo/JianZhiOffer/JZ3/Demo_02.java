package com.example.leetcodedemo.JianZhiOffer.JZ3;

import java.util.HashSet;
import java.util.Set;

public class Demo_02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        // write code here
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length; i++){
            if(set.contains(numbers[i])){
                return numbers[i];
            }
            set.add(numbers[i]);
        }
        return res;
    }
}
