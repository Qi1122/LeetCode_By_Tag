
/*
https://leetcode.com/problems/word-break/

detail explain solution:
https://leetcode.com/problems/word-break/discuss/434582/Java-Solutions-Backtracking-(Memoization)-%2B-DP-with-Detailed-Exp.


dp[i]: 前i个字符是不是能形成一个word break
在 < i的位置，找一个break point 节点j -> 判断dp[j] 是否能分割 -> if (set.contains(s.substring(j + 1, i))
dp[i] is true : 1. dp[j] is true
                2. set.contains(s.substring(j + 1, i) is true
不停找分割点 j
*/
package algorithm.src;
import java.util.*;
public class DP_Word_Break_139 {

    public boolean wordBreakDFS(String s, List<String> wordDict) {
        return dfs(0, s, new HashSet<>(wordDict)); // O(N ^ N)
    }

    public boolean wordBreakDFSMemo(String s, List<String> wordDict) {
        if (s.isEmpty() || wordDict.isEmpty()) return false;
        int len = s.length();
        Boolean[] memo = new Boolean[len]; //memo[i] -> s[i...] is breakable or not
        //Boolean is obj
        return dfsMemo(0, s, new HashSet<>(wordDict), memo);
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                //s1 = substring(0, j) = dp[j]
                //s2 = substring(j, i) = s[j, i - 1]
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    private boolean dfs(int depth, String s, Set<String> wordSet) {
        int len = s.length();
        //accept
        if (depth == len) return true;
        for (int i = depth; i < len; i++) {
            String str = s.substring(depth, i + 1); //substring[depth, i]
            if (wordSet.contains(str)) {
                if (dfs(i + 1, s, wordSet)) return true;
            }
        }
        return false;
    }

    private boolean dfsMemo(int depth, String s, Set<String> wordSet, Boolean[] memo) {
        int len = s.length();
        if (depth == len) return true; // accept
        if (memo[depth] != null) return memo[depth];//memoization, if set boolean, can't = null
        for (int i = depth; i < len; i++) {
            String str = s.substring(depth, i + 1);
            if (wordSet.contains(str)) {
                if (dfsMemo(i + 1, s, wordSet, memo)) {
                    memo[depth] = true;
                    return true;
                }
            }
        }
        memo[depth] = false;
        return false;
    }
}
