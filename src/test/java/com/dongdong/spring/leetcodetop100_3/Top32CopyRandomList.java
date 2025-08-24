package com.dongdong.spring.leetcodetop100_3;
/**
 *随机链表的复制
 */
public class Top32CopyRandomList {
    public Node copyRandomList(Node head) {
     if(head==null){
         return head;
     }
     Node cur=head;
     Node next=null;
     //copy  next node
     while(cur!=null){
         next=cur.next;
         cur.next=new Node(cur.val);
         cur.next.next=next;
         cur=next;
     }

     //copy random node
     cur=head;
     Node curCopy=null;
     while (cur!=null){
         next=cur.next.next;
         curCopy=cur.next;
         curCopy.random=cur.random!=null?cur.random.next:null;
         cur=next;
     }

     // split
      cur=head;
      Node res=cur.next;
      while (cur!=null){
          next=cur.next.next;
          curCopy=cur.next;
          cur.next=next;
          curCopy.next=next!=null?next.next:null;
          cur=next;
      }
      return res;
    }
}
