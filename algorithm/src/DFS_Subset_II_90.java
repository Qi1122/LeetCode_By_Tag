/*
https://leetcode.com/problems/subsets-ii/submissions/
only add each number once

key point:
ADD:
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
to jump all duplicate numbers.

index < nums.length - 1 -> AVOID INDEX OUT OF BOUND!!!
*/
package algorithm.src;
import java.util.*;

public class DFS_Subset_II_90 {

    List<List<Integer>> res = new ArrayList<>();
    //input as an int array
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length < 1) return res;
        // sort: nlogn, much smaller than 2^n
        //Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.remove(list.size() - 1);
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(nums, index + 1, list);
    }

    //input as a String
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        Arrays.sort(arraySet);
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        helper(set, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length - 1 && set[index] == set[index + 1]) {
            index++;
        }
        helper(set, sb, index + 1, result);
    }
}
