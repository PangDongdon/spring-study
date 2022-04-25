package com.dongdong.spring.test.sort.test.unit03;

public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = loopNode(head1);
        Node loop2 = loopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return loop(head1, head2, loop1, loop2);
        }
        return null;
    }

    //判断是否是环形链表
    public static Node loopNode(Node head) {
        if (head.next == null || head.next.next == null) {
            return null;
        }
        Node low = head.next;
        Node fast = head.next.next;
        while (fast != low) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            low = low.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }

    //两个非环形链表相交的第一个节点
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            n--;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
    }

    //两个环形链表相交的节点
    public static Node loop(Node head1, Node head2, Node loop1, Node loop2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            int n = 0;
            cur1 = head1;
            cur2 = head2;
            while (cur1.next != loop1) {
                cur1 = cur1.next;
                n++;
            }
            while (cur2.next != loop1) {
                cur2 = cur2.next;
                n--;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0) {
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur2;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

   /* public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node node10 = new Node(1);
        node10.next = node5;
        node5.next = node6;
        System.out.println(noLoop(node, node10).value);
        // node6.next = node3;
        //System.out.println(loopNode(node).value);
    }
*/

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new  Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
}
