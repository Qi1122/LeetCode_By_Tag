/*
https://leetcode.com/problems/flip-string-to-monotone-increasing/

dp[i]: the number of “1” from 0 to i
if s[i] = '0' -> dp[i] = dp[i - 1]
if s[i] = '1' -> dp[i] = dp[i - 1] + 1
-> find dividing point

  |
001 | 10  -> 000 | 11

1. dp: an array for each index, how many "1" from index 0 to current index i
2. find cutting point, traverse string
3.
count 1 -> 0 次数
count 0 -> 1 次数
相加 = flip的总次数
for current index:
total "1" after:  总共“1”     当前有多少“1”
    numOfOne = dp[size - 1] - dp[i] key point
total "0" after:
        总长度   当前长度  后面有多少个“1”
    （size - 1） - i - numOfOne
total "1" before:
    dp[i]
total "0" before:
    i - dp[i]

"1"s : dp[size - 1]
curFlip: for current index，把这个点前面的所有 1 -> 0， 之后的所有0 -> 1的所有flip
           "1"before   total "0" after        total "1" after
int curFlip = dp[i] + (size - 1 - i) - (dp[size - 1] - dp[i]);
*/

public class Flip_String_Increase_Monotone_926 {
    public int minFlipsMonoIncr(String s) {
        int size = s.length();
        int[] dp = new int[size];
        for (int i = 0; i < size; i ++) {
            if (s.charAt(i) == '0') {
                dp[i] = (i == 0) ? 0 : dp[i - 1];
            } else {
                dp[i] = (i == 0) ? 1 : dp[i - 1] + 1;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int curFlip = dp[i] + (size - 1 - i) - (dp[size - 1] - dp[i]);
            if (res > curFlip) res = curFlip;
        }
        if (size - dp[size - 1] < res) res = size - dp[size - 1];
        return res;
    }
}
