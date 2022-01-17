/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

物理意义：
1. if root = p/q return root
2. keep searching: TreeNode left/right = lca left/right
3. condition: left && right != null -> root
              left != null -> left
              right != null -> right

 */

package algorithm.src;
public class BT_LCA_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root; //npe if not check if (root == null) in the beginning
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        //right == null, can't find in right, only in left
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
