package com.dongdong.spring.test.alBook.unit03Tree;

public class QueryParent {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || o1 == head || o2 == head) {
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null & right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.left = node1;
        Node node2 = new Node(4);
        node.left.left = node2;
        Node node3= new Node(5);
        node.left.right = node3;

        System.out.println(lowestAncestor(node,node2,node3).value);
    }
}
