package com.example.leetcodedemo.JianZhiOffer.JZ6;


import java.util.ArrayList;
import java.util.Collections;

public class Demo_03 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //  递归法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        getNum(listNode, result);
        return result;
    }

    public void getNum(ListNode node, ArrayList<Integer> result) {
        //  终止条件是  node 为null
        if (node == null) {
            return;
        }
        //  如果 不是最后一个就下一层
        getNum(node.next, result);
        //  在下一层返回后 倒着加入到  list中
        //  记住这里是倒着加就行
        result.add(node.val);

    }
}
