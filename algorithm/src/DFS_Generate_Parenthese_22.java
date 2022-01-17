/*
https://leetcode.com/problems/generate-parentheses/

think of condition: when to add ( : used ( number < 3
                    when to add ) : used ) number < used ( number
terminate condition: number of ( & ) == 3
*/
package algorithm.src;
import java.util.List;
import java.util.ArrayList;

public class DFS_Generate_Parenthese_22 {
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
}
