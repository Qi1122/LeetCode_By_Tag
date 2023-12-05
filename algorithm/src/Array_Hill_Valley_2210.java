/*
https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 */
package algorithm.src;

public class Array_Hill_Valley_2210 {
    public int countHillValley(int[] nums) {
        int prev = nums[0], ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            //                hill                                  valley
            if ((prev < nums[i] && nums[i] > nums[i + 1])||(prev > nums[i] && nums[i] < nums[i + 1])) {
                ans++;
            }
            //if has two same value, prev not move
            if (nums[i] != nums[i + 1]) prev = nums[i];
        }
        return ans;
    }
}
