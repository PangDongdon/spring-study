package com.dongdong.spring.leetcodetop100_2;

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

    private ListNode mergeNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = new ListNode(0);
        ListNode temp=head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        }

        if (head2 != null) {
            temp.next = head2;
        }
        return head.next;
    }
}
