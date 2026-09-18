package com.example.leetcodedemo.others_pratice.others;

/**
 * 输入一个 m × n 的字符矩阵，统计字符 @ 组成的多少个连块。
 * 如果两个 @ 所在格子相邻（横、竖或者对角线方向），就属于同一个连块。
 */
public class Test_15 {
    public static void main(String[] args) {

        char[][] grid = {
                {'*', '*', '*', '@', '@'},
                {'@', '@', '@', '*', '@'},
                {'@', '*', '*', '@', '@'},
                {'@', '@', '@', '*', '@'},
                {'@', '@', '*', '*', '@'}
        };

        int result = countOilFields(grid);

        System.out.println(result); // 2
    }

    public static int countOilFields(char[][] grid) {
        return 0;
    }

    private static void dfs(char[][] grid, int row, int col) {

    }
}
