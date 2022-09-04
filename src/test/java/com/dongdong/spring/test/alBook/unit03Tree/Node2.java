package com.dongdong.spring.test.alBook.unit03Tree;

//树的结构定义
public class Node2 {
    public Node2 left;
    public Node2 right;
    public Node2 parent;
    public int value;

    public Node2(int value) {
        this.value = value;
    }
}
