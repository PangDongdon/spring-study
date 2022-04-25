package com.dongdong.spring.test.sort3.test.unit03;

import advanced_class_03.Code_02_SerializeAndReconstructTree;
import org.apache.logging.log4j.util.Strings;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "-";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reconByPreString(String s) {
        if (Strings.isBlank(s)) {
            return null;
        }
        String[] arr = s.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for (String str : arr) {
            queue.offer(str);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String s = queue.poll();
        if ("#".equals(queue.poll())) {

        }
        Node node = new Node(Integer.parseInt(s));
        node.left =reconByPreString(s);
        node.right=reconByPreString(s);
        return  node;
    }

    public static  String serialByLevel(Node node){
        if(node==null){
            return "#_";
        }
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(node);
        String res = node.value+"_";
        while(!queue.isEmpty()){
           Node node1=queue.poll();
           if(node1.left!=null){
            res+=node1.left.value+"_";
            queue.add(node.left);
           }else {
               res+="#_";
           }
            if(node1.right!=null){
                res+=node1.right.value+"_";
                queue.add(node.right);
            }else {
                res+="#_";
            }
        }
        return  res;
    }

}
