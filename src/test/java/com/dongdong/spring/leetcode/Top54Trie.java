package com.dongdong.spring.leetcode;

import lombok.val;

/**
 *实现Tire前缀树
 */
public class Top54Trie {
    private Top54Trie[] children;
    private boolean isEnd;
    public Top54Trie() {
      children=new Top54Trie[26];
      isEnd=false;
    }

    public void insert(String word) {
       Top54Trie node=this;
       for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index=c-'a';
            if(node.children[index]==null){
                node.children[index]=new Top54Trie();
            }
            node=node.children[index];
       }
       node.isEnd=true;
    }

    public Top54Trie searchTirePrefix(String prefix) {
        Top54Trie node=this;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            int index=c-'a';
            if(node.children[index]==null){
                return null;
            }
            node=node.children[index];
        }
       return node;
    }

    public boolean search(String word) {
        Top54Trie node= searchTirePrefix(word);
        return node!=null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
       return searchTirePrefix(prefix)!=null;
    }

}
