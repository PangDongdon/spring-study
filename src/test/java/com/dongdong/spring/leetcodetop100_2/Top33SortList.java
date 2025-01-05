package com.dongdong.spring.leetcodetop100_2;

/**
 * 排序鏈表
 */
public class Top33SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr=curr.next;
                }
                ListNode    next=null;
                if(curr!=null){
                    next=curr.next;
                    curr.next=null;
                }
                ListNode   merge=merge(head1,head2);
                prev.next=merge;
                while (prev.next!=null){
                    prev=prev.next;
                }
                curr=next;
            }
        }
        return dummyHead.next;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode  dummyHead=new ListNode(0);
        ListNode  temp=dummyHead,temp1=head1,temp2=head2;
        while (temp1!=null  &&  temp2!=null){
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }else {
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }

        if(temp1!=null){
            temp.next=temp1;
        }

        if(temp2!=null){
            temp.next=temp2;
        }
        return dummyHead.next;
    }
}
