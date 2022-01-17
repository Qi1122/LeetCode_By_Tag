/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

search -> how many levels?
       -> what we want from each level?
       -> what recursion tree looks like?
       先考虑normal recursion rule，最后考虑终止条件
       state once being setted, not change
       index == level 物理意义一致，处理到哪一层

*/
package algorithm.src;
import java.util.*;

public class DFS_Phone_Letter_Combinations_17 {
    private HashMap<Character, String> map = new HashMap<>();
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if (digits == null || digits.length() < 1) return res;
        List<String> curRes = new ArrayList<>();
        dfs(digits, 0, curRes);
        return res;
    }
    //index means -> index in digits
    private void dfs (String digits, int index, List<String> curRes) {
        if (index == digits.length()) {
            res.add(String.join("", curRes));
            return;
        }
        String cur = map.get(digits.charAt(index));
        for (int i = 0; i < cur.length(); i++) { //index 表示多少层，用for loop表示当前层有多少分枝
            //current level： add element into currenct level result
            curRes.add(Character.toString(cur.charAt(i)));
            dfs(digits, index + 1, curRes);
            //维持当前层结果不变
            curRes.remove(curRes.size() - 1);// remove(index) -> last digit
        }
    }
}
