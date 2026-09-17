package com.example.leetcodedemo.JianZhiOffer.JZ25;


public class Solution_02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        if (pHead1 == null) return pHead2;
        if (pHead2 == null) return pHead1;
        //  创建一个新的  链表
        ListNode list = new ListNode(0);
        ListNode cur = list;
        while (pHead1 != null && pHead2 != null) {
            //  找到最小值
            if (pHead1.val > pHead2.val) {
                //  将小的值加到链表中
                cur.next = pHead2;
                pHead2 = pHead2.next;
            } else {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            }
            cur = cur.next;
        }
        // 然后把剩下的全部添加到末尾
        if(pHead1 == null){cur.next = pHead2;}
        if(pHead2 == null){cur.next = pHead1;}
        return list.next;

    }
}
