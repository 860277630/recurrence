package com.example.leetcodedemo.JianZhiOffer.JZ13;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static List<int[]> hasComeSet = new ArrayList<>();

    public int movingCount(int threshold, int rows, int cols) {
        //  从0点开始进行深度优先搜索  返回格子数
        getCount(threshold, 0, 0, rows, cols);
        return hasComeSet.size();
    }


    private  void getCount(int threshold, int rowIndex, int colIndex, int rows,
                           int cols) {
        //  不能出边界  且 不能大于阈值  并且是没来过的
        if (rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols
                || (getSum(rowIndex) + getSum(colIndex)) > threshold
                || hasCome(rowIndex, colIndex)) {
            return;
        }

        int[] nums = new int[]{rowIndex,colIndex};
        hasComeSet.add(nums);
        // 然后开始遍历
        getCount(threshold, rowIndex, colIndex + 1, rows, cols);
        getCount(threshold, rowIndex, colIndex - 1, rows, cols);
        getCount(threshold, rowIndex + 1, colIndex, rows, cols);
        getCount(threshold, rowIndex - 1, colIndex, rows, cols);
    }



    private int  getSum(int num) {
        return num % 10 + num / 10;
    }

    private boolean hasCome(int rowIndex, int colIndex) {
        for(int i = 0; i< hasComeSet.size(); i++){
            int[] nums = hasComeSet.get(i);
            if(nums[0]==rowIndex&&nums[1]==colIndex){
                return true;
            }
        }
        return false;
    }
}