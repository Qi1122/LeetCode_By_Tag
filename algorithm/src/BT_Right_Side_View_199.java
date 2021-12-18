/*
https://leetcode.com/problems/binary-tree-right-side-view/
 */
import java.util.*;

public class BT_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                if (i == size - 1) res.add(cur.val);
            }
        }
        return res;
    }
}
