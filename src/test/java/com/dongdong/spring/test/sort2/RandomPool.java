package com.dongdong.spring.test.sort2;

import com.dongdong.spring.test.sort.basic_class_03.Code_06_RandomPool;

import java.util.HashMap;

public class RandomPool {

    public static class Pool<K>{

        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private  Integer index;

         public  Pool(){
             this.index=0;
             this.indexKeyMap=new HashMap<>();
             this.keyIndexMap=new HashMap<>();
        }

        public  void put(K key){
             if(!keyIndexMap.containsKey(key)){
                 keyIndexMap.put(key,index);
                 indexKeyMap.put(index++,key);
             }
        }

        public  void delete(K key){
            if(keyIndexMap.containsKey(key)){
               int deleteIndex=keyIndexMap.get(key);
               int lastIndex=--this.index;
               K lastKey=indexKeyMap.get(lastIndex);
               keyIndexMap.put(lastKey,deleteIndex);
               indexKeyMap.put(deleteIndex,lastKey);
               keyIndexMap.remove(key);
               indexKeyMap.remove(lastIndex);
            }
        }


        public K getRandom(){
           if(this.index==0){
               return  null;
           }
           int indexRandom=(int)(Math.random()*this.index);
           return  this.indexKeyMap.get(indexRandom);
        }

        public static void main(String[] args) {
            Code_06_RandomPool.Pool<String> pool = new Code_06_RandomPool.Pool<String>();
            pool.insert("zuo");
            pool.insert("cheng");
            pool.insert("yun");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
        }


       // cheng
       // cheng
       // zuo
       // cheng
       // cheng
       // yun

    }
}
