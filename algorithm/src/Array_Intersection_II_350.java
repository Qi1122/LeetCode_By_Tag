package algorithm.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/intersection-of-two-arrays-ii/

public class Array_Intersection_II_350 {
    //add to hashmap: num, freq
    //iterate nums2: when add to res: freq--
    //use list to store -> conver list to int[]
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
