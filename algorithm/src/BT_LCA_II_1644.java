/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/

 */
public class BT_LCA_II_1644 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean findP = dfs(root, p);
        boolean findQ = dfs(root, q);
        return (findP && findQ) ? LCA(root, p, q) : null;
    }

    private boolean dfs(TreeNode cur, TreeNode target) {
        if (cur == null) return false;
        if (cur == target) return true;
        boolean left = dfs(cur.left, target);
        boolean right = dfs(cur.right, target);
        return (left || right) ? true : false;
    }

    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        //return root(lowest common ancestor) / left(p) / right(q) / null
        TreeNode left = LCA(root.left, p ,q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
