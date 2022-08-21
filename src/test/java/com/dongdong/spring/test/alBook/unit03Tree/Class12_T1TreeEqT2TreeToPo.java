package com.dongdong.spring.test.alBook.unit03Tree;

/**
 * 判断t1树中是否与t2树拓扑结构完全相同的子树
 */
public class Class12_T1TreeEqT2TreeToPo {

    public static boolean isSubTree(Node head1, Node head2) {
        String s1 = serialByPre(head1);
        String s2 = serialByPre(head2);
        return getIndexOf(s1, s2) != -1;
    }

    public static String serialByPre(Node node) {
        if (node == null) {
            return "#!";
        }
        String res = node.value + "!";
        res += serialByPre(node.left);
        res += serialByPre(node.right);
        return res;
    }

    //KMP
    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int s1i = 0;
        int s2i = 0;
        int[] next = getNextArray(ss2);
        while (s1i < ss1.length && s2i < ss2.length) {
            if (ss1[s1i] == ss2[s2i]) {
                s1i++;
                s2i++;
            } else if (next[s2i] == -1) {
                s1i++;
            } else {
                s1i = next[s1i];
            }
        }
        return s2i == ss2.length ? s1i - s2i : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
