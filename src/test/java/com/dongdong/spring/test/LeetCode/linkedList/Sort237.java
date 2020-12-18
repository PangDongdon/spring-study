package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/12/4  11:24
 * @Author: dongdong
 */
public class Sort237 {

    public ListNode  deleteListNodeBySort(ListNode node,int n){
        ListNode head=new ListNode(-1);
        //定义数据得次序
         int dataOrder=0;
         head.next=node;
         ListNode curr=node;
         ListNode prev=head;
        while (curr !=null){
            dataOrder+=1;
          if(n==dataOrder){
             prev.next=curr.next;
          }else{
             prev=prev.next;
          }
            curr=curr.next;
        }
        return head.next;
    }
    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode dd = deleteListNodeBySort(node, 3);
        System.out.println(dd.next.val);
    }
    @Test
    public void  test2(){
        System.out.println(System.currentTimeMillis());
    }
}
