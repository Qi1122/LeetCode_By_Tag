/*
https://docs.google.com/spreadsheets/d/1fT7m-pIIcHif6mvuqvfbJj6texAeh3xhCaOOBi6KvBQ/edit#gid=1281752252

use set to store visited nodes
 */

import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

public class BT_LCA_III_1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (set.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }
}
