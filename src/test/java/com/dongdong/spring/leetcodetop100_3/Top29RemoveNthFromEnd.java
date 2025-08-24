package com.dongdong.spring.leetcodetop100_3;

/**
 * 删除链表的倒数第N个节点
 */
public class Top29RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode dump=new ListNode(0, head);
        dump.next=head;
        ListNode temp=head;
        int length=0;
        while (temp!=null){
            temp=temp.next;
            length++;
        }
        temp=dump;
        for(int i=1;i<length-n+1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return dump.next;
    }
}
