/*
https://leetcode.com/problems/binary-tree-paths/
难点：
1. String操作
2. 返回一直搞错
 */
package algorithm.src;
import java.util.*;

public class BT_Paths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        //use preorder traversal to add node to result
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (String str : left) res.add(root.val + "->" + str);
        for (String str: right) res.add(root.val + "->" + str);
        return res;
    }
}
