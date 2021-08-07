package com.dongdong.spring.test.leetCode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/12/4  9:38
 * @Author: dongdong
 */
public class Sort234 {
    //method1
    public boolean  palindrome(ListNode head){
        int len=0;
        ListNode fast=head;
        ListNode slow=head;
        List<Integer> firstHalf=new ArrayList<>();
        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            firstHalf.add(slow.val);
            slow= slow.next;
            len+=2;
        }
        if(fast!=null){
            len++;
        }
        if(len%2!=0){
            slow=slow.next;
        }
        int i=firstHalf.size()-1;
        while(slow !=null){
            if (firstHalf.get(i--) != slow.val) {
                return  false;
            }
            slow=slow.next;
        }
        return  true;
    }
    //method2
    public boolean  palindrome2(ListNode head){
        if(head==null){
            return  true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode reversedHead=reverse(slow.next);
        ListNode firstHalfHead=head;
        while(firstHalfHead!=null &&reversedHead!=null){
            if(firstHalfHead.val!=reversedHead.val){
                return  false;
            }
            firstHalfHead=firstHalfHead.next;
            reversedHead=reversedHead.next;
        }
        return  true;
    }
    //链表反转
    private ListNode reverse(ListNode head){
        ListNode pre=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }


}
