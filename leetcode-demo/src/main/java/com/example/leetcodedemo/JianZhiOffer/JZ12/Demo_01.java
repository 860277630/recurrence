package com.example.leetcodedemo.JianZhiOffer.JZ12;

public class Demo_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        //  使用回溯法  找到就用递归一直找下去  找不到就返回
        char[] words = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 然后就去找对应的字段
                boolean res = dfs(matrix, words, i, j, 0);
                if (res)return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, char[] words, int i, int j, int index) {
        //  首先不能越界且  且能找到下标对应的元素  否则返回
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ||
                matrix[i][j] != words[index]) {
            return false;
        }
        //  遍历过的修改标记
        char temp = matrix[i][j];
        matrix[i][j] = '.';
        //  如果  长度达到 了 寻找字段的长度  那就返回true
        if (index == words.length - 1) {
            return true;
        }
        //  然后就去深度优先搜索  分四个方向
        boolean res =    dfs(matrix, words, i, j + 1, index + 1)
                || dfs(matrix, words, i, j - 1, index + 1)
                || dfs(matrix, words, i + 1, j, index + 1)
                || dfs(matrix, words, i - 1, j, index + 1);
        matrix[i][j] =  temp;
        return res;

    }
}
