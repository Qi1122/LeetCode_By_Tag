/*
// Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

// If there is no common time slot that satisfies the requirements, return an empty array.

// The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

// It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.


// Example 1:

// Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
// Output: [60,68]
// Example 2:

// Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
// Output: []

 */
package algorithm.src;

import java.util.*;

public class Mock_Find_Overlap_Slots {
//other approch： merge two lists， then sort
    public int[] findSlots(int[][] slot1, int[][] slot2, int duration) {
        Arrays.sort(slot1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slot1, (a, b) -> a[0] - b[0]);
        int index1 = 0;
        int index2 = 0;
        int len1 = slot1.length;
        int len2 = slot2.length;
        while (index1 < len1 && index2 < len2) {
            int maxStart = Math.max(slot1[index1][0], slot2[index2][0]);
            int minEnd = Math.min(slot1[index1][1], slot2[index2][1]);
            if (minEnd >= maxStart) {
                if (minEnd - maxStart >= duration) return new int[]{maxStart, maxStart + duration};
            }
            if (slot1[index1][0] < slot2[index2][0]) index1++;
            else index2++;
        }
        return new int[]{};
    }

    static public void main(String[] args) {
        Mock_Find_Overlap_Slots sol = new Mock_Find_Overlap_Slots();
        int[][] slot1 = {{10,50},{60,120},{140,210}};
        int[][] slot2 = {{150, 180},{0,15},{60,70}};
        int duration = 25;
        int[] res = sol.findSlots(slot1, slot2, duration);
        if (res.length > 1) System.out.println("[" + res[0] + " " + res[1] + "]");
        else System.out.println("[" + "" + "]");
    }
}
