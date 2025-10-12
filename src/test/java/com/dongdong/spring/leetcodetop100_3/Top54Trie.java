package com.dongdong.spring.leetcodetop100_3;

/**
 * 前缀树
 */
public class Top54Trie {

    private Top54Trie[] children;
    private boolean isEnd;

    public Top54Trie() {
        children = new Top54Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Top54Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Top54Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        final Top54Trie top54Trie = searchPrefix(word);
        return top54Trie != null && top54Trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Top54Trie searchPrefix(String prefix) {
        Top54Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
