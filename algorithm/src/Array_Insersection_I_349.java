/*
https://leetcode.com/problems/intersection-of-two-arrays/

return list.stream().mapToInt(i->i).toArray();
return res.stream().mapToInt(Integer::intValue).toArray();
 */
package algorithm.src;

import java.util.HashSet;
import java.util.Set;

public class Array_Insersection_I_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);

        Set<Integer> resSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) resSet.add(num);
        }
        int[] res = new int[resSet.size()];
        int index = 0;
        for(int num : resSet) res[index++] = num;
        return res;
        //return list.stream().mapToInt(i->i).toArray();
        //return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
