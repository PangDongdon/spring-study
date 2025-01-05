package com.dongdong.spring.leetcodetop100_2;

/**
 * 相交链表
 */
public class Top22GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int sizeA = 0;
        int sizeB = 0;
        ListNode temp = headA;
        while (temp != null) {
            temp = temp.next;
            sizeA++;
        }
        temp = headB;
        while (temp != null) {
            temp = temp.next;
            sizeB++;
        }

        if (sizeA > sizeB) {
            int len = sizeA - sizeB;
            while (len > 0) {
                headA = headA.next;
                len--;
            }
        }
        if (sizeB > sizeA) {
            int len = sizeB - sizeA;
            while (len > 0) {
                headB = headB.next;
                len--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
