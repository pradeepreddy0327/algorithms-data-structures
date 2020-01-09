package leet.code;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	TrieNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie obj = new Trie();
		  obj.insert("abc");
		  System.out.println(obj.search("abc"));
		  System.out.println(obj.startsWith("ac"));
	}
	
	Trie(){
		root = new TrieNode();
	}

	public void insert(String s) {
		Map<Character, TrieNode> children = root.children;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode t = children.get(c);
			if (t == null) {
				t = new TrieNode(c);
				children.put(c, t);
			}
			if (i == s.length() - 1)
				t.isLeaf = true;
			children = t.children;
		}
	}

	public boolean search(String s) {
		Map<Character, TrieNode> children = root.children;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode t = children.get(c);
			if (t == null)
				return false;
			if (i == s.length() - 1 && t.isLeaf)
				return true;
			children = t.children;
		}
		return false;
	}
	
	public boolean startsWith(String s) {
		Map<Character, TrieNode> children = root.children;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieNode t = children.get(c);
			if (t == null)
				return false;
			children = t.children;
		}
		return true;
	}

}

class TrieNode {
	char c;
	Map<Character, TrieNode> children;
	boolean isLeaf;

	TrieNode() {
		this.children = new HashMap<>();
	}

	TrieNode(char c) {
		this.c = c;
		this.children = new HashMap<>();
	}
}