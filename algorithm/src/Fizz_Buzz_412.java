/*
https://leetcode.com/problems/fizz-buzz/
 */
import java.util.*;

public class Fizz_Buzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
