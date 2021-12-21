/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

注意：
1. 把node加入queue的时候，顺序和普通bfs一样，只是print的时候，根据层数不同反向打印
2. 如果根据层数来改变入queue顺序、改变加入node的方式，会改变tree的结构，因而出错

 */

import java.util.*;

public class BT_zigzag_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        int levelNumber = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            bfs(size, levelNumber, q, res);
            levelNumber++;
        }
        return res;
    }

    private void bfs(int size, int levelNumber, Deque<TreeNode> q, List<List<Integer>> res) {
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode cur = q.poll();
            level.add(cur.val);
            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }
        if (levelNumber % 2 == 0) res.add(level);
        else res.add(reverseLevel(level));
    }

    private List<Integer> reverseLevel(List<Integer> level) {
        int size = level.size();
        for (int i = 0; i < size / 2; i++) {
            Integer temp = level.get(i);
            level.set(i, level.get(size- 1 - i));
            level.set(size - 1 - i, temp);
        }
        return level;
    }

    public List<List<Integer>> zigzagLevelOrder_combine(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        int levelNumber = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            if (levelNumber % 2 == 0) res.add(level);
            else res.add(reverseLevel(level));
            levelNumber++;
        }
        return res;
    }

    private List<Integer> reverseLevel(List<Integer> level) {
        int size = level.size();
        for (int i = 0; i < size / 2; i++) {
            Integer temp = level.get(i);
            level.set(i, level.get(size- 1 - i));
            level.set(size - 1 - i, temp);
        }
        return level;
    }
}
