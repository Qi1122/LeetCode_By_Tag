/*
https://leetcode.com/problems/maximum-subarray/
 */

public class Max_Subarray_53 {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int maxSub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            curr = Math.max(num, curr + num);
            maxSub = Math.max(maxSub, curr);
        }
        return maxSub;
    }
}
