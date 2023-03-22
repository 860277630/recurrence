package com.example.demo.controller;

import org.junit.Test;

import java.util.*;

/**
 * @program: demoForWeb
 * @description:
 * @author: wjl
 * @create: 2023-02-11 22:30
 **/
public class Test001 {
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
    }

    @Test
    public void test(){
        //首先进行初始化
        TreeNode headNode = initNode();
        //深度优先遍历
        deepSortOutFont(headNode);
        deepSortOutMiddle(headNode);
        deepSortOutAfter(headNode);
        // 广度优先遍历
        layerTranverse(headNode);
    }


    //对二叉树进行初始化
    public TreeNode initNode(){
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

    //前序遍历
    public void deepSortOutFont(TreeNode node){
        if(node == null){return;}
        System.out.println("前序遍历为："+node.val);
        deepSortOutFont(node.left);
        deepSortOutFont(node.right);
    }

    //中序遍历
    public void deepSortOutMiddle(TreeNode node){
        if(node == null){return;}
        deepSortOutMiddle(node.left);
        System.out.println("中序遍历为："+node.val);
        deepSortOutMiddle(node.right);
    }
    // 后序遍历
    public void deepSortOutAfter(TreeNode node){
        if(node == null){return;}
        deepSortOutAfter(node.left);
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
            if(n.right != null){
                q.add(n.right);
            }
        }
    }
    //层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);  //将根节点放入队列

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList();
            int count = queue.size(); //当不为0时，保证在同一层遍历
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

}
