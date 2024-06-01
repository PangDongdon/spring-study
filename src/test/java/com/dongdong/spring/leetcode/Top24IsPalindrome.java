package com.dongdong.spring.leetcode;

import lombok.val;

import java.util.Stack;

/**
 * 是否回文链表
 */
public class Top24IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode tmp = head;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (tmp != null) {
            stack.push(tmp.getVal());
            tmp = tmp.next;
            i++;
        }
        int j = 0;
        while (head != null && j <= i / 2) {
            if (head.getVal() != stack.pop()) {
                return false;
            }
            head = head.next;
            j++;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode endOfFirstHalf = endOfFirstHalf(head);
        ListNode secondOfStart = reverseList(endOfFirstHalf.next);
        boolean res = true;
        ListNode s = endOfFirstHalf;
        ListNode e = secondOfStart;
        while (s != null && e != null) {
            if (s.getVal() != e.getVal()) {
                return false;
            }
            s = s.next;
            e = e.next;
        }
        endOfFirstHalf.next = reverseList(secondOfStart);
        return res;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //输入：head = [1,2,2,1]
    //输出：true
    //输入：head = [1,2]
    //输出：false
    public static void main(String[] args) {

    }
}
