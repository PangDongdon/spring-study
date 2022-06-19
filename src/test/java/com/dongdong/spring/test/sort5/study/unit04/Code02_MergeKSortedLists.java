package com.dongdong.spring.test.sort5.study.unit04;

import com.dongdong.spring.test.javaDesignModel16.List;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code02_MergeKSortedLists {

    public static class ListNode {
        private int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        ListNode head = null;
        ListNode pre = null;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            head = head == null ? cur : head;
            if (pre != null) {
                pre.next = cur;
            }
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }
}
