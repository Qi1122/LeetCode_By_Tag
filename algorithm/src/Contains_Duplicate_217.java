/*
https://leetcode.com/problems/contains-duplicate/
 */
import java.util.*;

public class Contains_Duplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
