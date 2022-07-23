package com.dongdong.spring.test.alBook.unit02Link;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//将搜索二叉树转化为双链表
public class Class14_SearchTreeTransIntoDoubleLink {

    //借助队列
    private static TreeNode convert1(TreeNode head) {
        Queue<TreeNode> deque = new LinkedList<>();
        //递归调用树，数据存入队列
        inOderQueue(head, deque);
        if(deque.isEmpty()){
            return head;
        }
        TreeNode head2 = deque.poll();
        TreeNode pre = head2;
        pre.left = null;
        TreeNode cur = null;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head2;
    }

    private static void inOderQueue(TreeNode node, Queue<TreeNode> deque) {
        if (node == null) {
            return;
        }
        inOderQueue(node.left, deque);
        deque.offer(node);
        inOderQueue(node.left, deque);
    }

    //使用递归实现
    private static TreeNode convert2(TreeNode head) {
        if (head == null) {
            return null;
        }
        return process(head).start;
    }


    private static class ReturnTypeNode {
        public TreeNode start;
        public TreeNode end;

        public ReturnTypeNode(TreeNode start, TreeNode end) {
            this.end = end;
            this.start = start;
        }
    }

    //handle
    private static ReturnTypeNode process(TreeNode head) {
        if (head == null) {
            return new ReturnTypeNode(null, null);
        }
        ReturnTypeNode leftNode = process(head.left);
        if (leftNode.end != null) {
            leftNode.end.right = head;
        }
        ReturnTypeNode rightNode = process(head.right);
        if (rightNode.start != null) {
            rightNode.start.left = head;
        }
        head.left = leftNode.end;
        head.right = rightNode.start;
        return new ReturnTypeNode(leftNode.start != null ? leftNode.start : head,
                rightNode.end != null ? rightNode.end : head);
    }
}
