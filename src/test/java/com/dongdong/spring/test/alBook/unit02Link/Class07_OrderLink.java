package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;
import net.dongliu.commons.Sys;

//将单向链表按值划分为左边小,中间相等，右边大的形式
public class Class07_OrderLink {

    private static Node listPartition(Node node, int pivot) {
        if (node == null) {
            return node;
        }
        int count = 0;
        Node cur = node;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[count];
        cur = node;
        int i = 0;
        while (cur != null) {
            nodeArr[i++] = cur;
            cur = cur.next;
        }
        arrPartitoion(nodeArr, pivot);
        //数组连接
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        //最后指针——>null
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    private static void arrPartitoion(Node[] nodeArr, int privot) {
        int less = -1;
        int more = nodeArr.length;
        int index = 0;
        while (index < more) {
            if (nodeArr[index].getValue() < privot) {
                swapArray(nodeArr, ++less, index++);
            } else if (nodeArr[index].getValue() == privot) {
                index++;
            } else {
                swapArray(nodeArr, index, --more);
            }
        }
    }

    public static void swapArray(Node[] nodes, int a, int b) {
        Node temp = nodes[a];
        nodes[a] = nodes[b];
        nodes[b] = temp;
    }

    //使用变量来调整，不使用空间
    private static Node listPartition2(Node node, int privot) {
        if (node == null) {
            return node;
        }
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        //保留下一个节点
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = null;
            if (node.getValue() < privot) {
                if (sH == null) {
                    sH = node;
                    sT = node;
                } else {
                    sT.next = node;
                    sT = node;
                }
            } else if (node.getValue() == privot) {
                if (eH == null) {
                    eH = node;
                    eT = node;
                } else {
                    eT.next = node;
                    eT = node;
                }
            } else {
                if (bH == null) {
                    bH = node;
                    bT = node;
                } else {
                    bT.next = node;
                    bT = node;
                }
            }
            node = next;
        }
        //连接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }

    public static void main(String[] args) {
        Node node = new Node(9);
        node.next = new Node(0);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(1);
        Utils.printNode(node);
        System.out.println("  ");
      //  Utils.printNode(listPartition(node, 3));
        System.out.println("  ");
        Utils.printNode(listPartition2(node, 3));
    }
}
