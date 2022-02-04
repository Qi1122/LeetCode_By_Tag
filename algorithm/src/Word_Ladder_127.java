package algorithm.src;/*
https://leetcode.com/problems/word-ladder/
 */
import java.util.*;

public class Word_Ladder_127 {
    List<String> res = new ArrayList<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int steps = 1; // why we need steps? -> final result
        return bfs(beginWord, endWord, wordList, steps);
    }

    private int bfs(String beginWord, String endWord, List<String> wordList, int steps) {
        Set<String> set = new HashSet<>(wordList); //add wordList words into set -> faster check than List
        Deque<String> q = new ArrayDeque<>();
        int len = beginWord.length();
        q.offer(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                //res.add(cur);
                if (cur.equals(endWord)) return steps;
                for (int j = 0 ; j < len; j++) { //loop wordList to find next fit word
                    //use （26字母穷举法）exhaustive method to loop 26 letters a to z -> store in sb -> check if
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder next = new StringBuilder(cur); //set newWord to current word
                        next.setCharAt(j, letter); //set index j to letter
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
        //System.out.println(Arrays.toString(res.toArray()));
        return 0;
    }
}
