package com.dongdong.spring.test.alBook.unit02Link;

import net.dongliu.commons.Sys;

//两个链表相交的一系列的问题
public class Class10_TwoLinkListInteractiveProblem {

    //判断一个链表是否有环，获取第一个入环节点
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        //定义快慢指针
        Node low = head.next;
        Node fast = head.next.next;
        while (low != fast) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                low = low.next;
            }
        }
        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }

    //两个无环的链表相交
    private static Node getNoLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        //统计每个链表个数
        int n = 0;
        // int n2 = 0;
        Node cur1 = head1;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }
        Node cur2 = head2;
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        //  int diff = Math.abs(n1 - n2);
     /*   if (n1 > n2) {
            while (diff != 0) {
                head1 = head1.next;
                diff--;
            }
        } else if (n2 > n1) {
            while (diff != 0) {
                head2 = head2.next;
                diff--;
            }
        }*/
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    //获取有环链表的相交节点
    private static Node getLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        //相交在入环的节点处
        if (loop1 == loop2) {
            int n = 0;
            cur1 = head1;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            cur2 = head1;
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {//交点在环上
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return cur1;
                }
                cur1 = cur1.next;
            }
        }
        return null;
    }


    public static void main(String[] args) {
       /* Node node = new Node(1);
        Node node1 = new Node(2);
        node.next = node1;
        node.next.next = new Node(3);
        node.next.next.next = node1;
        System.out.println(getLoopNode(node).getValue());*/
        //1.
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.next = node1;
        Node node2 = new Node(3);
        node.next.next = node2;
        //2.
        Node node3 = new Node(5);
        node3.next = node2;
        System.out.println(getNoLoop(node1, node3).getValue());
    }
}
