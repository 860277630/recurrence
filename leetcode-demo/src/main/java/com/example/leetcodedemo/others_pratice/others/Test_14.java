package com.example.leetcodedemo.others_pratice.others;

/**
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * 插入排序 算法的步骤:
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，
 * 并就地插入已排序的列表中。
 * 对链表进行插入排序。
 *
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 *
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 */
public class Test_14 {
    public static void main(String[] args) {

        // 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode result = insertionSortList(head);

        printList(result);
    }

    public static ListNode insertionSortList(ListNode head) {
        return null;
    }

    private static void printList(ListNode head) {

    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
