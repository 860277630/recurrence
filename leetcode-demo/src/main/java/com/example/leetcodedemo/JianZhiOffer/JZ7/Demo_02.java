package com.example.leetcodedemo.JianZhiOffer.JZ7;

import java.util.HashMap;
import java.util.Map;

public class Demo_02 {
      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
     }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */


    //  数组不便于处理  用Map来进行记录 下标
    //  因为是不重复的  所以  使用  map的 key来记录
    public static Map<Integer,Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        //  首先把  vinOrder  录入到map中
        for(int i = 0; i< vinOrder.length; i++){
            map.put(vinOrder[i],i);
        }
        //  然后进行 递归处理
        return getTree(preOrder,0,preOrder.length-1,vinOrder,0,vinOrder.length-1);
    }

    public TreeNode getTree(int[] preOrder, int preOrderStartIndex,int preOrderEndIndex,
                            int[] vinOrder,int vinStartIndex,int vinEndIndex){
        if(vinStartIndex > vinEndIndex){return null;}
        //  否则就拿到第一个  作为 头节点
        int nodeVal = preOrder[preOrderStartIndex];
        TreeNode node = new TreeNode(nodeVal);
        //  然后去找  中序遍历中的  对应的下标
        int vinIndex = map.get(nodeVal);
        //  然后就去算  前序遍历的起始点
        int preLeftStartIndex = preOrderStartIndex+1;
        int preLeftEndIndex = preOrderStartIndex+(vinIndex-vinStartIndex);
        int vinEndIndexTemp = vinIndex-1;

        node.left = getTree(preOrder,preLeftStartIndex,preLeftEndIndex,vinOrder,vinStartIndex,vinEndIndexTemp);

        //  然后计算后半部分
        int preRightStartIndex = 1+preOrderStartIndex+(vinIndex-vinStartIndex);
        int vinStartIndexTemp = vinIndex+1;
        node.right = getTree(preOrder,preRightStartIndex,preOrderEndIndex,vinOrder,vinStartIndexTemp,vinEndIndex);
        return node;

    }
}
