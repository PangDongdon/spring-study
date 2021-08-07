package com.dongdong.spring.test.leetCode.linkedList;

import net.dongliu.commons.Sys;
import org.junit.Test;

/**
 * @Description: 删除链表中的节点
 * @Date: 2020/12/2  17:28
 * @Author: dongdong
 */
public class Sort203 {
    public ListNode deleteNode(ListNode node, int a) {
        ListNode head = new ListNode(0);
        head.next = node;
        if (node.val == a) {
            head.next = node.next;
        }
        while (node.next != null) {
            if (node.next.val == a) {
                node.next = node.next.next;
            }
            if (node == null) {
                break;
            }
            node = node.next;
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode dd = deleteNode(node, 3);
        System.out.println(dd.next.val);
    }

    public ListNode deleteNode1(ListNode node,int a){
        ListNode dummy=new ListNode(-1);
        dummy.next=node;
        ListNode prev=dummy;
        ListNode curr=node;
        while(curr!=null){
            if(curr.val==a){
                prev.next=curr.next;
            }else {
                prev=prev.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}
