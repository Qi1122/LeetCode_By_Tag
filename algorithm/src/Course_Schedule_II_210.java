/*
https://leetcode.com/problems/course-schedule-ii/
 */
import java.util.*;

public class Course_Schedule_II_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            graph.get(start).add(end);
            indegree[end]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        System.out.print(q);
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            for (int nei : graph.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }
        if (result.size() != numCourses) return new int[0];
        return result.stream().mapToInt(i -> i).toArray();
    }
}
