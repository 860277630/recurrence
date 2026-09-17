package com.example.leetcodedemo.JianZhiOffer.JZ25;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        if (pHead1 == null) return pHead2;
        if (pHead2 == null) return pHead1;
        ListNode insertNode = pHead1.val > pHead2.val ? pHead1 : pHead2;
        ListNode insertedNode = pHead1.val > pHead2.val ? pHead2 : pHead1;
        // 然后再引入一个node
        ListNode tempNode = insertedNode;
        //  遍历  第二个
        while (insertNode != null) {
            ListNode temp = insertNode.next;
            tempNode = insert(insertNode, tempNode);
            insertNode = temp;
        }
        return insertedNode;
    }

    public ListNode insert(ListNode node, ListNode startNode) {
        // 然后从 startNode  开始找  大于node的最小值
        ListNode preNode = startNode;
        if (startNode.next == null) {
            //  那么就直接加在尾部
            startNode.next = node;
            node.next = null;
        }
        ListNode nowNode = startNode.next;
        while (nowNode != null) {
            if (nowNode.val > node.val) {
                //  那么就将  node 节点  加入进去
                preNode.next = node;
                node.next = nowNode;
                break;
            }
            // 如果不是  就继续 向后移动
            if (nowNode.next == null) {
                //  那就直接加进去
                nowNode.next = node;
                node.next = null;
                break;
            }
            //如果 能继续向后移动
            preNode = nowNode;
            nowNode = nowNode.next;
        }
        return node;
    }
}
