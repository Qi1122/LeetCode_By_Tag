package algorithm.src;

/*
https://leetcode.com/problems/maximum-average-subtree/
recursion think:
1. operation for current node
   return type from helper function
2. what do i want from next level
3. what do i want to return to upper level

 1. return global varibale, highlight : return type: primitive, cannot change it
 2. maxSubtree for curr:
current sum:   res[0] : current sum from left + right
current nodes: res[1] : current nodes from left + right
    avg = maxSub / nodes

    wrong: leftmax + curr / rightmax + curr
    CLEAR the definition of each variable

 3. helper function: return to parent maxSub, nodes -> use int[2] to store
    update max
 */
public class BT_Max_Avg_1120 {

    private double maxAvg = Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return maxAvg;
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = root.val + left[0] + right[0];
        int nodeNum = 1 + left[1] + right[1];
        maxAvg = Math.max(maxAvg, (double)sum / nodeNum);
        res[0] = sum;
        res[1] = nodeNum;
        return res;
    }
}
