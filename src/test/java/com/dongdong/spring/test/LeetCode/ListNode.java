package com.dongdong.spring.test.LeetCode;

/**两数相加*/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int i){
        this.val=i;
    }
    public int val(){
        return  val;
    }

    public ListNode addTwoNumbers(ListNode L1,ListNode L2){
        ListNode dummyHead=new ListNode(0);
        ListNode p=L1,q=L2,curr=dummyHead;
        int carry=0;
        while(p!=null || q!=null){
            int x=(p!=null)?p.val:0;
            int y=(q!=null)? q.val:0;
            int sum=carry+x+y;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return  dummyHead.next;
    }



}
