package com.dongdong.spring.test.alBook.unit02Link;

public class Class01_PrintTwoLinkCommonPart {

    private void printCommonPart(Node node1, Node node2) {
        while (node1 != null && node2 != null) {
            if (node1.getValue() > node2.getValue()) {
                node2 = node2.next;
            } else if (node1.getValue() < node2.getValue()) {
                node1 = node1.next;
            } else {
                System.out.print(node1.getNode() + "");
                node2 = node2.next;
                node1 = node1.next;
            }
            System.out.println();
        }
    }
}
