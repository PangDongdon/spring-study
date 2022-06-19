package com.dongdong.spring.test.alBook.unit02Link;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import net.dongliu.commons.Sys;

import java.util.Stack;

//判断链表是否是回文
public class Class06_isPalindromeLink {

    //使用栈空间check 是否是回文
    private static boolean isPalindrome(Node node) {
        if (node == null || node.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node right = node.next;
        Node cur = node;
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            right = right.next;
        }
        while (right != null) {
            stack.push(right.getValue());
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (node.getValue() != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    //不使用栈空间check 是否是回文
    private static boolean isPalindrome2(Node node) {
        if (node == null || node.next == null) {
            return true;
        }
        //使用快慢指针找到中间的节点
        Node n1 = node;
        Node n2 = node;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //得到右半部分的第一个节点
        n2 = n1.next;
        //左半部分的最后一个节点
        n1.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        //保存最后一个节点
        n3 = n1;
        n2 = node;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.getValue() != n2.getValue()) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(1);
       // node.next.next.next.next = new Node(3);
        System.out.println(isPalindrome(node));
        System.out.println(isPalindrome2(node));
    }
}
