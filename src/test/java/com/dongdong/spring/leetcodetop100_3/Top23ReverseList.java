package com.dongdong.spring.leetcodetop100_3;
/**
 *反转链表
 */
public class Top23ReverseList {
    public ListNode reverseList(ListNode head) {
      if(head==null){
          return null;
      }
      ListNode prev=null;
      ListNode curr=head;
      while (curr!=null){
          ListNode next=curr.next;
          curr.next=prev;
          prev=curr;
          curr=next;
      }
      return prev;
    }
}
