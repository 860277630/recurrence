package com.example.leetcodedemo.others;

import java.util.*;

/**
 * **Java题：０７０４：**
 *
 * 在一个目录树中（假设都是目录），过深的目录路径不容易展示，为了提升用户体验，需要对目录进行收缩展示，求收缩后某一深度的目录个数。
 *
 * 如图所示，原目录树及收缩后示意：
 *
 *   root                    root
 *
 *   ├ B                     ├ B/C/E
 *
 *   │ └ C                   │ ├ N
 *
 *   │   └ E                 │ └ M
 *
 *   │     ├ N               └ F
 *
 *   │     └ M                 ├ H
 *
 *   └ F                         └ X/i
 *
 *     ├ H
 *
 *     └ X
 *
 *      └ i
 *
 * 收缩规则：
 *
 * •         若某目录仅有一个子目录，则把这个子目录收缩到其父目录，展示为一个新目录。如图所示，i 收缩到 X 变成新的目录 X/i。
 *
 * •        所有符合上述条件的均需收缩，收缩后符合上述条件的继续收缩，直到无法收缩。如图所示，目录B、C、E收缩为新的目录 B/C/E
 *
 * 现给定一个原目录树 orgTree，请按照收缩规则展示为一个新目录树，求新目录树中深度值为 depth（根节点深度为 1）的节点个数。
 *
 * 如图所示，收缩后深度为 2 的节点有 2 个（B/C/E、F），深度为 3 的节点有 4 个（N、M、H、X/i）。
 *
 * 输入
 *
 * 一个整数 num，表示父子节点对的数量，1 <= num <= 300
 *
 * 接下来 num 行表示 orgTree，每行一个父子节点对，格式为父节点 子节点，节点名称仅含字母或数字，长度 [1,10]
 *
 * 最后一行一个整数 depth，1 <= depth <= 300
 *
 * 树只有一个根，首个节点对的父节点为根。
 *
 * 树上各节点名称是全局唯一的。
 *
 * 每个节点下的子节点不超过10个。
 *
 * 输出
 *
 * 一个整数，表示收缩后深度为 depth 的节点个数
 *
 * 样例
 *
 * 输入样例 1
 *
 * 9
 *
 * root B
 *
 * root F
 *
 * C E
 *
 * B C
 *
 * E N
 *
 * F H
 *
 * F X
 *
 * E M
 *
 * X i
 *
 * 3
 *
 * 输出样例 1
 *
 * 4
 *
 * 提示样例 1
 *
 * 输入数据表示的原目录树，及收缩示意如题面图示，深度为 3 的节点有 4 个（N、M、H、X/i）
 *
 * 输入样例 2
 *
 * 3
 *
 * 1 B123456789
 *
 * B123456789 c
 *
 * 1 b123456789
 *
 * 3
 *
 * 输出样例 2
 *
 * 0
 *
 * 提示样例 2
 *
 * 原目录树收缩后，不存在深度为 3 的节点，因此返回 0
 *
 * 输入样例 3
 *
 * 4
 *
 * A B
 *
 * B C
 *
 * C D
 *
 * D E
 *
 * 1
 *
 * 输出样例 3
 *
 * 1
 *
 * 提示样例 3
 *
 * 收缩显示为一个节点 A/B/C/D/E，深度 1 的节点数为 1
 */
public class Test_10 {
    public static void main(String[] args) {

        // 样例1
        String[][] orgTree = {
                {"root", "B"},
                {"root", "F"},
                {"C", "E"},
                {"B", "C"},
                {"E", "N"},
                {"F", "H"},
                {"F", "X"},
                {"E", "M"},
                {"X", "i"}
        };

        int depth = 3;

        int result = getCount(orgTree, depth);

        System.out.println(result); // 4
    }

    /**
     * 计算目录收缩后，指定深度的节点数量
     */
    public static int getCount(String[][] orgTree, int targetDepth) {

        Map<String, List<String>> tree = new HashMap<>();

        // 题目说明：第一个父子节点对的父节点就是根
        String root = orgTree[0][0];

        // 1. 构造树
        for (String[] pair : orgTree) {
            String parent = pair[0];
            String child = pair[1];

            tree.computeIfAbsent(parent, k -> new ArrayList<>())
                    .add(child);
        }

        // 2. DFS
        return dfs(tree, root, 1, targetDepth);
    }

    private static int dfs(Map<String, List<String>> tree,
                           String node,
                           int currentDepth,
                           int targetDepth) {

        // 连续只有一个子节点，就进行收缩
        while (tree.getOrDefault(node, Collections.emptyList()).size() == 1) {
            node = tree.get(node).get(0);
        }

        // 当前收缩后的节点正好位于目标深度
        if (currentDepth == targetDepth) {
            return 1;
        }

        if (currentDepth > targetDepth) {
            return 0;
        }

        int count = 0;

        // 有多个子节点，进入下一层
        for (String child :
                tree.getOrDefault(node, Collections.emptyList())) {

            count += dfs(tree, child, currentDepth + 1, targetDepth);
        }

        return count;
    }
}
