package com.dongdong.spring.test.alBook.unit03Tree;

/**
 * 判断t1树中是否与t2树拓扑结构完全相同的子树
 */
public class Class11_T1TreeContainsT2TreeToPu {

    private static boolean contains(Node t1, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return check(t1, t2) && contains(t1.left, t2) && contains(t2.right, t2);
    }

    private static boolean check(Node h, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (h == null || h.value != t2.value) {
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }
}
