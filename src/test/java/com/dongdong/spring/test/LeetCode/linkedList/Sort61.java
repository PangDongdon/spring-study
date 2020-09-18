package com.dongdong.spring.test.leetCode.linkedList;



import org.junit.Test;

/**
 * @Description: 旋转链表
 * @Date: 2020/9/11  18:40
 * @Author: dongdong
 */
public class Sort61 {

    public ListNode getSpainLinkedList(ListNode listNode,int k){
        int i=0;
        int[] a=new int[3];
        int[] b=new int[3];
       ListNode head=new ListNode(0);
       ListNode temp=head;
       while(listNode!=null){
           a[i++]=listNode.val;
           listNode=listNode.next;
       }
       for(int j=0;j<a.length;j++){
           b[(j+k)%a.length]=a[j];
       }
       for(int m=0;m<b.length;m++){
          temp.next=new ListNode(b[m]);
          temp=temp.next;
       }
       return  head.next;
    }

    @Test
    public void testSpainLinkedList(){
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        System.out.println(rotateRight(listNode,1).val);
    }

    public ListNode rotateRight(ListNode head,int k){
        if(head==null){
            return  head;
        }
        ListNode copyHead=head;
        int len=1;
        while(copyHead.next!=null){
            copyHead=copyHead.next;
            len++;
        }
        copyHead.next=head;//link the tail and head to make it circle
        for(int i=len-k%len;i>1;i--){
            head=head.next;
        }
        copyHead=head.next;
        head.next=null;
        return  copyHead;
    }

}
