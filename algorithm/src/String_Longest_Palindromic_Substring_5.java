/*
https://leetcode.com/problems/longest-palindromic-substring/
Wrong idea: Using Deque<>(), too many type change,
Time complexity: n^3

direction：modify index，store index，
return .substring(start index, end index);

1. use start/end to keep the global longest palindrom substring, return s.substring(start, end)
2. use int[] {start index, length} to store local odd/even palindrom
3. update start/end with local max palindrom substring

Note:
for expandAroundCenter()
-> need to find left != right to stop,
    therefore, pointers stop at left - 1 / right + 1
    start = left + 1
    length = right - left - 1
-> use WHILE loop!

 */

import java.util.*;

public class String_Longest_Palindromic_Substring_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] odd = expandAroundCenter(s, i, i);
            int[] even = expandAroundCenter(s, i, i + 1);
            int len = Math.max(odd[1], even[1]);
            if (len > end - start) {
                if (len == odd[1]) {
                    start = odd[0];
                    end = odd[0] + odd[1] - 1;
                } else {
                    start = even[0];
                    end = even[0] + even[1] - 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private int[] expandAroundCenter(String s, int leftStart, int rightStart) {
        int left = leftStart;
        int right = rightStart;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - left - 1};
    }
}
