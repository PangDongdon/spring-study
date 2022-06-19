package com.dongdong.spring.test.sort5.study.unit01;

import java.util.HashMap;

public class Code01_LeastRecentlyUsedCache {

    public static class Node<V> {
        private V value;
        private Node<V> last;
        private Node<V> next;

        public Node(V data) {
            this.value = data;
        }
    }

    public static class NodeDoubleLinkedList<V> {
        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList() {
            head = null;
            tail = null;
        }

        public void addNode(Node<V> node) {
            if (node == null) {
                return;
            }
            if (head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.last = this.tail;
                this.tail = node;
            }
        }

        public void moveNodeToTail(Node<V> node) {
            if (node == null) {
                return;
            }
            if (node == this.tail) {
                return;
            }
            if (node == this.head) {
                this.head = node.next;
                node.next.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node<V> deleteHead() {
            if (head == null) {
                return null;
            }
            Node<V> res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }
    }

    public  static  class MyCache<K,V>{
        private HashMap<K,Node<V>> keyNodeMap;
        private HashMap<Node<V>,K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;

        public  MyCache(int capacity) throws Exception {
            if(capacity<1){
                throw new Exception("invalid capacity");
            }
            keyNodeMap=new HashMap<K,Node<V>>();
            nodeKeyMap=new HashMap<Node<V>,K>();
            nodeList=new NodeDoubleLinkedList<V>();
        }

        public V getValue(K key){
            if(this.keyNodeMap.containsKey(key)){
                Node<V> node = keyNodeMap.get(key);
                nodeList.moveNodeToTail(node);
                return  node.value;
            }
            return  null;
        }

        public void setValue(K key,V value){
            if(this.keyNodeMap.containsKey(key)){
                Node<V> node = keyNodeMap.get(key);
                node.value=value;
                nodeList.moveNodeToTail(node);
            }else{
                Node<V> node=new Node<>(value);
                keyNodeMap.put(key,node);
                nodeKeyMap.put(node,key);
                nodeList.moveNodeToTail(node);
                if(this.keyNodeMap.size()==this.capacity+1){
                    removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node<V> node = nodeList.deleteHead();
            K k = nodeKeyMap.get(node);
            this.nodeKeyMap.remove(k);
            this.keyNodeMap.remove(k);
        }
    }

    public static void main(String[] args) {
        com.dongdong.spring.test.sort5.unit02.Code01_LeastRecentlyUsedCache.MyCache<String, Integer> testCache = new com.dongdong.spring.test.sort5.unit02.Code01_LeastRecentlyUsedCache.MyCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));

    }
}
