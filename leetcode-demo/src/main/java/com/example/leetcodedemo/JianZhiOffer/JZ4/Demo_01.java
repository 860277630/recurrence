package com.example.leetcodedemo.JianZhiOffer.JZ4;

public class Demo_01 {

    public static void main(String[] args) {
        int num = 16;
        int[][] array = new int[][]{{}};
        Find(num,array);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param target int整型
     * @param array int整型二维数组
     * @return bool布尔型
     */
    public static boolean Find (int target, int[][] array) {
        if(array.length == 0||array[0].length == 0){return false;}
        for(int i =0;i<array.length;i++){
            // 找区间  最大值和最小值
            int[] temp = array[i];
            int leftnum = temp[0];
            int rightnum = temp[temp.length-1];
            if(target>=leftnum&&target<=rightnum){
                //  就进行二分查找
                int left = 0;
                int right = temp.length-1;
                while(left<=right){
                    //  获取中间值
                    int mid = (left+right)/2;
                    int midnum = temp[mid];
                    if(midnum == target){
                        return true;
                    }else if(midnum>target){
                        right = mid-1;
                    }else if(midnum<target){
                        left = mid+1;
                    }
                }
            }

        }
        return false;
    }
}
