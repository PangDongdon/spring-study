package com.dongdong.spring.test.leetCode.linkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/9/9  11:44
 * @Author: dongdong
 */
public class Sort21 {

    public ListNode mergeTwoSortLinkedList(ListNode node1, ListNode node2) {
        ListNode node3 = new ListNode(-1);
        ListNode temp=node3;
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1 == null) {
            return node2;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (node1 != null) {
            list1.add(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            list2.add(node2.val);
            node2 = node2.next;
        }
        list1.addAll(list2);
        Collections.sort(list1);
        System.out.println(list1);
        for (int i = 0; i < list1.size(); i++) {
            temp.next = new ListNode(list1.get(i));
            temp=temp.next;
        }
        return node3.next;
    }
    @Test
    public void getList(){
        ListNode node1= new ListNode(6);
        node1.next=new ListNode(2);
        ListNode node2=new ListNode(1);
        System.out.println(mergeLinkedList(node1,node2).val);
    }


    /**leetCode*/

    public ListNode mergeLinkedList(ListNode node1,ListNode node2){
        if(node1==null){
            return  node2;
        }
        if(node2==null){
            return  node1;
        }
        if(node1.val<node2.val){
            node1.next=mergeLinkedList(node1.next,node2);
            return  node1;
        }else{
            node2.next=mergeLinkedList(node1,node2.next);
            return  node2;
        }
    }
}


