package leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutocompleteSystem2 {

    public static void main(String[] args) {
        AutocompleteSystem2 obj = new AutocompleteSystem2(new String[] {
                "i love you", "island", "ironman", "i love leetcode" },
                new int[] { 5, 3, 2, 2 });
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));
    }

    Trie root;
    String currentString = "";
    int returnSize = 3;
    public AutocompleteSystem2(String[] sentences, int[] times) {
        this.root = new Trie();
        int i = 0;
        for (String s : sentences) {
            insert(s, times[i++]);
        }
    }

    private void insert(String s, int times) {
        Trie current = root;
        for (char c : s.toCharArray()) {
            Trie t = current.children[getInt(c)];
            if (t == null) {
                t = new Trie();
            }
            current.children[getInt(c)] = t;
            current = t;
        }
        current.times += times;
    }

    private int getInt(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    private char getChar(int i) {
        return i == 26 ? ' ' : (char) (i + 'a');
    }

    private Trie getCurrentTrie() {
        Trie current = root;
        for (char c : currentString.toCharArray()) {
            Trie t = current.children[getInt(c)];
            if (t == null) {
                return null;
            }
            current = t;
        }
        return current;
    }
    public List<String> input(char c) {
        if (c == '#') {
            insert(currentString, 1);
            currentString = "";
            return new ArrayList<String>();
        }
        currentString += c;
        Trie currentTrie = getCurrentTrie();
        List<Node> nodes = new ArrayList<>();
        traverse(currentTrie, currentString, nodes);
        Collections.sort(nodes);
        List<String> result = new ArrayList<>();
        for (Node n : nodes) {
            result.add(n.word);
            if (result.size() == returnSize) {
                break;
            }
        }
        return result;
    }

    private void traverse(Trie currentTrie, String word, List<Node> l) {
        if (currentTrie != null) {
            if (currentTrie.times > 0) {
                l.add(new Node(currentTrie.times, word));
            }
            for(int i=0;i<currentTrie.children.length;i++) {
                traverse(currentTrie.children[i], word + getChar(i), l);
            }
        }
    }

    class Trie {
        Trie[] children;
        int times;

        Trie(){
            this.children = new Trie[27];
        }
    }

    class Node implements Comparable<Node> {
        int times;
        String word;

        Node(int times, String word) {
            this.times = times;
            this.word = word;
        }


        @Override
        public int compareTo(Node o) {
            return o.times != this.times ? o.times - this.times
                    : this.word.compareTo(o.word);
        }

        @Override
        public String toString() {
            return "Node [times=" + times + ", word=" + word + "]";
        }
    }
}
