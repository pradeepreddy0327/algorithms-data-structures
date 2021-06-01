package trie;

import java.util.HashMap;
import java.util.Map;

// leetcode 211  tags: Facebook
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary n = new WordDictionary();
        n.addWord("bad");
        n.addWord("dad");
        n.addWord("mad");
        System.out.println(n.search("pad"));
        System.out.println(n.search("bad"));
        System.out.println(n.search(".ad"));
        System.out.println(n.search("b.."));
    }
    TrieNode node;
    public WordDictionary() {
        node = new TrieNode();
    }

    public void addWord(String word) {
        node.addWord(word);
    }

    public boolean search(String word) {
        return node.dfs(word, 0);
    }

    class TrieNode{
        boolean        isWord;
        Map<Character, TrieNode> children;

        TrieNode(){
            children = new HashMap<>();
        }
        void addWord(String word){
            TrieNode parent = this;
            for(int i=0;i<word.length();i++){
                TrieNode node = parent.children.get(word.charAt(i));
                if(node == null){
                    node = new TrieNode();
                    parent.children.put(word.charAt(i), node);
                }
                parent = node;
            }
            parent.isWord = true;
        }

        boolean dfs(String word, int index) {
            if (index >= word.length()) return false;
            TrieNode parent = this;
            while (index < word.length()) {
                char c = word.charAt(index);
                if (c == '.') {
                    if (index == word.length() - 1) return parent.children.values().stream().filter(a -> a.isWord).count() > 0;
                    for (TrieNode value : parent.children.values()) {
                        if (value.dfs(word, index + 1))
                            return true;
                    }
                    return false;
                } else {
                    if (parent.children.get(c) == null) return false;
                    if (index == word.length() - 1) return parent.children.get(c).isWord;
                    parent = parent.children.get(c);
                }
                index++;
            }
            return false;
        }
    }
}



