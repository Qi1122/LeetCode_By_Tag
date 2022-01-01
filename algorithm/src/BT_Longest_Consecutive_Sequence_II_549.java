/*
https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
int[] {max ascending from left and right,
       max descending from left and right};

 */
public class BT_Longest_Consecutive_Sequence_II_549 {
    private int count = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return count;
    }

    private int[] longestPath(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int ascending = 1;
        int descending = 1;
        //[ascending, descending]
        if (root.left != null) {
            int[] left = longestPath(root.left);
            if (root.val == root.left.val - 1) ascending = left[0] + 1;
            if (root.val == root.left.val + 1) descending = left[1] + 1;
        }
        if (root.right != null) {
            int[] right = longestPath(root.right);
            if (root.val == root.right.val - 1) ascending = Math.max(ascending, right[0] + 1);
            if (root.val == root.right.val + 1) descending = Math.max(descending, right[1] + 1);
        }
        count = Math.max(count, ascending + descending - 1);
        return new int[]{ascending, descending};
    }
}

/*
wrong solution:

    public int longestConsecutive(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        if (root == null) return list.size();
        List<TreeNode> left = new ArrayList<>();
        left.add(root);
        findLongest(root, root.left, list, left);
        List<TreeNode> right = new ArrayList<>();
        right.add(root);
        findLongest(root, root.right, list, right);
        int longestConsecutiveLength = 0;
        for (int i = 0; i < list.size(); i++) {
            int curSize = list.get(i).size();
            if (longestConsecutiveLength <= curSize) longestConsecutiveLength = curSize;
            // System.out.println(curSize);
            // System.out.println(longestConsecutiveLength);
            // System.out.println(list.size());
        }
        return longestConsecutiveLength;
    }

    private void findLongest(TreeNode parent, TreeNode curr,
                            List<List<TreeNode>> list, List<TreeNode> curList) {
        if (curr == null) return;
        if (Math.abs(parent.val - curr.val) == 1) {
            curList.add(curr);
            findLongest(curr, curr.left, list, curList);
            findLongest(curr, curr.right, list, curList);
        }
        if (Math.abs(parent.val - curr.val) != 1) {
            list.add(curList);
            List<TreeNode> left = new ArrayList<>();
            left.add(curr);
            findLongest(curr, curr.left, list, left);
            List<TreeNode> right = new ArrayList<>();
            right.add(curr);
            findLongest(curr, curr.right, list, right);
        }
    }
 */
