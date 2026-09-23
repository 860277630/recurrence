package com.example.leetcodedemo.JianZhiOffer.JZ82;

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
  public TreeNode(int val) {
    this.val = val;
  }
}

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/22
 */

public class Demo_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root == null) return false;
        //  然后判断  是否到了 终点
        if(root.left == null&& root.right == null && sum - root.val == 0){
            return true;
        }
        // 然后进行递归  相减
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
        
    }
}
