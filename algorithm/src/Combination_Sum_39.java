/*
https://leetcode.com/problems/combination-sum/
 */
package algorithm.src;
import java.util.*;

public class Combination_Sum_39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            if (!set.contains(cur)) res.add(new ArrayList<>(cur));
            set.add(cur);
        }
        for (int i = index; i < candidates.length; i++) {
            if(target < candidates[i]) continue;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
