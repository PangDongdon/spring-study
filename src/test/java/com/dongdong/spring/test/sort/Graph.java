package com.dongdong.spring.test.sort;

import java.util.*;

//图
public class Graph {
  public HashMap<Integer,Node> nodes;
  public HashSet<Edge> edges;

  public  Graph(){
      this.edges=new HashSet<>();
      this.nodes=new HashMap<>();
  }
}
