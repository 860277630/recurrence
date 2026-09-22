package com.example.leetcodedemo.JianZhiOffer.JZ52;
import java.util.*;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/20
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Demo_01 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        //  把其中一个放入到  统计容器中
        List<Integer> head1List = new ArrayList<>();
        while(pHead1!=null){
            int val = pHead1.val;
            head1List.add(val);
            pHead1 = pHead1.next;
        }
        //  然后遍历第2个
        while(pHead2!=null){
            int val = pHead2.val;
            if(head1List.contains(val)){
                // 如果包含就返回
                return pHead2;
            }
            //  否则就继续遍历
            pHead2 = pHead2.next;
        }
        return null;
    }
}
