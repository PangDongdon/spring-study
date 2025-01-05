package com.dongdong.spring.leetcodetop100_2;

import com.dongdong.spring.test.javaDesignModel16.List;

/**
 *删除链表的倒数第n个节点
 */
public class Top29RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n<1){
            return null;
        }
        int length=0;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            length++;
        }

        //删除节点正数的序号
        int order=length-n+1;
        if(order==1){
            return head.next;
        }
        ListNode pre=head;
        temp=head;
        length=1;
        while (temp!=null){
          if(length==order){
              pre.next=temp.next;
              break;
          }
          pre=temp;
          temp=temp.next;
          length++;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null || n<1){
            return null;
        }
        ListNode  dump=new ListNode(0,head);
        int length=0;
        ListNode temp=head;
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
