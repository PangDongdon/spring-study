package com.dongdong.spring.test.sort;

import com.dongdong.spring.test.sort.basic_class_03.Code_15_ReverseList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *  链表反转
 */
public class RevertList {

    public static class Node{
        public int value;
        public Node next;

        public  Node(int data){
            this.value=data;
        }
    }

    public  static  class DoubleNode{

        public DoubleNode pre;
        public DoubleNode next;
        public DoubleNode last;
        public int value;

        public DoubleNode(int data){
            this.value=data;
        }
    }


    public  static  Node  revertSingletList(Node head){
        Node pre=null;
        Node next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static DoubleNode invertDoubleList(DoubleNode head){
        DoubleNode pre=null;
        DoubleNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return  pre;
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
        printLinkedList(head1);
        head1 = revertSingletList(head1);
        printLinkedList(head1);
        System.out.println("*******************");
        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(invertDoubleList(head2));
    }


    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }


}
