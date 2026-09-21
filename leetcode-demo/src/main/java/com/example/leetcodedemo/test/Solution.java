package com.example.leetcodedemo.test;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }


public class Solution {

    public int FindPath (TreeNode root, int sum) {
        int count  = 0;
        // write code here
        Integer  sum1 = root.val;
        Integer  sum2 = root.val;
        // 如果  总数  大于  目标  sum  则  以子节点 为根节点  进行遍历
        if(findLeft(root,sum1)> sum){
            sum1 = root.left.val;
            if(findLeft(root.left,sum1)==sum)
            {
                count++;
            }
            sum2 = root.right.val;
            if(findRight(root.left,sum2)==sum)
            {
                count++;
            }
        }
        return count;
    }
    public Integer findLeft(TreeNode root, Integer leftSum){
        if(root == null){
            return leftSum;
        }
        leftSum+=root.val;
        findLeft(root.left,leftSum);
        return leftSum;
    }
    //
    public Integer findRight(TreeNode root, Integer rightSum){
        if(root == null){
            return rightSum;
        }
        findRight(root.right,rightSum);
        rightSum+=root.val;
        return rightSum;
    }

}