package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//lc 127
public class WordLadder {

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        System.out.println(obj.ladderLength("hit", "cog",
                new ArrayList<String>(Arrays.asList(new String[] { "hot",
                        "dot",
                        "dog", "lot", "log", "cog" }))));

    }

    public int ladderLength(String beginWord, String endWord,
            List<String> wordList) {
        if (wordList.indexOf(endWord) < 0) {
            return 0;
        }
        wordList.add(beginWord);
        HashSet<Integer>[] adjList = new HashSet[wordList.size()];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (hasEdge(wordList.get(i), wordList.get(j))) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        return bfs(adjList, wordList.indexOf(beginWord),
                wordList.indexOf(endWord));
    }

    private int bfs(HashSet<Integer>[] adjList, int from, int to) {
        boolean[] v = new boolean[adjList.length];
        int[] lvl = new int[adjList.length];
        v[from] = true;
        lvl[from] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            for (Integer adj : adjList[vertex]) {
                if (!v[adj]) {
                    v[adj] = true;
                    lvl[adj] = lvl[vertex] + 1;
                    q.add(adj);
                    if (adj == to) {
                        return lvl[adj];
                    }
                }
            }
        }

        return lvl[to];
    }

    private boolean hasEdge(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

}
