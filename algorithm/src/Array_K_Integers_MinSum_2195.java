/*
https://leetcode.com/problems/append-k-integers-with-minimal-sum/

SORT ARRAY FIRST!!!!!!

1. set to avoid add duplicate number
2. iterate input array -> find inputSum
3. result = Sum(1, k) - inputSum
*/
package algorithm.src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array_K_Integers_MinSum_2195 {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;

        for (int num : nums) {
            if (!set.contains(num) && num <= k) { k++; sum += num; }
            set.add(num);
        }

        long res = (long)(1 + k) * k / 2 - sum;
        return res;
    }
}
