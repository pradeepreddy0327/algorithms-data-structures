package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch3 {

    // word search 2 leetcode 212
    public static void main(String[] args) {
        WordSearch3 obj = new WordSearch3();
        System.out.println(obj.findWords(
                new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
                        { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } },
                new String[] { "oath", "pea", "eat", "rain" }));

    }

    Trie root;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        constructTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    char c = board[i][j];
                    board[i][j] = '#';
                    dfs(board, i, j, root.children[c - 'a'], ans);
                    board[i][j] = c;
                }
            }
        }
        return new ArrayList<String>(ans);
    }

    int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private void dfs(char[][] board, int i, int j, Trie trie, Set<String> ans) {
        if (trie.word != null) {
            ans.add(trie.word);
        }
        for (int[] d : dir) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (newI >= 0 && newI < board.length && newJ >= 0
                    && newJ < board[i].length && board[newI][newJ] != '#') {
                char c = board[newI][newJ];
                if (trie.children[c - 'a'] != null) {
                    board[newI][newJ] = '#';
                    dfs(board, newI, newJ, trie.children[c - 'a'], ans);
                    board[newI][newJ] = c;
                }
            }
        }
    }

    private void constructTrie(String[] words) {
        root = new Trie();
        for (String s : words) {
            Trie current = root;
            for (char c : s.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Trie();
                }
                current = current.children[c - 'a'];
            }
            current.word = s;
        }
    }

    private class Trie {
        Trie[] children;
        String word;

        Trie() {
            children = new Trie[26];
        }
    }
}
