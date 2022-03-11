/*
https://leetcode.com/problems/invert-binary-tree/submissions/

 */
package algorithm.src;
public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
