/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/

 */
public class BT_Count_Good_Nodes_1448 {
    private int count = 0;
    public int goodNodes(TreeNode root) {
        ifGood(root, root.val);
        return count;
    }

    private void ifGood(TreeNode root, int curMax) {
        if (root == null) return;
        if (root.val >= curMax) {
            count++;
            curMax = root.val;
        }
        ifGood(root.left, curMax);
        ifGood(root.right, curMax);
    }
}
