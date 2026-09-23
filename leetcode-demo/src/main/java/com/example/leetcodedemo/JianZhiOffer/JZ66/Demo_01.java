package com.example.leetcodedemo.JianZhiOffer.JZ66;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/22
 */

public class Demo_01 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5};
        multiply(A);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A int整型一维数组
     * @return int整型一维数组
     */
    public static int[] multiply (int[] A) {
        // write code here
        int[] B = new int[A.length];
        //  然后  进行计算
        for (int i = 0; i < B.length; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if(i!=j){
                    if(sum == 0){
                        sum = A[j];
                    }else{
                        sum = sum * A[j];
                    }
                }
            }
            B[i] = sum;
            System.out.printf(String.valueOf(sum)+"======");
        }
        return B;
    }
}
