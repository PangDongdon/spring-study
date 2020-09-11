package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/9/11  9:47
 * @Author: dongdong
 */
public class Sort25 {

    public ListNode swapNode(ListNode head,int n){
       //统计数量
       ListNode curr=head;
       int count=0;
       while(curr!=null && count!=n){
           curr=curr.next;
           count++;
       }
       if(count==n){
           curr=swapNode(curr,n);
           while(count-- >0){
               ListNode temp=head.next;
               head.next=curr;
               curr=head;
               head=temp;
           }
           head=curr;
       }
       return head;
    }

    @Test
    public void test(){
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        System.out.println(swapNode(node,3).val);
    }
}
