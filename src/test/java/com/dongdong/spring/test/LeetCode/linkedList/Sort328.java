package com.dongdong.spring.test.leetCode.linkedList;


import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/12/14  11:26
 * @Author: dongdong
 */
public class Sort328 {

    public ListNode getParityListNode(ListNode node){
        if(node==null){
            return  node;
        }
        ListNode head=node;
        ListNode head1=node;
        while(node!=null && node.next!=null){  //1->2->3
            node.next=node.next.next;
            node=node.next.next;
        }
        while (node!=null && node.next==null && head1!=null){
            node.next=head1;
            if(head1.next!=null) {
                head1 = head1.next.next;
            }
        }
        return  head;
    }

    @Test
    public void test(){
       ListNode node1=new ListNode(1);
       node1.next=new ListNode(2);
       node1.next.next=new ListNode(3);
       System.out.println(oddEvenList(node1).next.next.val);
    }
     //des:链表奇偶排列
    public  ListNode  oddEvenList(ListNode head){
        if(head!=null){
            ListNode odd=head;
            ListNode even=head.next;
            ListNode evenHead=even;
            while(even!=null && even.next!=null){ //1(odd/head)->2(evenHead)->3
                odd.next=odd.next.next; //1->3
                even.next=even.next.next;//2->null
                odd=odd.next;
                even=even.next;
            }
            odd.next=evenHead;
        }
        return  head;
    }
}
