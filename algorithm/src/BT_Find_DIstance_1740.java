/*
https://leetcode.com/problems/find-distance-in-a-binary-tree/

 */
package algorithm.src;
public class BT_Find_DIstance_1740 {
    public int findDistance(TreeNode root, int p, int q) {
        int res = 0;
        TreeNode lca = LCA(root, p, q);
        return findDistance(lca, p, 0) + findDistance(lca, q, 0);
        //return findDistance(lca, p) + findDistance(lca, q) - 2;
        //each path added one more point, need to - both
    }

    private TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

    private int findDistance(TreeNode root, int target, int curDistance) {
        if (root == null) return 0; //no result, no distance
        if (root.val == target) return curDistance; //result exclude the current node

        int leftDistance  = findDistance(root.left, target, curDistance + 1);
        int rightDistance = findDistance(root.right, target, curDistance + 1);
        return Math.max(leftDistance, rightDistance);
    }

//    private int findDistance(TreeNode root, int target) {
//        if (root == null) return 0;
//        if (root.val == target) return 1;
//        int left = findDistance(root.left, target);
//        int right = findDistance(root.right, target);
//        if (left != 0) return left + 1; //need to add the current point
//        if (right != 0) return right + 1;
//        return 0;
//    }
}
