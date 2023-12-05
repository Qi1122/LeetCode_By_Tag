/*
Print all subsets of a Set which size = k
eg: S = {a, b, c, d} k = 2
output: {a,b} {a, c}, {a,d}, {b, c}, {b, d}, {c, d}
 */
package algorithm.src;
import java.util.*;

public class DFS_Subset_Size_K {
    public void subsetK(String s, int k) {
        if (s == null || s.length() < 1) return;
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, k, sb);
    }
    //need to deduplicate
    private void dfs(String s, int index, int k, StringBuilder sb) {
        if (sb.length() == k) {
            System.out.println(sb);
        }
        if (index == s.length()) return;
        sb.append(s.charAt(index));
        dfs(s, index + 1, k, sb);
        sb.deleteCharAt(sb.length() - 1);
        dfs(s, index + 1, k, sb);
    }

    public static void main(String[] args) {
        DFS_Subset_Size_K sol = new DFS_Subset_Size_K();
        String s = "abcd";
        int k = 2;
        sol.subsetK(s, k);
    }
}
