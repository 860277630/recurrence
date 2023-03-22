package com.example.demo.controller;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: demoForWeb
 * @description:
 * @author: wjl
 * @create: 2023-02-11 22:30
 **/
public class Test003 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode middle;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode middle, TreeNode right) {
            this.val = val;
            this.left = left;
            this.middle = middle;
            this.right = right;
        }
    }

    @Test
    public void test(){
        //首先进行初始化
        TreeNode headNode = initNode();
        //深度优先遍历
        deepSortOutFont(headNode);
        //deepSortOutMiddle(headNode);
        //deepSortOutAfter(headNode);
        // 广度优先遍历
        //layerTranverse(headNode);
    }


    //对三叉树进行初始化
    public TreeNode initNode(){
        // 先初始化最底层的
        TreeNode node9 = new TreeNode(9,null, null, null);
        TreeNode node8 = new TreeNode(8,null, null, null);
        TreeNode node7 = new TreeNode(7,null, null, null);
        TreeNode node6 = new TreeNode(6,null, null, null);
        TreeNode node5 = new TreeNode(5,null, null, null);
        TreeNode node4 = new TreeNode(4,null, null, null);
        TreeNode node3 = new TreeNode(3,node9, null, null);
        TreeNode node2 = new TreeNode(2,null, node7, node8);
        TreeNode node1 = new TreeNode(1,node4, node5, node6);
        TreeNode node0 = new TreeNode(0,node1, node2, node3);
        return node0;
    }

    //前序遍历
    public void deepSortOutFont(TreeNode node){
        if(node == null){return;}
        System.out.println("前序遍历为："+node.val);
        deepSortOutFont(node.left);
        deepSortOutFont(node.middle);
        deepSortOutFont(node.right);
    }

    //中序遍历
    public void deepSortOutMiddle(TreeNode node){
        if(node == null){return;}
        deepSortOutMiddle(node.left);
        System.out.println("中序遍历为："+node.val);
        deepSortOutMiddle(node.middle);
        deepSortOutMiddle(node.right);
    }
    // 后序遍历
    public void deepSortOutAfter(TreeNode node){
        if(node == null){return;}
        deepSortOutAfter(node.left);
        deepSortOutAfter(node.middle);
        deepSortOutAfter(node.right);
        System.out.println("后序遍历为："+node.val);
    }

    //层序遍历
    public void layerTranverse(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            System.out.println(n.val);
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.middle!=null){
                q.add(n.middle);
            }
            if(n.right != null){
                q.add(n.right);
            }
        }
    }

}
