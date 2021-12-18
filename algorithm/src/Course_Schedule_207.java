/*
https://leetcode.com/problems/course-schedule/
 */
import java.util.*;

public class Course_Schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            graph.get(start).add(end);
            indegree[end]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int nei : graph.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }
        return count == numCourses;
    }
}
