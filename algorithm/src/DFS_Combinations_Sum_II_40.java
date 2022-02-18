package algorithm.src;
import java.util.*;

public class DFS_Combinations_Sum_II_40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        Set<List<Integer>> visited = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur, visited);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> cur, Set<List<Integer>> visited) {
        if (target == 0) {
            if(!visited.contains(cur)) {
                res.add(new ArrayList(cur));
                visited.add(cur);
            }
            return;
        }
        if (index == candidates.length) return;
        cur.add(candidates[index]);
        dfs(candidates, target - candidates[index], index + 1,  cur, visited);
        cur.remove(cur.size() - 1);
        dfs(candidates, target, index + 1, cur, visited);
    }
}
