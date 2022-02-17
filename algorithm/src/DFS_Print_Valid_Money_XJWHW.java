/*
A money print machine, it takes (int)d, and can print out d^2 % 400, or (d^2 + 1) % 400
eg: given $5，it will print $25,$26, if given $257, it will print $49, $50.
question: if we are able to print money k?
 */
package algorithm.src;
import java.util.*;

public class DFS_Print_Valid_Money_XJWHW {
    public boolean canPrint(int dollar, int target) {
        Set<Integer> visited = new HashSet<>();
        return dfs(dollar, target, visited);
    }

    private boolean dfs(int dollar, int target, Set<Integer> visited){
        if (dollar == target) return true;
        if (visited.contains(dollar)) return false;
        visited.add(dollar);
        return (dfs(dollar * dollar % 400, target, visited)
                || dfs((dollar * dollar + 1) % 400, target, visited));
    }

    public static void main(String[] args) {
        DFS_Print_Valid_Money_XJWHW sol = new DFS_Print_Valid_Money_XJWHW();
        int dollar = 1;
        int target = 20;
        System.out.println(sol.canPrint(dollar, target));
    }
}
