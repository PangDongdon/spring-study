package com.dongdong.spring.test.sort;

import org.junit.Test;

import java.util.Stack;

/**
 * 验证链表是否是回文
 */
public class IsPalindromeList {

    public static class Node {
        private int value;
        private Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //空间复杂度O(n)
    public boolean isIsPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        //将原有数据存储在栈中
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //空间复杂度O(n/2)
    public boolean isIsPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> node = new Stack<>();
        while (right != null) {
            node.push(right);
            right = right.next;
        }
        while (head != null && !node.isEmpty()) {
            if (head.value != node.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //O(1) extra space
    public boolean isIsPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        return false;
    }


    @Test
    public void test() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(1);
        System.out.println(isIsPalindrome2(node));
        System.out.println(isIsPalindrome(node));
    }
}
