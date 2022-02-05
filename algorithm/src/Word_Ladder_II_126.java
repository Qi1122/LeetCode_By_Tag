/*
https://leetcode.com/problems/word-ladder-ii/

1. find steps as word ladder I
2. use DFS to find all solution -> if list.get(3) = endWord -> put to final result
*/

package algorithm.src;
import java.util.*;

public class Word_Ladder_II_126 {
    List<List<String>> res = new ArrayList<>();
    Set<String> unvisited;
    int steps = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        steps = bfs(beginWord, endWord, wordList);
        System.out.println(steps);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        unvisited = new HashSet<>(wordList);
        unvisited.remove(beginWord);
        dfs(beginWord, endWord, list, 1);

        return res;
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int steps = 1;
        Deque<String> q = new ArrayDeque<>();
        int len = beginWord.length();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return steps;
                for (int j = 0; j < len; j++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder next = new StringBuilder(cur);
                        next.setCharAt(j, letter);
                        String nextWord = next.toString();
                        if (set.contains(nextWord)) {
                            set.remove(nextWord);
                            q.offer(nextWord);
                        }
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    private void dfs(String beginWord, String endWord, List<String> list, int curSteps) {
        int len = beginWord.length();
        // System.out.println(curSteps);
        // System.out.println(list);
        if (curSteps == steps) {
            if (list.get(list.size() - 1).equals(endWord)) res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            for (char letter = 'a'; letter < 'z'; letter++) {
                StringBuilder next = new StringBuilder(beginWord);
                next.setCharAt(i, letter);
                String nextWord = next.toString();
                if (unvisited.contains(nextWord)) {
                    unvisited.remove(nextWord);
                    list.add(nextWord);
                    dfs(nextWord, endWord, list, curSteps + 1);
                    unvisited.add(nextWord);
                    list.remove(list.size() - 1); //list remove index
                }
            }
        }
    }
}
