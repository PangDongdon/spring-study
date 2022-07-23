package com.dongdong.spring.test.alBook.unit02Link;

import java.util.HashMap;
import java.util.Random;

//复制含有随机指针节点的链表
public class Class08_CopyRandomLink {

    //T->O(N),S->O(N)
    private NodeRandom copyListWithRandom(NodeRandom node) {
        NodeRandom cur = node;
        HashMap<NodeRandom, NodeRandom> map = new HashMap();
        //生成副本
        while (cur != null) {
            map.put(cur, new NodeRandom(cur.getValue()));
            cur = cur.next;
        }
        cur = node;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(node);
    }

    //T->O(N),S->O(1)
    private NodeRandom copyListWithRandom2(NodeRandom head) {
        //1.由1->2->3 调整为 1->1'-2->2'-3->3'
        NodeRandom cur = head;
        NodeRandom next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new NodeRandom(cur.getValue());
            cur.next.next = next;
            cur = next;
        }

        //2.调整rand 指针
        NodeRandom copy = null;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        //3.调整链表
        NodeRandom res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

}
