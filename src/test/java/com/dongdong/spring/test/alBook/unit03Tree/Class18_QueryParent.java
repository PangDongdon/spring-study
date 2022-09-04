package com.dongdong.spring.test.alBook.unit03Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//在二叉树中找到两个节点的最近公共祖先
public class Class18_QueryParent {

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


    public static class Record1 {
        private static Map<Node, Node> map;

        public Record1(Node head) {
            map = new HashMap<>();
            if (head != null) {
                map.put(head, null);
            }
            setMap(head);
        }

        private static void setMap(Node head) {
            if (head == null) {
                return;
            }
            if (head.left != null) {
                map.put(head.left, head);
            }
            if (head.right != null) {
                map.put(head.right, head);
            }
            setMap(head.left);
            setMap(head.right);
        }

        public static Node query(Node o1, Node o2) {
            HashSet<Node> res = new HashSet<>();
            while (map.containsKey(o1)) {
                res.add(map.get(o1));
                o1 = map.get(o1);
            }
            while (!res.contains(o2)) {
                o2 = map.get(o2);
            }
            return o2;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.left = node1;
        Node node2 = new Node(4);
        node.left.left = node2;
        Node node3 = new Node(5);
        node.left.right = node3;

        System.out.println(lowestAncestor(node, node2, node3).value);
    }

    public static class Record2 {
        private static HashMap<Node, HashMap<Node, Node>> map;

        public Record2(Node head) {
            map = new HashMap<Node, HashMap<Node, Node>>();
            initMap(head);
            setMap(head);
        }

        private static void setMap(Node head) {
            if (head == null) {
                return;
            }
            map.put(head, new HashMap<Node, Node>());
            initMap(head.left);
            initMap(head.right);
        }

        private static void initMap(Node head) {
            if (head == null) {
                return;
            }
            headRecord(head.left, head);
            headRecord(head.right, head);
            subRecord(head);
            setMap(head.left);
            setMap(head.right);
        }

        private static void headRecord(Node n, Node h) {
            if (n == null) {
                return;
            }
            map.get(n).put(h, h);
            headRecord(n.left, h);
            headRecord(n.right, h);
        }

        private static void subRecord(Node head) {
            if (head == null) {
                return;
            }
            preLeft(head.left, head.right, head);
            subRecord(head.left);
            subRecord(head.right);
        }

        private static void preLeft(Node l, Node r, Node h) {
            if (l == null) {
                return;
            }
            preRight(l, r, h);
            preLeft(l.left, r, h);
            preLeft(l.right, r, h);
        }

        private static void preRight(Node l, Node r, Node h) {
            if (r == null) {
                return;
            }
            map.get(l).put(r, h);
            preRight(l, r.left, h);
            preRight(l, r.right, h);
        }

        public Node query(Node o1, Node o2) {
            if (o1 == o2) {
                return o1;
            }
            if (map.containsKey(o1)) {
                return map.get(o1).get(o2);
            }
            if (map.containsKey(o2)) {
                return map.get(o2).get(o1);
            }
            return null;
        }

    }
}
