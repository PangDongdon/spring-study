package com.dongdong.spring.test.sort.test.unit05;

public class TrieTree {

    public static class TrieNode {
        private int pass;
        private int end;
        private TrieNode[] nexts;

        public TrieNode(int pass, int end, TrieNode[] nexts) {
            this.end = end;
            this.pass = pass;
            this.nexts = nexts;
        }

        public TrieNode() {

        }
    }

    public static class Trie {
        private static TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String str) {
            if (str.isEmpty()) {
                return;
            }
            TrieNode node = root;
            int index = 0;
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (root.nexts[index] == null) {
                    root.nexts[index] = new TrieNode();
                }
                node = root.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public static boolean search(String str) {
            if (str.isEmpty()) {
                return false;
            }
            TrieNode node = root;
            int index = 0;
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (root.nexts[index] == null) {
                    return false;
                }
                node = root.nexts[index];
            }
            return node.end != 0;
        }

        public static void delete(String str) {
            if (search(str)) {
                TrieNode node = root;
                int index = 0;
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }

        }
    }


}
