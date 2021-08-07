package com.dongdong.spring.test.leetCode.linkedList;


/**
 * @Description: 链表重排
 * @Date: 2020/10/27  15:32
 * @Author: dongdong
 * 1->2->3->4->5  >> 1->5->2->4->3
 */
public class Sort143 {

    public void reSortNodeList(ListNode head){
        if(head==null || head.next==null){
            return;
        }
        ListNode slowNode=head;
        ListNode fastNode=head;
        while(fastNode.next!=null){
            fastNode=fastNode.next;
            if(fastNode.next !=null){
                fastNode=fastNode.next;
            }else{
                break;
            }
            slowNode=slowNode.next;
        }
        //two sublist  heads
        ListNode head1=head;
        ListNode head2=slowNode.next;
        //detach the two sublists;
        slowNode.next=null;
        //reverse the second sublist
        ListNode cur=head2;
        ListNode post=cur.next;
        cur.next=null;
        while(post!=null){
            ListNode temp=post.next;
            post.next=cur;
            cur=post;
            post=temp;
        }
        head2=cur;//the new head  of the reversed sublist
        //merge the two sublists as required;
        ListNode p=head1;
        ListNode q=head2;
        while(q!=null){
            ListNode temp1=p.next;
            ListNode temp2=q.next;
            p.next=q;
            q.next=temp1;
            p=temp1;
            q=temp2;
        }
    }
}
