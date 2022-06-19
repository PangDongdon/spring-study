package com.dongdong.spring.test.alBook;


import com.dongdong.spring.test.alBook.unit02Link.Node;

public class Utils {


    public static void printData(int[] ss) {
        if (ss == null) {
            return;
        }
        for (int i : ss) {
            System.out.print(i + " ");
        }
    }

    public static void printData(int[][] ss) {
        if (ss == null || ss[0] == null) {
            return;
        }
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < ss[i].length; j++) {
                System.out.print(ss[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node=node.next;
        }
    }

}
