package com.dongdong.spring.test.sort2;

import com.dongdong.spring.test.sort.basic_class_03.Code_10_PrintCommonPart;

public class PrintCommonPart {

    public static class Node{
        private int  value;
        private Node  next;
        public Node(int data){
            this.value=data;
        }
    }

    public  static  void getNodeCommonPart(Node head1,Node head2){
        if(head1==null || head2==null){
            return;
        }
        while (head1!=null &&  head2!=null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head2 = head2.next;
                head1 = head1.next;
            }
        }
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new  Node(1);
        node2.next = new  Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        getNodeCommonPart(node1, node2);
    }


}
