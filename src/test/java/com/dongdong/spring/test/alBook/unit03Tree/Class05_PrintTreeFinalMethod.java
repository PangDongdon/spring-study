package com.dongdong.spring.test.alBook.unit03Tree;

//遍历二叉树的神级方法(morris 遍历)
public class Class05_PrintTreeFinalMethod {

    private static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node morris = null;
        while (cur != null) {
            morris = head.left;
            if (morris != null) {
                while (morris.right != null && morris.right != cur) {
                    morris = morris.right;
                }
                if (morris.right == null) {
                    morris.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    morris.right = null;
                }
            }
            cur = cur.right;

        }
    }


    private static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node morris = null;
        while (cur != null) {
            morris = cur.left;
            if (morris != null) {
                while (morris.right != null && morris.right != cur) {
                    morris = morris.right;
                }
                if (morris.right == null) {
                    morris.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                } else {
                    morris.right = null;
                }
            } else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    private static void morrisInOrder(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node morris = null;
        while (cur != null) {
            morris = cur.left;
            if (morris != null) {
                while (morris.right != null && morris.right != cur) {
                    morris = morris.right;
                }
                if (morris.right == null) {
                    morris.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    morris.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }


    private static void morrisPostOrder(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node morris = null;
        while (cur != null) {
            morris = cur.left;
            if (morris != null) {
                while (morris.right != null && morris.right != cur) {
                    morris = morris.right;
                }
                if (morris.right == null) {
                    morris.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    morris.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(Node node) {
        Node tail = reverseEdge(node);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        morrisPre(node);
        morrisInOrder(node);
        morrisPostOrder(node);
    }
}
