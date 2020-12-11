package com.dongdong.spring.test.leetCode.linkedList;

/**
 * @Description: 相交链表
 * @Date: 2020/12/2  17:18
 * @Author: dongdong
 */
public class Sort160 {

    public ListNode lookNode(ListNode node1,ListNode node2){
        if(node1==null || node2==null){
            return  null;
        }
        ListNode a=node1;
        ListNode b=node2;
        while(a!=b){
            a=a==null? node2:a.next;
            b=b==null? node1:b.next;
        }
        return a;
    }
}
