/*
https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/


 */
import java.util.*;

public class BT_LCA_Deepest_Leaves_1123 {

    /*
    basic solution
    易错点：
    1. check if root height is 0 or 1
    tree height from root, if root.height = 1, height = node number from root to a deepest path.
    2. find leaves : need to pass current height as variable
    */
    private int depth = 0;
    public TreeNode lcaDeepestLeavesBasicSolution(TreeNode root) {
        Set<TreeNode> set = new HashSet<>();
        depth = treeDepth(root);
        //System.out.print(depth);
        findLeaves(root, 1, set); // if "0", current tree depth will be 3 instead of 4
        //for (TreeNode node : set)  System.out.println(node.val);
        return LCA(root, set);
    }

    private int treeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return treeDepth(root.right) + 1;
        if (root.right == null) return treeDepth(root.left) + 1;
        return Math.max(treeDepth(root.left),  treeDepth(root.right)) + 1;
    }

    private void findLeaves(TreeNode root, int curDepth, Set<TreeNode> set) {
        if (root == null) return;
        // X: int curDepth = treeDepth(root);
        // System.out.print(curDepth);
        if (curDepth == depth) set.add(root);
        findLeaves(root.left, curDepth + 1, set);
        findLeaves(root.right, curDepth + 1, set);
    }

    private TreeNode LCA(TreeNode root, Set<TreeNode> set) {
        if (root == null || set.contains(root)) return root;
        TreeNode left = LCA(root.left, set);
        TreeNode right = LCA(root.right, set);
        if (left != null && right != null) {
            set.add(root);
            return root;
        }
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }


}
