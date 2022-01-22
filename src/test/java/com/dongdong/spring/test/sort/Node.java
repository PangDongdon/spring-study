package com.dongdong.spring.test.sort;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public int out;
    public int in;
    public List<Node> nexts;
    public List<Edge>  edges;

    public Node(int value){
        this.value=value;
        this.out =0;
        this.in =0;
        this.nexts=new ArrayList<>();
        this.edges=new ArrayList<>();
    }
}
