/*
https://leetcode.com/problems/generate-parentheses/

think of condition: when to add ( : used ( number < 3
                    when to add ) : used ) number < used ( number
terminate condition: number of ( & ) == 3

*/
package algorithm.src;
import java.util.List;
import java.util.ArrayList;

public class DFS_Generate_Parenthesis_22 {
    // 1. leetcode: generateParenthesis
    // 2. laioffer: validParenthesis(int k) -> line 44
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, n, n, n);
        return res;
    }

    //left/right means remaining parentheses
    private void dfs(List<String> res, StringBuilder sb, int n, int left, int right) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            left--;
            dfs(res, sb, n, left, right);
            left++;
            sb.delete(sb.length() - 1, sb.length());
        }
        if (right > 0 && left < right) {
            sb.append(')');
            right--;
            dfs(res, sb, n, left, right);
            right++;
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public List<String> validParenthesis(int k) {
        List<String> res = new ArrayList<>();
        char[] cur = new char[k * 2];
        //
        //left: the number of usable left parenthesis
        //right: the number of usable right parenthesis
        dfs2(cur, k , k, 0, res);
        return res;
    }

    private void dfs2 (char[] cur, int left, int right, int index, List<String> res) {
        //all left and right parenthesis have been used, nothing left -> find ans -> add to res
        if (left == 0 && right == 0) {
            res.add(new String(cur));
            return;
        }
        //still have left parenthesis
        if (left > 0) {
            cur[index] = '(';
            dfs2(cur, left - 1, right, index + 1, res);
        }
        //the usable right parenthesis is more than left parenthesis
        if (right > left) {
            cur[index] = ')';
            dfs2(cur, left, right - 1, index + 1, res);
        }
    }
}
