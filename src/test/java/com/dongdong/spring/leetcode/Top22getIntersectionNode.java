package com.dongdong.spring.leetcode;

/**
 * 相交链表
 */
public class Top22getIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head = headA;
        int aLen = 0;
        while (head != null) {
            head = head.getNext();
            aLen++;
        }
        head = headB;
        while (head != null) {
            head = head.getNext();
            aLen--;
        }


        if (aLen > 0) {
            while (aLen > 0) {
                headA = headA.getNext();
                aLen--;
            }
        } else if (aLen < 0) {
            aLen = Math.abs(aLen);
            while (aLen > 0) {
                headB = headB.getNext();
                aLen--;
            }
        }

        if (headA == headB) {
            return headA;
        }

        while (headA != null && headB != null) {
            headA = headA.getNext();
            headB = headB.getNext();
            if (headA == headB) {
                return headA;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.setNext(b);
        d.setNext(b);
        b.setNext(c);
        System.out.println(getIntersectionNode(a, d).getVal());
    }
}