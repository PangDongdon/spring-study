package com.dongdong.spring.test.leetCode.linkedList;


import org.junit.Test;

/**
 * @Description: 删除链表中的重复元素
 * @Date: 2020/9/18  16:10
 * @Author: dongdong
 */
public class Sort83 {

    public ListNode getLostNode(ListNode node){
        {
          ListNode curr=node;
          while(curr !=null){
              if(curr.next!=null && curr.val==curr.next.val){
                  curr.next=curr.next.next;
              }
              curr=curr.next;
          }
        }
      return node;
    }


    @Test
    public void test(){
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(1);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(3);
        System.out.println(getLostNode(listNode).next.val);
    }
}
