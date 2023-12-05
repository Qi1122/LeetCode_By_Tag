package algorithm.src;/*
https://leetcode.com/problems/course-schedule/

-- graph: construct a graph from giving inputs, graph构建的是点边的关系，key -> 点，value -> 相邻的所有点
-- 维持一个记录vertices indegree的list, indegree表示每一门课作为end的入度

1. 记录vertices indegree -> int[] indegree = new int[numCourses];
   when indegree[i] = 0 -> add to queue -> 扩展 -> update indegree
2. construct graph -> add each course to graph
                   -> for each course, add prerequisities to graph:
                                    graph.get(start).add(end);
                                    indegree[end]++;
3. for each element in indegree, do BFS
indegree[q.poll] = 0 -> update count
queue -> put indegree[i] == 0 into queue, 可以从这个点扩展出去
4. traverse indegree, put indegree[i] == 0 in queue
5. find neighbours -> if nei in graph, indegree[nei]--
               -> indegree[nei] == 0, add to queue
               -> if indegree[i] == 0 -> can take course -> update result
*/
import java.util.*;

public class Course_Schedule_I_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            graph.get(start).add(end);
            indegree[end]++;
        }
        //bfs
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        /*
        DO NOT use foreach loop, will offer wrong element to queue
        for (int item : indegree) {
            if (item == 0) q.offer(item);
        } 报错原因：这里需要对index进行操作，被加入q的是index，而不是元素本身
         */
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int nei : graph.get(cur)) {
                //cur is key in map, graph.get(cur) : get value(end class) -> list of connected nodes
                //q.poll() -> finish class -> can go to next course
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }
        return count == numCourses;
    }
}
