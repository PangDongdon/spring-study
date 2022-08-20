package com.dongdong.spring.test.alBook.unit03Tree;

import net.dongliu.commons.Sys;

import java.util.LinkedList;
import java.util.Queue;

//序列化和反序列化树
public class Class04_SerializeAndDeSerializeTree {


    //前序遍历的序列化
    private static String serialPreString(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialPreString(head.left);
        res += serialPreString(head.right);
        return res;
    }

    //前序遍历的反序列化
    private static Node reconByPreString(String str) {
        String[] strs = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : strs) {
            queue.add(s);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String data = queue.poll();
        if ("#".equals(data)) {
            return null;
        }
        Node node = new Node(Integer.parseInt(data));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }


    //层序遍历的序列化
    private static String serialByLevel(Node node) {
        if (node == null) {
            return "#!";
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        String res = node.value + "!";
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                res += cur.left.value + "!";
            } else {
                res += "#!";
            }
            if (cur.right != null) {
                queue.add(cur.right);
                res += cur.right.value + "!";
            } else {
                res += "#!";
            }
        }
        return res;
    }

    //层序遍历的反序列化
    private static Node reconByLevelString(String str) {
        String[] strs = str.split("!");
        int index = 0;
        Node head = generateNodeByString(strs[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(strs[index++]);
            node.right = generateNodeByString(strs[index++]);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    public static Node generateNodeByString(String val) {
        if ("#".equals(val)) {
            return null;
        }
        return new Node(Integer.parseInt(val));
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        String s1 = serialPreString(node);
        Node node1 = reconByPreString(s1);
        Utils.printTree(node1);
        String s2 = serialByLevel(node);
        Node node2 = reconByLevelString(s2);
        Utils.printTree(node2);
    }

}
