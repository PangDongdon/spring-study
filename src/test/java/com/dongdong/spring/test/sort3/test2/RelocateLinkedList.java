package com.dongdong.spring.test.sort3.test2;


public class RelocateLinkedList {

    public static class Node {
        public int value;
        public  Node next;
        public Node(int value){
          this.value=value;
        }
    }

    private static void   relocate(Node  node){
        if(node==null || node.next==null){
            return;
        }
        Node mid=node;
        Node right=node.next;
        while(right.next!=null && right.next.next!=null){
            mid=mid.next;
            right=right.next.next;
        }
        right=mid.next;
        mid.next=null;
        merge(node,right);
    }

    private static void merge(Node left,Node right){
       Node next=null;
       while (left.next!=null){
           next=right.next;
           right.next=left.next;
           left.next=right;
           left=right.next;
           right=next;
       }
       left.next=right;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        relocate(head);
        printLinkedList(head);
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}

