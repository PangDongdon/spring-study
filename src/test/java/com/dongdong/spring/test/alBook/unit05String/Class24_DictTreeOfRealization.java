package com.dongdong.spring.test.alBook.unit05String;

/**
 * 字典树（前缀）的实现
 */
public class Class24_DictTreeOfRealization {

    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }

    public class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.path++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word)) {
                char[] chars = word.toCharArray();
                int index = 0;
                TrieNode node = root;
                node.path++;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (node.map[index].path-- == 1) {
                        node.map[index] = null;
                        return;
                    }
                    node = node.map[index];
                }
                node.end--;
            }
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                node = node.map[index];
                if (node == null) {
                    return false;
                }
            }
            return node.end != 0;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.map[index] == null) {
                    return 0;
                }
                node = node.map[index];
            }
            return node.path;
        }
    }

}
