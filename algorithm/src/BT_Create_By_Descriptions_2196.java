/*
https://leetcode.com/problems/create-binary-tree-from-descriptions/
nodeMap: all nodes
<node value, TreeNode>
relationshipMap: only child node
<childNode, parentNode>

Algorithm:
1. from each description[parent, child, leftOrRight]
   get child -> in nodeMap ? return : create new one & put in nodeMap
   get parent -> in nodeMap ? return : create new one & put in nodeMap
   setRelationship
 2. loop nodeMap, check each node if in relationshipMap
the node in the nodeMap but not in relationshipMap is the root node
 */
package algorithm.src;

import java.util.HashMap;
import java.util.Map;

public class BT_Create_By_Descriptions_2196 {
    private Map<Integer, TreeNode> nodeMap = new HashMap<>();
    private Map<TreeNode, TreeNode> relationshipMap = new HashMap<>();

    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions == null || descriptions.length < 1) return null;
        for (int i = 0; i < descriptions.length; i++) {
            TreeNode child = getOrCreateNode(descriptions[i][1]);
            TreeNode parent = getOrCreateNode(descriptions[i][0]);
            setRelationship(child, parent, descriptions[i][2]);
            relationshipMap.put(child, parent);
        }
        return findRoot();
    }

    private TreeNode getOrCreateNode(int val) {
        if (!nodeMap.containsKey(val)) {
            nodeMap.put(val, new TreeNode(val));
        }
        return nodeMap.get(val);
    }

    private void setRelationship(TreeNode child, TreeNode parent, int side) {
        if (side == 1) parent.left = child;
        if (side == 0) parent.right = child;
    }

    private TreeNode findRoot() {
        for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
            TreeNode node = entry.getValue();
            if (!relationshipMap.containsKey(node)) return node;
        }
        return null;
    }
}
