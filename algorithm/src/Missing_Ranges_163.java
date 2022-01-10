/*
https://leetcode.com/problems/missing-ranges/

1. find： start from lower, end with upper
prev = lower - 1
cur -> i
if (prev + 1 <= cur - 1) -> valid -> add[prev + 1, cur - 1]

prev + 1 < cur - 1 -> nums[i] - nums[i-1] > 0 -> missing interval
prev + 1 = cur - 1 -> nums[i] - nums[i-1] = 0 -> missing one number
prev = cur

nums[i] - nums[i-1] == 1 no missing
nums[i] - nums[i-1] > 1-> [nums[i+1], nums[i-1]] is missing range

case1:not start with lower
[lower, num[0] - 1]
case2: not end with upper
int curr = (i < nums.length) ? nums[i] : upper + 1;
[nums[n-1] + 1, upper]

2. format

1. find missing ranges
2. formats each range in the requested format

DO NOT:
1. create list<int[]> to store result, too much for type
int[]{start, end}
2. need to use
String.valueOf(ranges.get(i)[0] to get int[0]
easy to make mistakes
 */
import java.util.*;

public class Missing_Ranges_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        //prev is not index, is starting number
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int cur =  (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= cur - 1) res.add(format(prev + 1, cur - 1));
            prev = cur;
        }
        return res;
    }

    private String format(int lower, int upper) {
        if (lower == upper) return String.valueOf(lower);
        return lower + "->" + upper;
    }
}
