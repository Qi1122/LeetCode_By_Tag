/*
https://leetcode.com/problems/consecutive-numbers-sum/

9 = (1 + 2 + 3) + (1 * 3)
n = (1 + 2 + ... + i) + ? * i
n = (1 + i) * i / 2 + ? * i

list "i", if we can find i -> count++
explain:
from observation we can see
5 = 2 + 3 = (1 + 2) + 1 + 1 = (1 + 2) + 2 * 1
9 = 4 + 5 = (1 + 2) + 3 + 3 = (1 + 2) + 2 * 3
  = 2 + 3 + 4 = (1 + 2 + 3) + 1 + 1 + 1 = (1 + 2 + 3) + 3 * 1
n = (1 + 2 + .. + i) + i * ? (? is an integer)
n = (1 + i) * i / 2 + ? * i
? = (n - (1 + i) * i / 2) / i
=> therefore, we can get conclusion that if we can find i,
it means there exist a number k, and i, we find one way of
write n as sum of consecutive positive integers
=> the question right now becomes how to find i?
=> we can use exhaustive -> brute force way to do it
=> we start n from "1" not "0"

*/
package algorithm.src;

public class Consecutive_Num_Sum_829 {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 1; (1 + i) * i / 2 <= n; i++) {
            if ((n - (1 + i) * i / 2) % i == 0) count++;
        }
        return count;
    }
}
