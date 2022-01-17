/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

while loop vs recursion
recursion:
    use the same to recursively look for left/right subtree
    lca is a root a subtree
while loop:
    iterate the tree, move current root
    some current root is lca
 */
package algorithm.src;
public class BT_LCA_235 {
    //self recursion
    public TreeNode recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val > root.val) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    //use recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (q.val > parentVal && p.val > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < parentVal && q.val < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
    //use while loop
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode cur = root;
        while (cur != null) {
            if (pVal > cur.val && qVal > cur.val) cur = cur.right;
            else if (pVal < cur.val && qVal < cur.val) cur = cur.left;
            else return cur;
        }
        return cur;
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
