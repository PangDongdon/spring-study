package com.dongdong.spring.test.alBook.unit02Link;

import lombok.Data;

/**
 * 节点
 */
@Data
public class Node {
    public Node next;
    public int value;
    public Node(int value){
        this.value =value;
    }

    public Node getNode() {
        return next;
    }

    public int getValue() {
        return value;
    }
}
