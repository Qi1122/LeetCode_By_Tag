/*

 */
package algorithm.src;
import java.util.*;

public class DFS_Subset_Size_K_duplicate {
    List<String> res = new ArrayList<>();
    public List<String> subsetK(String s, int k) {
        if (s == null || s.length() < 1) return res;
        StringBuilder sb = new StringBuilder();
        dfs(s, k, 0, sb);
        return res;
    }

    private void dfs(String s, int k, int index, StringBuilder sb) {
        //check sb.length() == k, not index
        if (sb.length() == k) { res.add(sb.toString()); return; }
        if (index == s.length()) return;
        dfs(s, k, index + 1, sb.append(s.charAt(index)));
        sb.deleteCharAt(sb.length() - 1);
        while (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) index++;
        dfs(s, k, index + 1, sb);
    }

    public static void main(String[] args) {
        DFS_Subset_Size_K_duplicate sol = new DFS_Subset_Size_K_duplicate();
        String str = new String("abbbc");
        int k = 2;
        //sol.subsetK(str, k);
        //Stream.of(sol.subsetK(str, k)).forEach(System.out::println);
        List<String> result = sol.subsetK(str, k);
        for(String item : result) System.out.println(item);
    }
}
