package com.dongdong.spring.test.sort.test.unit03;

import com.dongdong.spring.test.sort.basic_class_03.Code_11_IsPalindromeList;

public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static boolean isPalindrome3(Node head) {
        if(head==null || head.next==null){
            return false;
        }
        Node slow=head;
        Node fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        Node n3=null;
        while(fast!=null){
           n3=fast.next;
           fast.next=slow;
           slow=fast;
           fast=n3;
        }
        n3=slow;
        fast=head;
        boolean res=true;
        while(slow!=null && fast!=null){
            if(slow.value!=fast.value){
                res=false;
                break;
            }
            slow=slow.next;
            fast=fast.next;
        }
        slow=n3.next;
        n3.next=null;
        while(slow!=null){
            fast=slow.next;
            slow.next=n3;
            n3=slow;
            slow=fast;
        }
        return  res;
    }

    public static void main(String[] args) {
        Node head=null;
        head = new Node(1);
        head.next = new  Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
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
