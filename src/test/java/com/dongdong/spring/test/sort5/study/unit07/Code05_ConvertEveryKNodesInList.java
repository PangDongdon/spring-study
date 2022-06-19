package com.dongdong.spring.test.sort5.study.unit07;

public class Code05_ConvertEveryKNodesInList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node reverseKNodes2(Node head, int K) {
        if (K < 2) {
            return head;
        }
        Node cur = head;
        Node start = null;
        Node next = null;
        Node pre = null;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == K) {
                start=pre==null?head:pre.next;
                head=pre==null?cur:head;
                resign2(pre,start,cur,next);
                pre=start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return  head;
    }

    public static void resign2(Node left,Node start, Node end,Node right) {
       Node pre=start;
       Node cur=start.next;
       Node next=null;
       while(cur!=right){
           next=cur.next;
           cur.next=pre;
           pre=cur;
           cur=next;
       }
       if(left!=null){
           left.next=end;
       }
       start.next=right;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        int K = 3;
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");
    }
}
