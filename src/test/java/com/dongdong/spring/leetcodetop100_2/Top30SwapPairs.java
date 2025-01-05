package com.dongdong.spring.leetcodetop100_2;
/**
 *两两交换链表的节点
 **/
public class Top30SwapPairs {
    public ListNode swapPairs(ListNode head) {
     if(head==null || head.next==null){
         return head;
     }
     ListNode newHead=head.next;
     head.next=swapPairs(newHead.next);
     newHead.next=head;
     return newHead;
    }


    public ListNode swapPairs2(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(0,head);
        dummyHead.next=head;
        ListNode temp=dummyHead;
        while (temp.next!=null && temp.next.next!=null){
            ListNode node1=temp.next;
            ListNode node2=temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return dummyHead.next;
    }
}
