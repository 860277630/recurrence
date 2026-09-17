package com.example.leetcodedemo.recurrence.二叉树;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 构造如下二叉树：
     *
     *               0
     *             /   \
     *            1     2
     *          /  \   / \
     *         3    4 5   6
     *          \
     *           7
     *
     * 前序遍历（根左右）：
     * 0 1 3 7 4 2 5 6
     *
     * 中序遍历（左根右）：
     * 3 7 1 4 0 5 2 6
     *
     * 后序遍历（左右根）：
     * 7 3 4 1 5 6 2 0
     *
     * 层序遍历（BFS）：
     * 0 1 2 3 4 5 6 7
     */
    public static TreeNode initNode(){
        // 先初始化最底层的
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node3 = new TreeNode(3, null, node7);
        TreeNode node1 = new TreeNode(1, node3, node4);
        TreeNode node2 = new TreeNode(2, node5, node6);
        TreeNode node0 = new TreeNode(0, node1, node2);
        return node0;
    }
}
