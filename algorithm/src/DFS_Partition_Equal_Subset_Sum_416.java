package algorithm.src;
import java.util.*;
//Time Limit Exceeded on LC
public class DFS_Partition_Equal_Subset_Sum_416 {
    private int min = Integer.MAX_VALUE;
    private List<Integer> subsetSumList = new ArrayList<>();

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return false;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, sum, subset);
        for (int subSum : subsetSumList) {
            if (sum - subSum == subSum) return true;
        }
        return false;
    }

    private void dfs(int[] nums, int index, int sum, List<Integer> subset) {
        if (index == nums.length - 1) {
            int temp = 0;
            for (int sub : subset) temp += sub;
            subsetSumList.add(temp);
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index + 1, sum, subset);
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, sum, subset);
    }
}
