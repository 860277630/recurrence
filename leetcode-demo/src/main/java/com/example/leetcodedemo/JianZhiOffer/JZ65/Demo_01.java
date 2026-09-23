package com.example.leetcodedemo.JianZhiOffer.JZ65;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/22
 */

public class Demo_01 {
    public int Add(int num1,int num2) {
        //  使用位运算  进行
        int sum = num1;
        int add = num2;
        while(add!=0){
            //  首先进行  与运算  算出 在不进位情况下  应该是多少
            int temp = sum ^ add;
            //  然后计算进位
            add = (sum & add)<<1;

            sum = temp;

        }
        return sum;
    }
}
