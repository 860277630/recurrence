package com.example.leetcodedemo.recurrence.二叉树;

import org.junit.Test;

import java.util.Stack;

/**
 * 用栈  做二叉树  的前中后序遍历
 */
public class Test002 {
    @Test
    public void test(){
        //首先进行初始化
        TreeNode headNode = TreeNode.initNode();
        //  前序遍历
        //preOrder(headNode);
        //  中序遍历
        inOrder(headNode);
        //  后序遍历
        //posOrderTwoStacks(headNode);
    }


    // 先序打印所有节点，非递归版
    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    // 中序打印所有节点，非递归版
    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    System.out.println("入栈：===="+head.val);
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println("出栈：****"+head.val);
                    //System.out.print(head.val + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    // 后序打印所有节点，非递归版
    // 这是用两个栈的方法
    public static void posOrderTwoStacks(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val + " ");
            }
            System.out.println();
        }
    }
}
