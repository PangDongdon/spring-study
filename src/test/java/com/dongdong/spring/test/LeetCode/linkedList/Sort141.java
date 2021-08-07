package com.dongdong.spring.test.leetCode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 判断链表是否是闭环
 * @Date: 2020/10/20  17:38
 * @Author: dongdong
 */
public class Sort141 {

    /**method 1  节点在set中是否重复*/
    public  boolean   hasCycle(ListNode node){
        Set<ListNode> set=new HashSet<>();
        while (node!=null) {
            if (!set.add(node)) {
                return true;
            }
            node = node.next;
        }
        return  false;
    }

    /**method 2  快慢指针相遇*/
    public  boolean hasCycle2(ListNode head){
       ListNode slow=head;
       ListNode fast=head;
       while(fast !=null  && fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
           if(fast==slow){
               return  true;
           }
       }
       return false;
    }

}
