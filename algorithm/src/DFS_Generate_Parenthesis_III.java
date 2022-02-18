/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {},
subject to the priority restriction: {} higher than <> higher than ().

Assumptions
    l, m, n >= 0
    l + m + n >= 0
Examples
    l = 1, m = 1, n = 0, all the valid permutations are
    ["()<>", "<()>", "<>()"].

    l = 2, m = 0, n = 1, all the valid permutations are
    [“()(){}”, “(){()}”, “(){}()”, “{()()}”, “{()}()”, “{}()()”].
 */
package algorithm.src;

import java.util.ArrayList;
import java.util.List;

public class DFS_Generate_Parenthesis_III {
    List<String> res = new ArrayList<>();

    public List<String> validParenthesesIII(int l, int m, int n) {
        return res;
    }

    private void dfs() {

    }
}