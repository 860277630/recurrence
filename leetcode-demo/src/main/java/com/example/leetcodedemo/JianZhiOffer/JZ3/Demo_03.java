package com.example.leetcodedemo.JianZhiOffer.JZ3;

public class Demo_03 {
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
        for(int i =0; i<numbers.length;i++){
            while(i!=numbers[i]){
                //  发生碰撞
                if(numbers[i]==numbers[numbers[i]]){
                    return numbers[i];
                }
                //  否则就进行交换 因为 是0~n-1 要么交换到 要么重复
                int k = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = k;
            }
        }
        return res;
    }
}
