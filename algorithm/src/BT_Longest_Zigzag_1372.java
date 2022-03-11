package algorithm.src;

/*
https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class BT_Longest_Zigzag_1372 {
    private int maxZ = Integer.MIN_VALUE;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxZ - 1;
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        //left: longest zigzag can get from left
        //right: longest zigzag can get from right
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        //need to add current node
        res[0] = left[1] + 1;
        res[1] = right[0] + 1;
        maxZ = Math.max(maxZ, Math.max(res[0], res[1]));
        return res;
    }
}
