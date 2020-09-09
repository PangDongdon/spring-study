package com.dongdong.spring.test.leetCode.linkedList;


import net.dongliu.commons.Sys;
import org.junit.Test;

/**
 * @Description: 删除链表的倒数第n个节点
 * @Date: 2020/9/8  16:42
 * @Author: dongdong
 */
public class Sort19 {

    /**by myself method*/
  public  ListNode deleteCountDownNode(ListNode headList,int n){
      //判断节点是否为空
        if(headList==null) {
          return   null;
        }
        int i=1; //记录节点总数
        ListNode node=headList;
        while(node.next!=null){
            node=node.next;
            i++;
        }
        if(n==i){
          return  headList.next;
        }
        node=headList;
        if(i>0 && n<i){
            //计算需要删除的节点
            int c=i-n;
            while(c-->1) {
                node = node.next;
            }
                if(node.next!=null){
                    node.next=node.next.next;
                    return  headList;
                }
        }
        return null;
  }

  @Test
  public  void test(){
      /** 1->2->3*/
      ListNode a=new ListNode(1);
      a.next=new ListNode(2);
      a.next.next=new ListNode(3);
      ListNode node=deleteCountDownNode(a,3);
      System.out.println(node.next.val);
  }

/**leetCode method*/
  public ListNode removeNthFromEnd(ListNode head,int n){
      ListNode dummy=new ListNode(-1);
      dummy.next=head;
      ListNode slow=dummy;
      ListNode fast=dummy;
      while(fast.next !=null){
          if(n<=0){
              slow=slow.next;
          }
          fast=fast.next;
          n--;
      }
if(slow.next !=null){
    slow.next=slow.next.next;
}
  return  dummy.next;
  }
}
