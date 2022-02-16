/*
Given an array of integers:
1) divide it in two parts
2) the sum of each part must be equal, or sum(part1) - sum(part2) is minimum
 */
package algorithm.src;
import java.sql.SQLOutput;
import java.util.*;

public class DFS_Min_Diff_Subsets {
    private List<List<Integer>> res = new ArrayList<>(2);
    private int min = Integer.MAX_VALUE;
    private Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> findSubsets(List<Integer> list) {
        if (list == null || list.size() < 1) return res;
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        res.add(one);
        res.add(two);
        dfs(list, 0, one, two);
        return res;
    }

    private void dfs(List<Integer> list, int index, List<Integer> one, List<Integer> two) {
        //base case: Sum(one) - Sum(two) < min ? update min : no change min
        if (index == list.size()) {
            //if (sortAndAdd(one) && sortAndAdd(two))
            int diff = findSum(one) - findSum(two);
            if (diff >= 0 && diff < min){
                res.set(0, new ArrayList<>(one));
                res.set(1, new ArrayList<>(two));
                min = diff;
            }
            return;
        }
        one.add(list.get(index));
        dfs(list, index + 1, one, two);
        one.remove(list.get(index));
        two.add(list.get(index));
        dfs(list, index + 1, one, two);
        two.remove(list.get(index));
    }

    private int findSum(List<Integer> list) {
        int sum = 0;
        for (int num : list) sum += num;
        return sum;
    }

//    private boolean sortAndAdd(List<Integer> list) {
//        Collections.sort(list);
//        if (set.contains(list)) return false;
//        else { set.add(list); return true; }
//    }

    public static void main(String[] args) {
        DFS_Min_Diff_Subsets sol = new DFS_Min_Diff_Subsets();
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
        List<List<Integer>> result = sol.findSubsets(list);
        List<Integer> one = result.get(0);
        List<Integer> two = result.get(1);
        for (int num : one) System.out.print(num + " ");
        System.out.println("");
        for (int num : two) System.out.print(num + " ");
        System.out.println("");
        System.out.println(sol.min);
    }
}
