package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

/**
 * @Description: 删除排序链表中重复的元素II
 * @Date: 2020/9/14  19:25
 * @Author: dongdong
 */
public class Sort82 {

    public ListNode deleteRepeateElement(ListNode node){
        ListNode head=new ListNode(-1);
        head.next=node;
        while(node!=null && node.next!=null){
            if(node.val==node.next.val){
               head.next=node.next;
               node=head.next;
            }else{
                node=node.next;
            }

        }
        return head.next;
    }

    @Test
    public void test(){
        ListNode ss=new ListNode(1);
        ss.next=new ListNode(2);
        ss.next.next=new ListNode(2);
        System.out.println(this.deleteDuplicates(ss).next);
    }


    public ListNode deleteDuplicates(ListNode head){
        if(head==null){
            return  head;
        }
        ListNode  fakeHead=new ListNode(-1);
        fakeHead.next=head;
        ListNode pre=fakeHead;
        ListNode curr=head;
        while(curr!=null){
            while(curr.next!=null && curr.val==curr.next.val){
                curr=curr.next;
            }
            if(pre.next==curr){
                pre=pre.next;
            }else{
                pre.next=curr.next;
            }
                curr=curr.next;
        }
        return  fakeHead.next;
    }
}
