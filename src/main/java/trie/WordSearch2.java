package trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

	// word search 2 leetcode 212
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node root;
	List<String> ans;

	public List<String> findWords(char[][] board, String[] words) {
		root = new Node();
		ans = new ArrayList<>();
		for (String s : words) {
			addWord(s);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (root.children[board[i][j] - 'a'] != null) {
					dfs(board, i, j, root.children[board[i][j] - 'a']);
				}
			}
		}
		return ans;
	}

	private void dfs(char[][] board, int i, int j, Node node) {
		if (node.word != null) {
			ans.add(node.word);
			node.word = null;
		}
		char t = board[i][j];
		board[i][j] = '#';
		if (i - 1 >= 0 && board[i - 1][j] != '#' && node.children[board[i - 1][j] - 'a'] != null)
			dfs(board, i - 1, j, node.children[board[i - 1][j] - 'a']);
		if (i + 1 < board.length && board[i - 1][j] != '#' && node.children[board[i + 1][j] - 'a'] != null)
			dfs(board, i + 1, j, node.children[board[i + 1][j] - 'a']);
		if (j - 1 >= 0 && board[i - 1][j] != '#' && node.children[board[i][j - 1] - 'a'] != null)
			dfs(board, i, j - 1, node.children[board[i][j - 1] - 'a']);
		if (j + 1 < board[i].length && board[i - 1][j] != '#' && node.children[board[i][j + 1] - 'a'] != null)
			dfs(board, i, j + 1, node.children[board[i][j + 1] - 'a']);
		board[i][j] = t;

	}

	private void addWord(String s) {
		Node[] children = root.children;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			Node n = children[chars[i] - 'a'];
			if (n == null) {
				n = new Node();
				children[chars[i] - 'a'] = n;
			}
			if (i == chars.length - 1)
				n.word = s;
			children = n.children;
		}
	}

}

class Node {
	Node[] children;
	String word;

	Node() {
		this.children = new Node[26];
	}
}
