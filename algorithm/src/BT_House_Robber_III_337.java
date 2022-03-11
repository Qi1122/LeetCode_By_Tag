/*

https://leetcode.com/problems/house-robber-iii/submissions/

              0             1
int[2] = [visit amount, !visit amount]

for curr node max :
-> visit  -> left[1] + right[1]
-> !visit -> Math.max(left[0], left[1])+ Math.max(right[0], right[1])
如果不visit，那么subtree依然有是否visit的选择， 因此要从中选择最大的

 */
package algorithm.src;
public class BT_House_Robber_III_337 {
    public int rob(TreeNode root) {
        int[] curr = dfs(root);
        return Math.max(curr[0], curr[1]);
    }

    private int[] dfs(TreeNode curr) {
        if (curr == null) return new int[2];
        int[] res = new int[2];
        int[] left = dfs(curr.left);
        int[] right = dfs(curr.right);
        //res[0] steal
        // res[1] !steal
        res[0] = left[1] + right[1] + curr.val;
        res[1] = Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        return res;
    }

    private int maxMoney = Integer.MIN_VALUE;

    public int robII(TreeNode root) {
        dfs(root);
        return maxMoney;
    }

    private int[] find(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = find(root.left);
        int[] right = find(root.right);
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        maxMoney = Math.max(maxMoney, Math.max(res[0], res[1]));
        return res;
    }
}
