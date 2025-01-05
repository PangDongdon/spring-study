package com.dongdong.spring.leetcodetop100_2;

import com.dongdong.spring.test.javaDesignModel16.List;

/**
 * 合并两个有序链表
 */
public class Top27MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode tmp = new ListNode(0);
        ListNode prev = tmp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return tmp.next;
    }
}
