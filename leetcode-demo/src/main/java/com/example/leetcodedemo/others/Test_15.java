package com.example.leetcodedemo.others;

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

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        // 遍历整个二维数组
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // 找到一个还没有访问过的油田
                if (grid[i][j] == '@') {

                    count++;

                    // 把和它连在一起的所有 @ 都处理掉
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int row, int col) {

        // 越界
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length) {
            return;
        }

        // 不是油田，或者已经访问过
        if (grid[row][col] != '@') {
            return;
        }

        // 标记为已经访问
        grid[row][col] = '*';

        // 上
        dfs(grid, row - 1, col);

        // 下
        dfs(grid, row + 1, col);

        // 左
        dfs(grid, row, col - 1);

        // 右
        dfs(grid, row, col + 1);

        // 左上
        dfs(grid, row - 1, col - 1);

        // 右上
        dfs(grid, row - 1, col + 1);

        // 左下
        dfs(grid, row + 1, col - 1);

        // 右下
        dfs(grid, row + 1, col + 1);
    }
}
