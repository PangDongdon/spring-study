package com.dongdong.spring.test.alBook.unit03Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 */
public class Class15_IsSearchTreeAndAllTree {

    //是否为搜索二叉树
    public static boolean isBST(Node head) {
        if (head == null) {
            return false;
        }
        Node cur1 = head;
        Node cur2 = null;
        Node pre = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                return false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return true;
    }


    //是否为完全二叉树
    public static boolean isCBT(Node head) {
        if (head == null) {
            return false;
        }
        Node l = null;
        Node r = null;
        boolean leaf = false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (r != null || l != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        node.left.right = new Node(6);
        System.out.println(isBST(node));
    }

}
