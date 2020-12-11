package com.dongdong.spring.test.leetCode.linkedList;

import com.dongdong.spring.ApplicationTests;
import jdk.nashorn.internal.ir.LiteralNode;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 反转链表
 * @Date: 2020/12/2  18:36
 * @Author: dongdong
 */
public class Sort206 extends ApplicationTests {

    public ListNode invertList(ListNode node){
        ListNode newHead=null;
        while(node!=null){
            ListNode next=node.next;
            node.next=newHead;
            newHead=node;
            node=next;
        }
        return newHead;
    }

    public ListNode reverseList(ListNode head){
        ListNode newHead=null;
        return  reverse(head,newHead);
    }
    ListNode reverse(ListNode head,ListNode newHead){
        if(head==null){
            return  newHead;
        }
        ListNode next=head.next;
        head.next=newHead;
        newHead=head;
        head=next;
        return  reverse(head,newHead);
    }
    @Test
    public void test(){
       /* ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        ListNode result=invertList(node);
        System.out.println(result.val);*/
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("");
    }
}
