import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Grouping_Digits {
        /*
         * Complete the 'minMoves' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static int minMoves(List<Integer> arr) {
            // Write your code here
            int minMovesForZero = 0;
            int minMovesForOne = 0;
            int targetZeroIndex = 0;
            int targetOneIndex = 0;
            //Min moves we need if we want to move all '0's before all '1's.
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == 0) {
                    minMovesForZero += i - targetZeroIndex++;
                }
            }
            //Min moves we need if we want to move all '1's before all '0's.
            for (int i = 0; i <arr.size(); i++) {
                if (arr.get(i) == 1) {
                    minMovesForOne += i - targetOneIndex++;
                }
            }
            return Math.min(minMovesForOne, minMovesForZero);
        }

    public class Solution {
}
