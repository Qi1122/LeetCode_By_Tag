/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
1. construct graph by recursion
2. Tree doesn't have visited, graph has to mark visited
3. handle the curr element right after it's being poll from queue
 */
package algorithm.src;

import java.util.*;

public class BT_All_Nodes_Distance_K_863 {
    private HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();
        constructGraph(root, null);
        return bfs(target, k);
    }

    private void constructGraph(TreeNode root, TreeNode parent) {
        if (root == null) return;
        map.put(root, new ArrayList<>());
        if (parent != null) map.get(root).add(parent);
        if (root.left != null) map.get(root).add(root.left);
        if (root.right != null) map.get(root).add(root.right);
        constructGraph(root.left, root);
        constructGraph(root.right, root);
    }

    private List<Integer> bfs(TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        int distance = 0;

        q.offer(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (distance == k) res.add(cur.val);
                if (map.get(cur) != null) {
                    for (TreeNode nei : map.get(cur)) {
                        if (!visited.contains(nei)) {
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                }
            }
            distance++;
            if (distance > k) break;
        }
        return res;
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
