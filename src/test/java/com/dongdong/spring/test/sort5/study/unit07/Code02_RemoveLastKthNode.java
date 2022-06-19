package com.dongdong.spring.test.sort5.study.unit07;

public class Code02_RemoveLastKthNode {
    public static class Node {
        private int value;
        private  Node next;
        public Node(int data){
            this.value=data;
        }
    }



    public static Node removeLastKthNode(Node head, int lastKth) {
        if(head==null || lastKth<1){
            return  head;
        }
       Node cur=head;
        while (cur!=null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){
            head=head.next;
        }
        if(lastKth<0){
            cur=head;
            while (++lastKth!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
        head1 = removeLastKthNode(head1, 3);
        printLinkedList(head1);
    }
}
