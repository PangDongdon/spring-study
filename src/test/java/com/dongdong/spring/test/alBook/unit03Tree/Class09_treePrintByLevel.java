package com.dongdong.spring.test.alBook.unit03Tree;

import net.dongliu.commons.Sys;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的按层打印与ZigZag打印
 */
public class Class09_treePrintByLevel {


    public static void printByLevel(Node head) {
        if (head == null) {
            return;
        }
        Node last = head;
        Node nLast = null;
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        System.out.print("Level" + (level++) + ":");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel" + (level++) + ":");
                last = nLast;
            }
        }
    }

    public static void printTreeByZz(Node head) {
        if (head == null) {
            return;
        }
        Node last = head;
        Node nLast = null;
        boolean lr = true;
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.add(head);
        int level = 1;
        printLevelAndOrientation(level++, lr);
        while (!nodeDeque.isEmpty()) {
            if (lr) {
                head = nodeDeque.pollFirst();
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    nodeDeque.offerLast(head.left);
                }
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    nodeDeque.offerLast(head.right);
                }
            } else {
                head = nodeDeque.pollLast();
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    nodeDeque.offerFirst(head.right);
                }
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    nodeDeque.offerFirst(head.left);
                }
            }
            System.out.print(head.value + " ");
            if (last == head && !nodeDeque.isEmpty()) {
                last = nLast;
                nLast = null;
                lr = !lr;
                System.out.println();
                printLevelAndOrientation(level++, lr);
            }
        }
    }

    private static void printLevelAndOrientation(int level, boolean lr) {
        System.out.print("Level " + level + " from ");
        System.out.print(lr ? "left to right : " : "right to left : ");
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        //printByLevel(node);
        printTreeByZz(node);
    }

}
