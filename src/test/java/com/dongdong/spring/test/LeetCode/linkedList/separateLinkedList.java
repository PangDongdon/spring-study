package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

/**
 * @Description: 1->4->3->2->5->2  分隔链表
 * @Date: 2020/9/22  14:42
 * @Author: dongdong
 */
public class SeparateLinkedList {

    public ListNode getListNode(ListNode node,int x){
        if(node==null || node.next==null){
            return  null;
        }
       ListNode left=new ListNode(0);
       ListNode right=new ListNode(0);
       ListNode less=left;
       ListNode greater=right;
       while(node !=null){
           if(node.val<x){
               less.next=node;//指向下一个节点
               less=less.next;//指针移动到下一个节点
           }else{
               greater.next=node;
               greater=greater.next;
           }
            node=node.next;
       }
       greater.next=null;
       less.next=right.next;//衔接
       return  left.next;
    }

    @Test
    public void test(){
        ListNode node=new ListNode(1);
        node.next=new ListNode(4);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(2);
        node.next.next.next.next=new ListNode(5);
        node.next.next.next.next.next=new ListNode(2);
        System.out.println(getListNode(node,3).next.next.next.next.val);
    }
}
