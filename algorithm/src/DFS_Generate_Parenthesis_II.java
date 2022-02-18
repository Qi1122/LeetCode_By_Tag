/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples
l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]

3 {} 2[] 1() -> 12 levels, 6 branches
Levels: how many will be added in total？
Branches： in each level，how many choices do i have？

12 levels: all left and right parenthesis added together are 12 levels
6 branches：add left parenthesis or right parenthesis?

Use stack:
1. put left ( in stack
2. when adding ) -> check top() -> if match -> can add )
 */

package algorithm.src;
import java.util.*;

public class DFS_Generate_Parenthesis_II {
    List<String> res = new ArrayList<>();

    public List<String> validParentheses(int l, int m, int n) {
        Deque<Character> stack = new ArrayDeque<>();
        dfs(l, m, n, stack);
        return res;
    }

    private void dfs(int l, int m, int n, Deque<Character> stack) {

    }
}
