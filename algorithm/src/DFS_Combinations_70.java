package algorithm.src;
import java.util.*;

public class DFS_Combinations_70 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        dfs(arr, k, 0, cur);
        return res;
    }

    private void dfs(int[] arr, int k, int index, List<Integer> cur) {
        if (cur.size() == k) { res.add(new ArrayList(cur)); return; }
        if (index == arr.length) return;
        cur.add(arr[index]);
        dfs(arr, k, index + 1, cur);
        cur.remove(cur.size() - 1);
        dfs(arr, k, index + 1, cur);
    }
}
