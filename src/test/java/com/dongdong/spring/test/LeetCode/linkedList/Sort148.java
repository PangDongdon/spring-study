package com.dongdong.spring.test.leetCode.linkedList;
/**
 * @Description: 排序链表
 * @Date: 2020/12/2  16:25
 * @Author: dongdong
 */
public class Sort148 {

    public ListNode  sortList(ListNode head){
        if(head==null || head.next==null){
            return  head;
        }
        //Step 1: split the list into halves
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        prev.next=null;
        //step 2: sort each half
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        //step 3: merge the two halves
        return merge(l1,l2);
    }
    private ListNode merge(ListNode L1,ListNode L2){
        ListNode result=new ListNode(0);
        ListNode tmp=result;
        while(L1!=null && L2!=null){
            if(L1.val<L2.val){
                tmp.next=L1;
                 L1=L1.next;
            }else{
                tmp.next=L2;
                L2=L2.next;
            }
            tmp=tmp.next;
        }
        if(L1!=null){
            tmp.next=L1;
        }
        if(L2!=null){
            tmp.next=L2;
        }
       return result.next;
    }
}
