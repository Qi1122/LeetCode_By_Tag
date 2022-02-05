/*
https://leetcode.com/problems/word-search-ii/

dfs + trie
 */
package algorithm.src;

import java.util.*;

public class Word_Search_II_212 {
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = Trie(words);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, TrieNode cur) {
        char c = board[row][col];
        if (c == '#' || cur.children[c- 'a'] == null) return;
        cur = cur.children[c - 'a'];
        if (cur.word != null) { //found one word
            res.add(cur.word);
            cur.word = null; // de-duplicate
        }
        board[row][col] = '#';
        if (row > 0) dfs(board, row - 1, col, cur);
        if (col > 0) dfs(board, row, col - 1, cur);
        if (row < board.length - 1) dfs(board, row + 1, col, cur);
        if (col < board[0].length - 1) dfs(board, row, col + 1, cur);
        board[row][col] = c;
    }

    private TrieNode Trie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for(char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new TrieNode();
                cur = cur.children[i];
            }
            cur.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
