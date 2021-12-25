/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/

与普通LCA的区别：stack 存
               set 存
 */

import java.util.*;

public class BT_LCA_IV_1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for (TreeNode t : nodes) set.add(t.val);
        return LCA(root, set);
    }

    private TreeNode LCA(TreeNode root, Set<Integer> set) {
        if (root == null || set.contains(root.val)) return root;
        // equivalent to -> root == p || root == q
        TreeNode left = LCA(root.left, set);
        TreeNode right = LCA(root.right, set);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
