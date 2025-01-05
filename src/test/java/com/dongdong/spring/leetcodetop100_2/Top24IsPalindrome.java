package com.dongdong.spring.leetcodetop100_2;
/**
 *是否回文链表
 */
public class Top24IsPalindrome {
    public boolean isPalindrome(ListNode head) {
      if(head==null){
          return false;
      }
      //寻找前半部分的尾节点
       ListNode fistEndNode = findFistEndNode(head);
       //反转后半分的链表
       ListNode secondStartNode=reverseList(fistEndNode.next);
       boolean result=true;
       while (result && secondStartNode!=null){
           if(head.val!= secondStartNode.val){
               result=false;
           }
           head=head.next;
           secondStartNode=secondStartNode.next;
       }
       fistEndNode.next=reverseList(secondStartNode);
       return result;
    }

    private ListNode reverseList(ListNode head){
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

    private ListNode findFistEndNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
