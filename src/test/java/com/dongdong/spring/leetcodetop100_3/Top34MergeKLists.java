package com.dongdong.spring.leetcodetop100_3;

/**
 * 合并k个升序链表
 */
public class Top34MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode node = null;
        for (int i = 0; i < lists.length; i++) {
            node = mergeNode(node, lists[i]);
        }
        return node;
    }

    public ListNode mergeNode(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        temp.next = node1 == null ? node2 : node1;
        return head.next;
    }
}
