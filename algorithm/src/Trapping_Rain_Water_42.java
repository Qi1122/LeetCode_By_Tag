package algorithm.src;/*
https://leetcode.com/problems/trapping-rain-water/
1. two pointers -> find highest point
   trap water = current max height - current height
2. from left to hightest point
3. from right to highest point
*/

public class Trapping_Rain_Water_42 {
    public int trap(int[] height) {
        int res = 0;
        int maxIndex = 0;
        int maxHeight = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            if(height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        int curMaxFromLeft = 0;
        for (int i = 0; i < maxIndex; i++) {
            curMaxFromLeft = Math.max(curMaxFromLeft, height[i]);
            res += curMaxFromLeft - height[i];
        }
        int curMaxFromRight = 0;
        for (int i = len - 1; i >= maxIndex; i--) {
            curMaxFromRight = Math.max(curMaxFromRight, height[i]);
            res += curMaxFromRight - height[i];
        }
        return res;
    }
}
