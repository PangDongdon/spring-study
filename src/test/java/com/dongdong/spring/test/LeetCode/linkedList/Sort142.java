package com.dongdong.spring.test.leetCode.linkedList;



/**
 * @Description: 环形链表II
 * @Date: 2020/10/27  15:00
 * @Author: dongdong
 */
public class Sort142 {

    public ListNode detestCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
              fast=fast.next.next;
              slow=slow.next;
              if(slow==fast){
                  ListNode slow2=head;
                  while(slow2!=slow){
                     slow=slow.next;
                     slow2=slow2.next;
                  }
                  return slow;
              }
        }
        return  null;
    }

}
