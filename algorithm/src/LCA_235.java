/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LCA_235 {
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
}
