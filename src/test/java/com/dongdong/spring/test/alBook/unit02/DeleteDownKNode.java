package com.dongdong.spring.test.alBook.unit02;


public class DeleteDownKNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node deleteNode1(Node head,int k){
        Node cur=head;
        while (cur!=null){
            cur=cur.next;
            k--;
        }
        if(k>0){
            return head;
        }
        if(k==0){
           return  head.next;
        }
        cur=head;
        if(k<0){
            while(++k!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return  head;
    }

    public static void main(String[] args) {
        Node head=null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node head2= deleteNode1(head,1);
        printLinkedList(head2);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
