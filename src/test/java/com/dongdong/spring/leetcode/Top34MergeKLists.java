package com.dongdong.spring.leetcode;

/**
 * 合并k个升序链表
 */
public class Top34MergeKLists {

    //给你一个链表数组，每个链表都已经按升序排列。
    //
    //请你将所有链表合并到一个升序链表中，返回合并后的链表。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeKTwoLists(ans, lists[i]);
        }
        return ans;
    }


    public ListNode mergeKTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return listNode1 == null ? listNode2 : listNode1;
        }
        ListNode head = new ListNode(0);
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                head.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                head.next = listNode2;
                listNode2 = listNode2.next;
            }
            head=head.next;
        }
        if (listNode1 != null) {
            head.next = listNode1;
        }
        if (listNode2 != null) {
            head.next = listNode2;
        }
        return head.next;
    }
}
