/*
https://leetcode.com/problems/number-of-provinces/

--traverse graph, not matrix; matrix here is the RELATIONSHIP between graph nodes
-- each row in matrix represents a node, traverse rows to find nodes connection
-- put node in queue, not coordinate, so this q is a list, use "visited" to keep visited matrix
1. traverse each row, if !visited -> bfs -> update result
2. bfs: use for loop go over each column to find connection -> find -> update queue and visited
        -- store point in queue

 */
import java.util.*;

public class Provinces_Number_547 {

    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        for (int city = 0; city < len; city++) {
            if (!visited[city]) {
                bfs(isConnected, city, visited);
                res++;
            }
        }
        return res;
    }

    private void bfs(int[][] isConnected, int city, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(city);
        visited[city] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
