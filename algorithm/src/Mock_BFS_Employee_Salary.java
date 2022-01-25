//package algorithm.src;
//import com.sun.source.tree.Tree;
//
//import java.util.*;
//
//public class Mock_BFS_Employee_Salary {
//    public static class TreeNode {
//        private double salary;
//        private List<TreeNode> children;
//        public TreeNode(double salary) {
//            this.salary = salary;
//            this.children = new ArrayDeque<>();
//        }
//    }
//
//    private List<Double> res= new ArrayList<>();
//    public List<Double> avgSalary(TreeNode root) {
//        if (root == null) return res;
//        bfs(root);
//        return res;
//    }
//
//    private void bfs(TreeNode node) {
//        Deque<TreeNode> q = new ArrayDeque<>();
//        q.offer(node);
//        while (!q.isEmpty()) {
//            double curSum = 0;
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = q.poll();
//                if (cur.children != null) {
//                    for (TreeNode each : cur.children) q.offer(each);
//                }
//                curSum += cur.salary;
//            }
//            res.add(curSum/size);
//        }
//    }
//
//    public static void main(String args) {
//        TreeNode E4 = new TreeNode(100);
//        TreeNode E3 = new TreeNode(100);
//        TreeNode E2 = new TreeNode(100);
//        TreeNode E1 = new TreeNode(100);
//        TreeNode M2 = new TreeNode(100);
//        TreeNode M1 = new TreeNode(100);
//        TreeNode CEO = new TreeNode(100);
//        M1.children.add(E1);
//        M1.children.add(E2);
//        M1.children.add(E3);
//        M2.children.add(E4);
//        CEO.children.add(M1);
//        CEO.children.add(M2);
//        Mock_BFS_Employee_Salary sol = new  Mock_BFS_Employee_Salary();
//        System.out.println(sol.avgSalary(CEO));
//    }
//}
