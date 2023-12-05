/*
https://leetcode.com/problems/word-ladder-ii/

1. find steps as word ladder I
2. use DFS to find all solution -> if list.get(3) = endWord -> put to final result
*/

package algorithm.src;
import java.util.*;

public class Word_Ladder_II_126 {
    /**
     * Solution 1:
     */
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    List<String>   list = new ArrayList<>();
    Set<Character> chars = new HashSet<>();
    Set<String>    levelVisited = new HashSet<>();
    Set<String>    globalVisited = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return res;
        getAllChars(wordList);
        bfs(beginWord, endWord, wordList);
        System.out.println(map);
        list.add(endWord);
        dfs(endWord, beginWord, wordList);
        return res;
    }

    private void getAllChars(List<String> wordList) {
        for (String word : wordList) {
            for (char c : word.toCharArray()) chars.add(c);
        }
    }

    private void bfs(String beginWord, String endWord, List<String> wordList) {
        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        globalVisited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curword = q.poll();
                for (int j = 0; j < beginWord.length(); j++) {
                    char[] arr = curword.toCharArray();
                    for (char c : chars) {
                        if (arr[j] == c) continue;
                        arr[j] = c;
                        String newword = new String(arr);
                        if (wordList.contains(newword) && !globalVisited.contains(newword)) {
                            map.computeIfAbsent(newword, key -> new ArrayList()).add(curword);
                            if (!levelVisited.contains(newword)) q.offer(newword);
                            levelVisited.add(newword);
                        }
                    }
                }
            }
            for (String word : levelVisited) globalVisited.add(word);
            if (globalVisited.contains(endWord)) break;
        }
    }

    private void dfs(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            List<String> temp = new ArrayList<>(list);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        if (map.containsKey(beginWord)) {
            for (String word : map.get(beginWord)) {
                list.add(word);
                dfs(word, endWord, wordList);
                list.remove(list.size() - 1);
            }
        }
    }
    /**
     * Solution 2:
     */

    List<List<String>> result = new ArrayList<>();
    Set<String> unvisited;
    int steps = 0;

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        steps = bfs2(beginWord, endWord, wordList);
        System.out.println(steps);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        unvisited = new HashSet<>(wordList);
        unvisited.remove(beginWord);
        dfs2(beginWord, endWord, list, 1);

        return result;
    }

    private int bfs2(String beginWord, String endWord, List<String> wordList) {
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

    private void dfs2(String beginWord, String endWord, List<String> list, int curSteps) {
        int len = beginWord.length();
        // System.out.println(curSteps);
        // System.out.println(list);
        if (curSteps == steps) {
            if (list.get(list.size() - 1).equals(endWord)) result.add(new ArrayList<String>(list));
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
                    dfs2(nextWord, endWord, list, curSteps + 1);
                    unvisited.add(nextWord);
                    list.remove(list.size() - 1); //list remove index
                }
            }
        }
    }
}
