/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

 */
package algorithm.src;

public class Min_Depth_Binary_Tree_111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Min_Depth_Binary_Tree_111 solution = new Min_Depth_Binary_Tree_111();
        TreeNode node = new TreeNode(2);
        System.out.println(solution.minDepth(node));
    }
}
