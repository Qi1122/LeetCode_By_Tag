/*
https://leetcode.com/problems/contains-duplicate/
 */
import java.util.*;

public class Contains_Duplicate_217 {
    public boolean useHashMap(int[] nums) {
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
    public boolean useSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) set.add(nums[i]);
            else return true;
        }
        return false;
    }
}
