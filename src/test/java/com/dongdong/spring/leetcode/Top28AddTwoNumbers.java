package com.dongdong.spring.leetcode;

public class Top28AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int res1 = 0;
        int i = 0;
        while (l1 != null) {
            res1 += l1.getVal() * Math.pow(10, i);
            l1 = l1.next;
            i++;
        }
        i = 0;
        while (l2 != null) {
            res1 += l2.getVal() * Math.pow(10, i);
            l2 = l2.next;
            i++;
        }
        int length = String.valueOf(res1).length();
        i = 1;
        ListNode head = new ListNode(-1);
        ListNode tmpNode = head;
        while (i <= length) {
            int tmp = (int) (res1 % (Math.pow(10, 1)));
            res1 = (int) (res1 / (Math.pow(10, 1)));
            tmpNode.next = new ListNode(tmp);
            tmpNode = tmpNode.next;
            i++;
        }
        return head.next;
    }
    //807

    public static void main(String[] args) {
        //输入：l1 = [2,4,3], l2 = [5,6,4]
        //342+465=807
        //输出：[7,0,8]
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(4);
    }
}
