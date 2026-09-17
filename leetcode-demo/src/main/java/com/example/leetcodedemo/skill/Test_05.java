package com.example.leetcodedemo.skill;

public class Test_05 {
    //  测试快排
    public static void main(String[] args) {
        int a[] = {
                73, 12, 98, 45, 67, 23, 89, 10, 56, 34,
                78, 91, 5, 43, 66, 21, 87, 14, 39, 100,
                2, 58, 76, 19, 84, 33, 61, 8, 95, 27,
                70, 16, 50, 92, 41, 63, 6, 88, 25, 54,
                11, 80, 37, 69, 4, 97, 29, 82, 18, 47,
                60, 7, 75, 31, 86, 13, 57, 22, 99, 35,
                68, 9, 44, 72, 26, 81, 15, 52, 96, 28,
                64, 3, 77, 20, 53, 90, 36, 71, 17, 49
        };

        quickSort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    // 快排
    public static void quickSort(int[] nums,int left, int right){
        //  终止条件
        if(left>= right)return;
        int i,j,p;
        i = left;
        j = right;
        // 先把最左边的拿出来
        p = nums[i];
        //  然后开始把小的 放左边  大的放右边
        while(i<j){
            //  首先从 最右边开始
            while(i<j && nums[j]> p)
                j--;
            //  这里对上述的临界条件进行处理
            if(i<j){
                //  就把上述冲破循环的  数据进行处理 移动到 i 的下标上
                nums[i++] = nums[j];
            }
            //  然后从左边开始
            while(i< j && nums[i]<p){
                i++;
            }
            //  然后处理上述冲破条件的临界值进行处理
            if(i<j){
                nums[j--] = nums[i];
            }
        }
        //  最后把拿出来的填写到i的位置上
        nums[i] = p;
        //  进行递归处理
        quickSort(nums,i+1,right);
        quickSort(nums,left,i-1);
    }
}
