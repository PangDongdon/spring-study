package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

/**
 * @Description: 链表中两两节点交换
 * @Date: 2020/9/10  18:36
 * @Author: dongdong
 */
public class Sort24 {

    public ListNode getExchangeNodeList(ListNode node){
        if(node==null || node.next==null){
            return  node;
        }
        ListNode second=node.next;
        ListNode third=second.next;
        second.next=node;
        node.next=getExchangeNodeList(third);
        return  second;
    }

    @Test
    public void test(){
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        System.out.println(getExchangeNodeList(node).val);
    }

}
