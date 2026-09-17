package com.example.leetcodedemo.JianZhiOffer.JZ9;

import java.util.*;
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //  push 就直接往栈1  添加
        stack1.push(node);
    }

    public int pop() {
        // 如果队列2空了  就把队列1全部导进来
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){return -1;}
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }
}
