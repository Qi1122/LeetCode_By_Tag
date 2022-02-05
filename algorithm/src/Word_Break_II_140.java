/*
https://leetcode.com/problems/word-break-ii/
 */
package algorithm.src;
import java.util.*;

public class Word_Break_II_140 {
    HashMap<Integer, List<String>> dp = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxLen = -1;
        for (String str : wordDict) maxLen = Math.max(maxLen, str.length());
        return addSpaces(s, wordDict, 0, maxLen);
    }

    private List<String> addSpaces (String s, List<String> wordDict, int start, int max) {
        List<String> words = new ArrayList<>();
        if (start == s.length()) {
            words.add("");
            return words;
        }
        for (int i = start + 1; i <= max + start && i <= s.length(); i++) {
            String temp = s.substring(start, i);
            if (wordDict.contains(temp)) {
                List<String> list;
                if (dp.containsKey(i)) list = dp.get(i);
                else list = addSpaces(s, wordDict, i, max);
                for (String str : list) words.add(temp + (str.equals("") ? "" : " ") + str);
            }
        }
        dp.put(start, words);
        return words;
    }
}
