package com.dongdong.spring.test.sort;

import org.apache.commons.lang.StringUtils;

public class TrieTree {

    public static class TrieNode {
        private int path;
        private int end;
        private TrieNode[] map;

        public TrieNode() {
            this.end = 0;
            this.path = 0;
            this.map = new TrieNode[26];
        }
    }

    public static class Tire {
        private TrieNode root;

        public Tire() {
            root = new TrieNode();
        }

        public void insert(String s) {
            if (StringUtils.isBlank(s)) {
                return;
            }
            char[] ss = s.toCharArray();
            TrieNode node = root;
            int f=0;
            for (int i = 0; i < ss.length; i++) {
                f = ss[i] - 'a';
                if (node.map[f] == null) {
                    node.map[f] = new TrieNode();
                }
                node = node.map[f];
                node.path++;
            }
            node.end++;
        }


        //delete
        public void delete(String s) {
            if (StringUtils.isBlank(s) || !search(s)) {
                return;
            }
            char[] ss = s.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < ss.length; i++) {
                int f = ss[i] - 'a';
                if (node.map[f].path-- == 1) {
                    node.map[f] = null;
                    return;
                }
                node = node.map[f];
            }
            node.end--;
        }

        //search
        public boolean search(String s) {
            if (StringUtils.isBlank(s)) {
                return false;
            }
            char[] ss = s.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < ss.length; i++) {
                int f = ss[i] - 'a';
                if (node.map[f] == null) {
                    return false;
                }
                node = node.map[f];
            }
            return node.end != 0;
        }

        //
        public int prefixNumber(String pre) {
            if (StringUtils.isBlank(pre)) {
                return 0;
            }
            char[] ss = pre.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < ss.length; i++) {
                int f = ss[i] - 'a';
                if (node.map[f] == null) {
                    return 0;
                }
                node = node.map[f];
            }
            return node.path;
        }
    }

    //false
    //true
    //false
    //true
    //false
    //false
    //3


    public static void main(String[] args) {
        Tire trie = new Tire();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }



}
