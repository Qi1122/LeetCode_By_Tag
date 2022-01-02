/*
https://leetcode.com/problems/count-binary-substrings/
 */
import java.util.*;

public class String_Count_Binary_Substrings_696 {
    public int countBinarySubstrings(String s) {
        List<Integer> arr = new ArrayList<>();
        int result = 0;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                arr.add(count);
                count = 1;
            }
        }
        arr.add(count);
        for (int i = 1; i < arr.size(); i++) {
            result += Math.min(arr.get(i), arr.get(i - 1));
        }
        return result;
    }
}
