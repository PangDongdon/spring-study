package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Date: 2020/9/9  14:24
 * @Author: dongdong
 */
public class Sort23 {
    public ListNode mergeKLinkedList(ListNode[] nodes){
        ListNode node1=new ListNode(0);
        ListNode temp=node1;
        List<Integer> listAll=new ArrayList<>();
        for(int i=0;i<nodes.length;i++){
           listAll.addAll(getList(nodes[i]));
        }
        Collections.sort(listAll);
        for (int i = 0; i < listAll.size(); i++) {
            temp.next = new ListNode(listAll.get(i));
            temp=temp.next;
        }
        return  node1.next;
    }


    private  List<Integer> getList(ListNode node){
        List<Integer> list=new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return  list;
    }

    @Test
    public void getList(){
        ListNode node1= new ListNode(6);
        node1.next=new ListNode(2);
        ListNode node2=new ListNode(1);

        ListNode node3=new ListNode(8);
        ListNode[] nodes={node1,node2,node3};
        System.out.println(mergeKLinkedList(nodes).val);
    }


    /**do it  by leetCode  nice*/
    public ListNode mergeKlist(ListNode[] lists){
        PriorityQueue<ListNode> heap=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for(ListNode node:lists){
            if(node!=null){
                heap.offer(node);
            }
        }
        ListNode pre=new ListNode(-1);
        ListNode temp=pre;
        while(!heap.isEmpty()){
            ListNode curr=heap.poll();
            temp.next=new ListNode(curr.val);
            if(curr.next!=null){
                heap.offer(curr.next);
            }
            temp=temp.next;
        }
        return  pre.next;
    }

}
