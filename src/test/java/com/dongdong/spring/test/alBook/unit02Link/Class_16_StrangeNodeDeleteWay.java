package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;

//一个怪异节点的删除的方式
public class Class_16_StrangeNodeDeleteWay {

    private static void removeNodeWired(Node node) {
        if (node == null) {
            return;
        }
        Node next = node.next;
        if (next == null) {
            throw new RuntimeException("last node not delete");
        }
        node.value = next.value;
        node.next = next.next;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.next = node2;
        node2.next = node3;
        removeNodeWired(node2);
        Utils.printNode(node);
    }
}
