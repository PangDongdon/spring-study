package com.dongdong.spring.leetcodetop100_2;

import java.util.HashMap;
import java.util.Map;

public class Top35LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    public DLinkedNode head, tail;

    public Top35LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在，先通过hash表定位，在移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        final DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key,node);
            addToHead(node);
            ++size;
            if(size>capacity){
                DLinkedNode tail=removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            dLinkedNode.value = value;
            moveToHead(dLinkedNode);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
