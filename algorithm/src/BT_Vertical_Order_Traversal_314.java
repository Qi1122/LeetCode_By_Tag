/*
https://leetcode.com/problems/binary-tree-vertical-order-traversal/
物理意义，物理意义，物理意义！！！
1. Use hashmap to keep index: root -> 0
                              root.left -> -1
                              root.right -> +1
2. key -> index, value -> List<node.val>
3. use another hashmap to store relationship of tree node and index
        position.put(root, 0);
4. do BFS
*/
import java.util.*;

public class BT_Vertical_Order_Traversal_314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> position = new HashMap<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.offer(root);
        position.put(root, 0);
        int leftMostIndex = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int index = position.get(cur);
            if (!map.containsKey(index)) map.put(index, new ArrayList<Integer>());
            map.get(index).add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
                position.put(cur.left, index - 1);
            }
            if (cur.right != null) {
                q.offer(cur.right);
                position.put(cur.right, index + 1);
            }
            leftMostIndex = Math.min(leftMostIndex, index);
        }
        while (map.containsKey(leftMostIndex)) res.add(map.get(leftMostIndex++));
        return res;
    }
}
