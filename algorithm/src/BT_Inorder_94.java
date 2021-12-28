/*
https://leetcode.com/problems/binary-tree-inorder-traversal/

inorder: left -> root -> right
1. use findLeft to find the left most node
put them in stack by order, in this way, will pop by left first
2. regular stack iteration, for current node, left node has being processed
need to consider right sub tree now -> findLeft(root.right)
3. need to use WHILE loop in findLeft, in order to find ALL left nodes
findLeft(){
    while (root != null) {
        stack.push(root);
        root = root.left;
    }
}
 */
import java.util.*;
public class BT_Inorder_94 {
    public List<Integer> inorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> inorderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        findLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            findLeft(cur.right, stack);
        }
        return res;
    }
    //find all nodes on root.left and add to stack
    private void findLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
