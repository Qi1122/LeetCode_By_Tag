/*
https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/

type convert

ASCII convert

char -> int
Integer.parseInt(String.valueOf(char))
Character.getNumericValue(char);

int -> char
Integer.toString(char).charAt(0);
(char)(int + '0')
*/
package algorithm.src;

import java.util.ArrayList;
import java.util.List;

public class String_Cells_Range_In_Excel_2194 {
    public List<String> cellsInRange(String s) {
        if (s == null) return null;
        char startLetter = s.charAt(0);
        int startInt = Integer.parseInt(String.valueOf(s.charAt(1)));
        char endLetter = s.charAt(3);
        int endInt = Integer.parseInt(String.valueOf(s.charAt(4)));
        List<String> res = new ArrayList<>();
        //int start = Character.getNumericValue(char);
        for (char c = startLetter; c <= endLetter; c++) {
            for (int i = startInt; i <= endInt; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                //char intchar = Integer.toString(cur).charAt(0);
                sb.append((char)(i+'0'));
                res.add(sb.toString());
            }
        }
        return res;
    }
}
