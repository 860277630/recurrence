package com.example.leetcodedemo.JianZhiOffer.JZ6;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Demo_01 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        //   使用栈
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> result = new ArrayList<>();
            Deque<Integer> stack = new ArrayDeque<>();
            while (listNode != null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            // 然后逐个倒出
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
            return result;
        }
    }
}
