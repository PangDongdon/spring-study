package com.dongdong.spring.leetcode;

import java.util.*;

/**
 * 排序链表
 */
public class Top32SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.getVal() < temp2.getVal()) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public ListNode sort(ListNode head,ListNode tail) {
       if(head==null){
           return head;
       }
       if(head.next==tail){
           head.next=null;
           return head;
       }
       ListNode fast=head,slow=head;
       while (fast!=null){
           fast=fast.next;
           slow=slow.next;
           if(fast.next!=tail){
               fast=fast.next;
           }
       }
       ListNode mid=slow;
       ListNode left=sort(head,mid);
       ListNode right=sort(mid,tail);
       return merge(left,right);
    }

    public ListNode sortList2(ListNode head) {
        return sort(head,null);
    }

}
