package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

import java.util.Stack;

/**
 * @Description:
 * @Date: 2020/9/22  16:13
 * @Author: dongdong
 */
public class Sort92 {

    public void RevertList(ListNode node,int m ,int n){
        int i=0;
        Stack stack=new Stack();
        while(node !=null){
            int val=node.val;
            node=node.next;
            i++;
            if(i>=m || i<=n){
              stack.push(val);
            }
        }
    }


     @Test
    public void test(){
         ListNode listNode=new ListNode(1);
         listNode.next=new ListNode(2);
         listNode.next.next=new ListNode(3);
         listNode.next.next.next=new ListNode(4);
         listNode.next.next.next.next=new ListNode(5);
         System.out.println(ReverseBetween(listNode,2,4).next.val);
     }

     public ListNode ReverseBetween(ListNode head, int m, int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        for(int i=0;i<m-1;i++){
            pre=pre.next;// 移动指针至反转的前一个节点
        }
        ListNode start=pre.next;
        ListNode then=start.next;
        for(int i=0;i<n-m;i++){
            start.next=then.next;
            then.next=pre.next;
            pre.next=then;
            then=start.next;
        }
        return  dummy.next;
     }
}
