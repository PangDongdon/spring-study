package com.dongdong.spring.test.alBook.unit02Link;

import lombok.Data;

@Data
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    private int value;

    public TreeNode(int value){
        this.value=value;
    }
}
