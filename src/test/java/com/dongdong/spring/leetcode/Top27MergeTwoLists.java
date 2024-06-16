package com.dongdong.spring.leetcode;

/**
 * 合并两个有序链表
 */
public class Top27MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;
        while (list1 != null && list2 != null) {
            if (list1.getVal() <= list2.getVal()) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return prevHead.next;
    }
}
