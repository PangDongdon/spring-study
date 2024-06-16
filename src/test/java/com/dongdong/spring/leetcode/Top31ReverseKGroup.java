package com.dongdong.spring.leetcode;

/**
 * k个一组翻转链表
 */
public class Top31ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode hair=new ListNode(0);
       hair.next=head;
       ListNode pre=hair;
       while(head!=null){
          ListNode tail=pre;
          for(int i=0;i<k;i++){
              tail=tail.next;
              if(tail==null){
                  return hair.next;
              }
          }
          ListNode next=tail.next;
          ListNode[] reverse=reverseList(head,tail);
          head=reverse[0];
          tail=reverse[1];
          //把子链表重新接回原链表
           pre.next=head;
           tail.next=next;
           pre=tail;
           head=tail.next;
       }
       return hair.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode pre=tail.next;
        ListNode p=head;
        while(pre!=tail){
            ListNode next=p.next;
            p.next=pre;
            pre=p;
            p=next;
        }
        return new ListNode[]{tail,head};
    }
}
