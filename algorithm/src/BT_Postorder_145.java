/*
https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

import java.util.*;

public class BT_Postorder_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}
