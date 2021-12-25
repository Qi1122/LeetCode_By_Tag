/*
https://leetcode.com/problems/binary-tree-preorder-traversal/
*/
import java.util.*;

public class BT_Preorder_144 {
    public List<Integer> preorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    public List<Integer> preorderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }
}
