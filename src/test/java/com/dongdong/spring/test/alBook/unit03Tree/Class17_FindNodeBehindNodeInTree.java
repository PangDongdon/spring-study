package com.dongdong.spring.test.alBook.unit03Tree;

//在二叉树中找到一个节点的后继节点
public class Class17_FindNodeBehindNodeInTree {

    public static Node2 getNextNode(Node2 node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node2 parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node2 getLeftMost(Node2 node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {

    }

}
