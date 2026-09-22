package com.example.leetcodedemo.JianZhiOffer.JZ55;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/20
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Demo_01 {
    //  首先定义  含义： 返回树的最大长度
    public int TreeDepth(TreeNode root) {
        //空节点没有深度
        if(root == null)
            return 0;
        //返回子树深度+1
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
