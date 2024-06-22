package com.dongdong.spring.leetcode;

import lombok.Data;

@Data
public class ListNode {
    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int val;

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
