package com.example.leetcodedemo.others;

import java.util.*;

/**
 * 算法题1
 * 题目描述：为了达到新冠疫情精准防控的需要，为了避免全员核酸检测带来的浪费，需要精准圈定可能被感染的人群。
 * 现在根据传染病流调以及大数据分析，得到了每个人之间在时间、空间上是否存在轨迹的交叉。
 * 现在给定一组确诊人员编号（X1,X2,X3,....Xn）,在所有人当中，找出哪些人需要进行核酸检测，输出需要进行核酸检测的人数。（注意：确诊病例自身不需要
 * 再做核酸检测）
 * 需要进行核酸检测的人，是病毒传播链条上的所有人员，即有可能通过确诊病例所能传播到的所有人。
 * 例如：A是确诊病例，A和B有接触、B和C有接触、C和D有接触、D和E有接触，那么B\C\D\E都是需要进行核酸检测的人。
 * 输入描述：第一行为总人数N
 * 第二行为确诊病例人员编号（确诊病例人员数量<N），用逗号分割
 * 第三行开始，为一个N*N的矩阵，表示每个人员之间是否有接触，0表示没有接触，1表示有接触。
 * 输出描述：整数：需要做核酸检测的人数
 * 补充说明：人员编号从0开始
 * 0<N<100：
 */
public class Test_02 {
    public static void main(String[] args) {
        int n = 5;

        int[] confirmed = {0};

        int[][] matrix = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}
        };

        System.out.println(getTestCount(n, confirmed, matrix));
    }


    public static int getTestCount(int n, int[] confirmed, int[][] matrix) {

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // 1. 所有确诊人员作为 BFS 起点
        for (int person : confirmed) {
            visited[person] = true;
            queue.offer(person);
        }

        // 2. BFS 找到传播链上的所有人
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < n; i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        // 3. 统计所有被访问的人
        int count = 0;

        for (boolean v : visited) {
            if (v) {
                count++;
            }
        }

        // 排除确诊病例本人
        return count - confirmed.length;
    }
}
