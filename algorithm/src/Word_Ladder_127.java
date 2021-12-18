/*
https://leetcode.com/problems/word-ladder/
 */
import java.util.*;

public class Word_Ladder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int steps = 1;
        return bfs(beginWord, endWord, wordList, steps);
    }

    private int bfs(String beginWord, String endWord, List<String> wordList, int steps) {
        Set<String> set = new HashSet<>(wordList);
        Deque<String> q = new ArrayDeque<>();
        int len = beginWord.length();
        q.offer(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i< size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return steps;
                for (int j = 0; j < len; j++) { //loop单词的每一位替换
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder next = new StringBuilder(cur);
                        next.setCharAt(j, letter);
                        String nextWord = next.toString();
                        if (set.contains(nextWord)) {
                            set.remove(nextWord); //remove from set to represent the word is visited
                            q.offer(nextWord);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
