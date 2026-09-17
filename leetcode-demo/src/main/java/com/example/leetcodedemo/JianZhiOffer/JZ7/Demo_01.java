package com.example.leetcodedemo.JianZhiOffer.JZ7;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }
public class Demo_01 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // 先把它们转为 List
        List<Integer> preOrderList = transToList(preOrder);
        List<Integer> vinOrderList = transToList(vinOrder);
        return getTree(preOrderList,vinOrderList);
    }

    public TreeNode getTree(List<Integer> preOrderList,List<Integer> vinOrderList){
        if(preOrderList.isEmpty()||vinOrderList.isEmpty()){return null;}
        // 前序遍历的第一个是头节点
        int headNum = preOrderList.get(0);
        TreeNode head = new TreeNode(headNum);

        //  然后找到 中序遍历的 下标
        int index = vinOrderList.indexOf(headNum);

        // 切割中序遍历  找到  前半只  和 后半只
        List<Integer> vinOrderleftSides = vinOrderList.subList(0,index);
        List<Integer> vinOrderRightSides = vinOrderList.subList(index+1,vinOrderList.size());

        //  然后找到前半只 和 后半只 对应的部分
        List<Integer> preOrderLeftSides = preOrderList.subList(1,vinOrderleftSides.size()+1);
        List<Integer> preOrderRightSides = preOrderList.subList(vinOrderleftSides.size()+1,preOrderList.size());
        head.left = getTree(preOrderLeftSides,vinOrderleftSides);
        head.right = getTree(preOrderRightSides,vinOrderRightSides);
        return head;
    }


    public List<Integer> transToList(int[] nums){
        List<Integer> res = new ArrayList<>();
        for(int num:nums){
            res.add(num);
        }
        return res;
    }
}
