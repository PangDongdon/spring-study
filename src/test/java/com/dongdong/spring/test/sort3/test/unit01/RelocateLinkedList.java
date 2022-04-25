package com.dongdong.spring.test.sort3.test.unit01;

import advanced_class_01.Code_03_RelocateLinkedList;

public class RelocateLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void relocate(Node head) {
        if(head==null || head.next==null){
            return;
        }
        //定义慢指正
        Node mid=head;
        //快
        Node right=head.next;
        while(right.next!=null && right.next.next!=null){
            mid=mid.next;
            right=right.next.next;
        }
        right=mid.next;
        mid.next=null;
        mergeRL(head,right);
    }

    private static void mergeRL(Node left, Node right) {
        Node next=null;
        while(left.next!=null){
            next=right.next;
            right.next=left.next;
            left.next=right;
            left=right.next;
            right=next;
        }
        left.next=right;
    }
}
