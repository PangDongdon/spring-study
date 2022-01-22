package com.dongdong.spring.test.sort;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 */
public class UnionFind {

    public  static class Data{

    }

    public static  class DisjointSets{
        public HashMap<Data, Data> fatherMap;
        public HashMap<Data,Integer> rankMap;

        public DisjointSets(){
         fatherMap=new HashMap<>();
         rankMap=new HashMap<>();
        }


        //初始化数据
        public void makeSets(List<Data> nodes){
            if(CollectionUtils.isEmpty(nodes)){
                return;
            }
            fatherMap.clear();
            rankMap.clear();
            for(Data node:nodes){
                fatherMap.put(node,node);
                rankMap.put(node,1);
            }
        }

        public Data findData(Data head){
            if(head==null){
                return  null;
            }
            Data father=fatherMap.get(head);
            if(father!=head){
                father=findData(father);
            }
            fatherMap.put(head,father);
            return  father;
        }

        public  void  union(Data head,Data head2){
            if(head==null || head2==null){
                return;
            }
            Data a=findData(head);
            Data b=findData(head2);
            if(a!=b){
                if(rankMap.get(a)<rankMap.get(b)){
                    fatherMap.put(a,b);
                    rankMap.put(a,rankMap.get(a)+rankMap.get(b));
                }else{
                    fatherMap.put(b,a);
                    rankMap.put(b,rankMap.get(a)+rankMap.get(b));
                }
            }
        }

    }

}

