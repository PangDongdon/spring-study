package com.dongdong.spring.test.leetCode.sort;

/**
 * @Description:  排序链表（时间复杂度（nlogn）,空间复杂度为常数）
 * @Date: 2020/9/1  9:15
 * @Author: dongdong
 */
public class Sort148 {

    public  ListNode sortList(ListNode head){
        if(head==null   || head.next==null){
            return  head;
        }
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }


    private ListNode merge(ListNode l1,ListNode l2){

        ListNode result=new ListNode(0);
        ListNode tmp=result;


        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tmp.next=l1;
                l1=l1.next;
            }else{
                tmp.next=l2;
                l2=l2.next;
            }
            tmp=tmp.next;
        }
        if(l1!=null){
            tmp.next=l1;
        }
        if(l2!=null){
            tmp.next=l2;
        }
        return result.next;
    }





    private static class  ListNode{
        int val;
        ListNode next;

        public  ListNode(int val){
            this.val=val;
        }
    }

}
