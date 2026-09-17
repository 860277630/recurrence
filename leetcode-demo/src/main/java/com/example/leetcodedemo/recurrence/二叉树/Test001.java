package com.example.leetcodedemo.recurrence.二叉树;

import org.junit.Test;

import java.util.*;

/**
 * @program: demoForWeb
 * @description:  递归遍历方式
 * @author: wjl
 * @create: 2023-02-11 22:30
 **/
public class Test001 {

    @Test
    public void test(){
        //首先进行初始化
        TreeNode headNode = TreeNode.initNode();
        //深度优先遍历
        deepSortOutFont(headNode);
        deepSortOutMiddle(headNode);
        deepSortOutAfter(headNode);
        // 广度优先遍历
        layerTranverse(headNode);
        levelOrderBottom(headNode);
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
